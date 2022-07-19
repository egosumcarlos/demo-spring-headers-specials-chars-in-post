package com.example.demo;

import java.io.Serializable;

public class DummyDto implements Serializable {
  private String dni;

  public DummyDto() {
  }

  public DummyDto(String dni) {
    this.dni = dni;
  }

  public String getDni() {
    return dni;
  }

  public void setDni(String dni) {
    this.dni = dni;
  }
}
