package com.greenfoxacademy.cohort.controller;

import com.greenfoxacademy.cohort.models.Cohort;
import com.greenfoxacademy.cohort.models.Exam;
import com.greenfoxacademy.cohort.models.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CohortController {

    List<Cohort> cohorts;


    public CohortController() {
        this.cohorts = new ArrayList<>();
        List<Student> megalotisStudenst = new ArrayList<>();
        megalotisStudenst.add(new Student("Bela", "male", 31, new Exam("foundation", 31), new Exam("orientation", 22)));
        megalotisStudenst.add(new Student("Anna", "female", 24, new Exam("foundation", 43), new Exam("orientation", 12)));
        megalotisStudenst.add(new Student("Tamas", "male", 42, new Exam("foundation", 63), new Exam("orientation", 5)));

        List<Student> rueppelliStudenst = new ArrayList<>();
        rueppelliStudenst.add(new Student("Dezso", "male", 18, new Exam("foundation", 31), new Exam("orientation", 22)));
        rueppelliStudenst.add(new Student("Juli", "female", 24, new Exam("foundation", 43), new Exam("orientation", 12)));
        rueppelliStudenst.add(new Student("Eszter", "female", 42, new Exam("foundation", 63), new Exam("orientation", 5)));
        rueppelliStudenst.add(new Student("Mate", "male", 42, new Exam("foundation", 63), new Exam("orientation", 5)));

        Cohort megalotis = new Cohort("megalotis", "2018.01.20", megalotisStudenst);
        Cohort rueppelli = new Cohort("rueppelli", "2016.03.12", rueppelliStudenst);
        cohorts.add(megalotis);
        cohorts.add(rueppelli);
    }

    @GetMapping("/cohort")
    public String showCohorts(Model model) {
        model.addAttribute("cohorts", cohorts);
        return "cohort";
    }


    @RequestMapping("/cohort/{cohortIndex}/student")
    public String showStudents (Model model, @PathVariable int cohortIndex) {
        model.addAttribute("students", cohorts.get(cohortIndex).getStudents());
        return "student";
    }

    @RequestMapping("/cohort/{cohortIndex}/student/{studentIndex}/exam")
    public String showExams (Model model, @PathVariable int cohortIndex, @PathVariable int studentIndex) {
        model.addAttribute("exams", cohorts.get(cohortIndex).getStudents().get(studentIndex).getExams());
        return "exam";
    }

}
