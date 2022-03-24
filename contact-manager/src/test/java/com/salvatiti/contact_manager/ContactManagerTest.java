package com.salvatiti.contact_manager;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ContactManagerTest {

  ContactManager contactManager = new ContactManager();

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

    assertThrows(RuntimeException.class, () -> {
      this.contactManager.addContact(null, "Ramirez", "123456789");
    });
  }

  @Test
  @DisplayName("Should not create contact if last name is null")
  public void shouldThrowRuntimeExceptionWhenLastNameIsNull() {

    assertThrows(RuntimeException.class, () -> {
      this.contactManager.addContact("Juan", null, "123456789");
    });
  }

  @Test
  @DisplayName("Should not create contact if phone number name is null")
  public void shouldThrowRuntimeExceptionWhenPhoneNumberIsNull() {

    assertThrows(RuntimeException.class, () -> {
      this.contactManager.addContact("Juan", "Ramirez", null);
    });
  }

}
