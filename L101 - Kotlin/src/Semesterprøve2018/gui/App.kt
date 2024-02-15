package Semesterprøve2018.gui

import Semesterprøve2018.controller.Controller
import Semesterprøve2018.model.Uddannelse
import java.time.LocalDate
import java.time.LocalTime


class App {
    fun initStorage() {


        //Uddannelser
        val DMU: Uddannelse = Controller.createUddannelse("DMU")
        val FINØ: Uddannelse = Controller.createUddannelse("FINØ")


        //Hold
        val et: Hold = Controller.createHold("1dmE17S", "Margrethe Dybdahl")
        val to: Hold = Controller.createHold("1dmE17T", "Kristian Dorland")
        val tre: Hold = Controller.createHold("1dmE17U", "Kell Ørhøj")
        val fire: Hold = Controller.createHold("1fiE17B", "Karen Jensen")


        //Hold til uddannelse
        DMU.addHold(et)
        DMU.addHold(to)
        DMU.addHold(tre)
        FINØ.addHold(fire)


        //Tutors
        val anders = Controller.createTutor("Anders Hansen", "aaa@students.eaaa.dk")
        val peter = Controller.createTutor("Peter Jensen", "ppp@students.eaaa.dk")
        val niels = Controller.createTutor("Niels Madsen", "nnn@students.eaaa.dk")
        val lone = Controller.createTutor("Lone Andersen", "lll@students.eaaa.dk")
        val mads = Controller.createTutor("Mads Miller", "mmm@students.eaaa.dk")

        //Tutor på hold
        Controller.addTutorToHold(anders, et);
        Controller.addTutorToHold(lone, et);
        Controller.addTutorToHold(peter, tre);
        Controller.addTutorToHold(niels, tre);
        Controller.addTutorToHold(mads, fire);


        //Arrangementer
        val rusfest = Controller.createArragement(
            "Rusfest",
            LocalDate.of(2017, 8, 31),
            LocalTime.parse("18:00"),
            LocalTime.parse("23:30"),
            250.0
        )
        val fodbold = Controller.createArragement(
            "Rusfest",
            LocalDate.of(2017, 8, 30),
            LocalTime.parse("14:00"),
            LocalTime.parse("17:30"),
            100.0
        )
        val brætspil = Controller.createArragement(
            "Rusfest",
            LocalDate.of(2017, 8, 29),
            LocalTime.parse("12:00"),
            LocalTime.parse("16:30"),
            25.0
        )
        val mindeparken = Controller.createArragement(
            "Rusfest",
            LocalDate.of(2017, 8, 30),
            LocalTime.parse("18:00"),
            LocalTime.parse("22:30"),
            25.0
        )



    }
}