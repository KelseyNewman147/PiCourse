package com.theironyard.charlotte.PiCourse;

import com.pi4j.io.gpio.*;

/**
 * Created by kelseynewman on 6/7/17.
 */
public class RaspberryPiManager {
  private final GpioController gpio;
  private GpioPinDigitalOutput testLED;

  public RaspberryPiManager() {
    gpio = GpioFactory.getInstance();
    testLED = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_02, "testLED", PinState.LOW);
  }

  public void toggleLED(String led) {
    if (led.equalsIgnoreCase("testled")) {
      testLED.toggle();
    }
  }
}
