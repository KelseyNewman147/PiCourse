package com.theironyard.charlotte.PiCourse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by kelseynewman on 6/7/17.
 */
@Controller
public class PiCourseController {
  private RaspberryPiManager piManager;

  public PiCourseController() {
    piManager = new RaspberryPiManager();
  }

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String home (Model model, String led){
      if (led != null) {
        piManager.toggleLED(led);
      }
      return "index";
    }
}
