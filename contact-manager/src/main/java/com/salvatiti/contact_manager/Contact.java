package com.salvatiti.contact_manager;

public class Contact {

  private String firstName;

  private String lastName;

  private String phoneNumber;

  public Contact(String firstName, String lastName, String phoneNumber) {

    this.firstName = firstName;
    this.lastName = lastName;
    this.phoneNumber = phoneNumber;
  }

  public String getFirstName() {

    return this.firstName;
  }

  public String getLastName() {

    return this.lastName;
  }

  public String getPhoneNumber() {

    return this.phoneNumber;
  }

  public void validateFirstName() { // firstName cannot be empty

    if (this.firstName.isBlank())
      throw new RuntimeException("First Name Cannot be null or empty");
  }

  public void validateLastName() { // lastName cannot be empty

    if (this.lastName.isBlank())
      throw new RuntimeException("Last Name Cannot be null or empty");
  }

  public void validatePhoneNumber() { // Validate if phoneNumber is correct

    if (this.phoneNumber.isBlank()) {
      throw new RuntimeException("Phone Name Cannot be null or empty");
    }

    if (this.phoneNumber.length() != 9) {
      throw new RuntimeException("Phone Number Should be 9 Digits Long");
    }
    if (!this.phoneNumber.matches("\\d+")) {
      throw new RuntimeException("Phone Number Contain only digits");
    }
    if (this.phoneNumber.startsWith("0")) {
      throw new RuntimeException("Phone Number Shouldn´t Start with 0");
    }
  }
}
