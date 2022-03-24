package com.salvatiti.contact_manager;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;

@TestInstance(TestInstance.Lifecycle.PER_CLASS) // using this anotation u can avoid static from beforeAll and afterAll
class ContactManagerTest {

  ContactManager contactManager; // new instance of the class

  @BeforeAll
  public static void setupAll() { // Must be static method

    System.out.println("Print before All Test");
  }

  @BeforeEach
  public void setup() {

    this.contactManager = new ContactManager();
  }

  @Test
  public void shouldCreateContact() {

    this.contactManager.addContact("Juan", "Ramirez", "123456789");
    assertFalse(this.contactManager.getAllContacts().isEmpty()); // ok because there is 1 contact
    assertEquals(1, this.contactManager.getAllContacts().size()); // ok, expected 1 and there is 1
    // assertEquals(2, contactManager.getAllContacts().size()); error because size is 1;

    assertTrue(this.contactManager
        .getAllContacts().stream().filter(contact -> contact.getFirstName().equals("Juan")
            && contact.getLastName().equals("Ramirez") && contact.getPhoneNumber().equals("123456789"))
        .findAny().isPresent());

  }

  @Test
  @DisplayName("Should not create contact if first name is null")
  public void shouldThrowRuntimeExceptionWhenFirstNameIsNull() {

    // Throw exception is firstName is null, the test is ok because firstName is null
    assertThrows(RuntimeException.class, () -> {
      this.contactManager.addContact(null, "Ramirez", "123456789");
    });
  }

  @Test
  @DisplayName("Should not create contact if last name is null")
  public void shouldThrowRuntimeExceptionWhenLastNameIsNull() {

    // Throw exception is lastName is null, the test is ok because lastName is null
    assertThrows(RuntimeException.class, () -> {
      this.contactManager.addContact("Juan", null, "123456789");
    });
  }

  @Test
  @DisplayName("Should not create contact if phone number name is null")
  public void shouldThrowRuntimeExceptionWhenPhoneNumberIsNull() {

    // Throw exception is phoneNumber is null, the test is ok because phoneNumber is null
    assertThrows(RuntimeException.class, () -> {
      this.contactManager.addContact("Juan", "Ramirez", null);
    });
  }

  @AfterEach
  public void tearDown() {

    System.out.println("It´s Executed after each test");
  }

  @AfterAll
  public static void tearDownAll() { // Must be static method

    System.out.println("It´s executed after all the test");
  }

  @Test
  @DisplayName("You can only create a new contact in Windows")
  @EnabledOnOs(value = OS.WINDOWS, disabledReason = "Enabled only on Windows") // Enable for an specific OS
  public void shouldCreateContactOnlyOnWindows() {

    this.contactManager.addContact("Juan", "Ramirez", "123456789");
    assertFalse(this.contactManager.getAllContacts().isEmpty()); // ok because there is 1 contact
    assertEquals(1, this.contactManager.getAllContacts().size()); // ok, expected 1 and there is 1
    // assertEquals(2, contactManager.getAllContacts().size()); error because size is 1;

    assertTrue(this.contactManager
        .getAllContacts().stream().filter(contact -> contact.getFirstName().equals("Juan")
            && contact.getLastName().equals("Ramirez") && contact.getPhoneNumber().equals("123456789"))
        .findAny().isPresent());

  }

  @Test
  @DisplayName("You can only create a new contact in MAC OS")
  @EnabledOnOs(value = OS.MAC, disabledReason = "Enabled only on Mac") // Enable for an specific OS
  public void shouldCreateContactOnlyOnMac() {

    this.contactManager.addContact("Juan", "Ramirez", "123456789");
    assertFalse(this.contactManager.getAllContacts().isEmpty()); // ok because there is 1 contact
    assertEquals(1, this.contactManager.getAllContacts().size()); // ok, expected 1 and there is 1
    // assertEquals(2, contactManager.getAllContacts().size()); error because size is 1;

    assertTrue(this.contactManager
        .getAllContacts().stream().filter(contact -> contact.getFirstName().equals("Juan")
            && contact.getLastName().equals("Ramirez") && contact.getPhoneNumber().equals("123456789"))
        .findAny().isPresent());

  }

}
