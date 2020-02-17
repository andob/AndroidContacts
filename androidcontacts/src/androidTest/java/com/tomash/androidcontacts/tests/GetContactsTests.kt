package com.tomash.androidcontacts.tests

import com.tomash.androidcontacts.BaseTest
import com.tomash.androidcontacts.contactgetter.entity.ContactData
import com.tomash.androidcontacts.contactgetter.entity.PhoneNumber
import com.tomash.androidcontacts.contactgetter.main.Sorting
import com.tomash.androidcontacts.contactgetter.main.contactsGetter.ContactsGetterBuilder
import com.tomash.androidcontacts.contactgetter.main.contactsSaver.ContactsSaverBuilder
import com.tomash.androidcontacts.utils.TestUtils
import org.junit.Assert
import org.junit.Test
import java.util.*

class GetContactsTests : BaseTest() {

    private fun createRandomList(listAction: (List<ContactData>) -> Unit): List<ContactData> {
        val savedData = generateListOfRandomContacts()
        listAction(savedData)
        ContactsSaverBuilder(mCtx)
            .saveContactsList(savedData)
        return savedData
    }

    private fun getList(builderFunc: ContactsGetterBuilder.() -> ContactsGetterBuilder): List<ContactData> {
        return builderFunc(ContactsGetterBuilder(mCtx)
            .allFields())
            .buildList()
    }

    @Test
    @Throws(Exception::class)
    fun correctlyGetsValidContacts() {
        val savedData = createRandomList {}
        savedData.forEachIndexed { index, _ ->
            val randomContact = savedData[index]
            val savedList = getList { withName(randomContact.compositeName) }
            Assert.assertEquals(1, savedList.size)
            assertContacts(randomContact, savedList.first(), index.inc())
        }
    }

    @Test
    @Throws(Exception::class)
    fun queryingByPhoneWorksCorrectly() {
        val savedData = createRandomList {
            it.take(it.size / 2).forEach { it.phoneList.clear() }
        }
        val savedList = getList { onlyWithPhones() }
        Assert.assertEquals((savedData.size / 2).toLong(), savedList.size.toLong())
    }

    @Test
    @Throws(Exception::class)
    fun ascendingNameSortingWorksAsExpected() {
        val savedData = createRandomList {}
        val savedList = getList { setSortOrder(Sorting.BY_DISPLAY_NAME_ASC) }
        savedData.sortedBy { it.compositeName }.forEachIndexed { index, contactData ->
            Assert.assertTrue(savedList[index].compositeName == contactData.compositeName)
        }
    }

    @Test
    @Throws(Exception::class)
    fun descendingNameSortingWorksAsExpected() {
        val savedData = createRandomList {}
        val savedList = getList { setSortOrder(Sorting.BY_DISPLAY_NAME_DESC) }
        savedData.sortedByDescending { it.compositeName }.forEachIndexed { index, contactData ->
            Assert.assertTrue(savedList[index].compositeName == contactData.compositeName)
        }
    }

    @Test
    fun ascendingByIsSortingWorking() {
        createRandomList {}
        getList { setSortOrder(Sorting.BY_ID_ASC) }.zipWithNext().forEach {
            Assert.assertTrue(it.first.contactId < it.second.contactId)
        }
    }

    @Test
    fun descendingByIdSortingIsWorking() {
        createRandomList {}
        getList { setSortOrder(Sorting.BY_ID_DESC) }.zipWithNext().forEach {
            Assert.assertTrue(it.first.contactId > it.second.contactId)
        }
    }

    @Throws(Exception::class)
    private fun generateListOfRandomContacts(): List<ContactData> {
        val dataList = ArrayList<ContactData>()
        for (i in 1..50) {
            dataList.add(TestUtils.createRandomContactData(mCtx, i))
        }
        return dataList
    }

}
