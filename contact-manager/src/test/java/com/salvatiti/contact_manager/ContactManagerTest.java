package com.salvatiti.contact_manager;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

@TestInstance(TestInstance.Lifecycle.PER_CLASS) // using this anotation u can avoid static from beforeAll and afterAll
class ContactManagerTest {

  ContactManager contactManager; // new instance of the class

  @BeforeAll
  public static void setupAll() { // Must be static method

    System.out.println("Print before All Test");
  }

  @BeforeEach
  public void setup() {

    // before every test, we create the new ContactManager
    contactManager = new ContactManager();
  }

  @Test
  public void shouldCreateContact() {

    contactManager.addContact("Juan", "Ramirez", "123456789");
    assertFalse(contactManager.getAllContacts().isEmpty()); // ok because there is 1 contact
    assertEquals(1, contactManager.getAllContacts().size()); // ok, expected 1 and there is 1
    // assertEquals(2, contactManager.getAllContacts().size()); error because size is 1;

    assertTrue(contactManager
        .getAllContacts().stream().filter(contact -> contact.getFirstName().equals("Juan")
            && contact.getLastName().equals("Ramirez") && contact.getPhoneNumber().equals("123456789"))
        .findAny().isPresent());

  }

  @Test
  @DisplayName("Should not create contact if first name is null")
  public void shouldThrowRuntimeExceptionWhenFirstNameIsNull() {

    // Throw exception is firstName is null, the test is ok because firstName is null
    assertThrows(RuntimeException.class, () -> {
      contactManager.addContact(null, "Ramirez", "123456789");
    });
  }

  @Test
  @DisplayName("Should not create contact if last name is null")
  public void shouldThrowRuntimeExceptionWhenLastNameIsNull() {

    // Throw exception is lastName is null, the test is ok because lastName is null
    assertThrows(RuntimeException.class, () -> {
      contactManager.addContact("Juan", null, "123456789");
    });
  }

  @Test
  @DisplayName("Should not create contact if phone number name is null")
  public void shouldThrowRuntimeExceptionWhenPhoneNumberIsNull() {

    // Throw exception is phoneNumber is null, the test is ok because phoneNumber is null
    assertThrows(RuntimeException.class, () -> {
      contactManager.addContact("Juan", "Ramirez", null);
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

    contactManager.addContact("Juan", "Ramirez", "123456789");
    assertFalse(contactManager.getAllContacts().isEmpty()); // ok because there is 1 contact
    assertEquals(1, contactManager.getAllContacts().size()); // ok, expected 1 and there is 1
    // assertEquals(2, contactManager.getAllContacts().size()); error because size is 1;

    assertTrue(contactManager
        .getAllContacts().stream().filter(contact -> contact.getFirstName().equals("Juan")
            && contact.getLastName().equals("Ramirez") && contact.getPhoneNumber().equals("123456789"))
        .findAny().isPresent());

  }

  @Test
  @DisplayName("You can only create a new contact in MAC OS")
  @EnabledOnOs(value = OS.MAC, disabledReason = "Enabled only on Mac") // Enable for an specific OS
  public void shouldCreateContactOnlyOnMac() {

    contactManager.addContact("Juan", "Ramirez", "123456789");
    assertFalse(contactManager.getAllContacts().isEmpty()); // ok because there is 1 contact
    assertEquals(1, contactManager.getAllContacts().size()); // ok, expected 1 and there is 1
    // assertEquals(2, contactManager.getAllContacts().size()); error because size is 1;

    assertTrue(contactManager
        .getAllContacts().stream().filter(contact -> contact.getFirstName().equals("Juan")
            && contact.getLastName().equals("Ramirez") && contact.getPhoneNumber().equals("123456789"))
        .findAny().isPresent());

  }

  @DisplayName("Method Source, The Phone must match with the require Format")
  @ParameterizedTest
  @MethodSource("phoneNumberList")
  public void testPhoneNumberFormatUsingMethodSource(String phoneNumber) {

    // Using a method for creating new values
    contactManager.addContact("Juan", "Ramirez", phoneNumber);
    assertFalse(contactManager.getAllContacts().isEmpty()); // ok because there is 1 contact
    assertEquals(1, contactManager.getAllContacts().size()); // ok, expected 1 and there is 1
    // assertEquals(2, contactManager.getAllContacts().size()); error because size is 1;

  }

  private List<String> phoneNumberList() {

    return Arrays.asList("123456789", "987654321");
  }

  // Nested u can only use @BeforeEach and @AfterEach
  // But u cannot use @BeforeAll and @AfterAll
  @Nested
  class RepeatedNestedTest {

    @DisplayName("Repeat Contact Creation Test 5 times")
    @RepeatedTest(value = 5, name = "Repeating Contact Creation Test {currentRepetition} of {totalRepetitions}")
    public void shouldCreateContactRepeatedly() {

      // how many times u want the test to be repeatedly
      contactManager.addContact("Juan", "Ramirez", "123456789");
      assertFalse(contactManager.getAllContacts().isEmpty()); // ok because there is 1
      // contact
      assertEquals(1, contactManager.getAllContacts().size()); // ok, expected 1 and there
      // is 1
      // assertEquals(2, contactManager.getAllContacts().size()); error because size is 1;

    }
  }

  @Nested
  class ParameterizedNestedTest {

    @DisplayName("Contact Creation Using Value Source")
    @ParameterizedTest
    @ValueSource(strings = { "123456789", "f987654321" }) // this last one will fail because it start with a letter
    @CsvSource({ "123456789", "f987654321" }) // same but not need to specify string
    public void testContactCreationUsingValueSource(String phoneNumber) {

      // Using parameters for creating a new value
      contactManager.addContact("Juan", "Ramirez", phoneNumber);
      assertFalse(contactManager.getAllContacts().isEmpty()); // ok because there is 1
      // contact
      assertEquals(1, contactManager.getAllContacts().size()); // ok, expected 1 and there
      // is 1
      // assertEquals(2, contactManager.getAllContacts().size()); error because size is 1;

    }

    @DisplayName("CSV Source")
    @ParameterizedTest
    @CsvFileSource(resources = "/data.csv")
    public void testContactCreationUsingCSVFileSource(String phoneNumber) {

     contactManager.addContact("Juan", "Ramirez", phoneNumber);
      assertFalse(contactManager.getAllContacts().isEmpty()); // ok because there is 1
                                                                                           // contact
      assertEquals(1,contactManager.getAllContacts().size()); // ok, expected 1 and there
                                                                                            // is 1
      // assertEquals(2, contactManager.getAllContacts().size()); error because size is 1;

    }

  }

}
