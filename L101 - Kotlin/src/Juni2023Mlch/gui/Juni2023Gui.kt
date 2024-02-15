package gui

import controller.Controller
import javafx.application.Application
import javafx.geometry.Insets
import javafx.scene.Scene
import javafx.scene.control.*
import javafx.scene.layout.GridPane
import javafx.stage.Stage
import model.Bane
import model.Booking
import model.Spiller
import storage.Storage
import java.time.LocalDate
import java.time.LocalTime


class Juni2023Gui : Application() {

    override fun start(primaryStage: Stage) {
        val stage = primaryStage //?: throw Exception()
        stage.title = "Bane bookings"
        val pane = GridPane()
        this.initContent(pane)

        val scene = Scene(pane)
        stage.scene = scene
        stage.show()
    }

    // -------------------------------------------------------------------------

    private val lvwBaner = ListView<Bane>()
    private val txaAntalBookninger = TextArea()
    private val lvwSpillere = ListView<Spiller>()
    private val txfDato = TextField()
    private val txfTid = TextField()
    private val cbxSingle = CheckBox("Single")
    private val txaBookings = TextArea()

    private fun initContent(pane: GridPane) {
        with(pane) {
            isGridLinesVisible = false
            padding = Insets(20.0)
            hgap = 20.0
            vgap = 10.0
        }

        val lblBaner = Label("Baner")
        pane.add(lblBaner, 0, 0)

        with(lvwBaner) {
            prefWidth = 250.0
            prefHeight = 200.0
            items.setAll(Storage.alleBaner)
            selectionModel.selectedItemProperty()
                .addListener { _, _, _ -> fillAntalBookinger() }
        }
        pane.add(lvwBaner, 0, 1)


        val lblAntalBookninger = Label("Antal bookinger på banen")
        pane.add(lblAntalBookninger, 0, 2)

        with(txaAntalBookninger) {
            prefWidth = 250.0
            prefHeight = 150.0
        }
        pane.add(txaAntalBookninger, 0, 3, 1, 5)

        //-------------------

        val lblSpillere = Label("Spillere")
        pane.add(lblSpillere, 1, 0)

        with(lvwSpillere) {
            prefWidth = 150.0
            prefHeight = 200.0
            items.setAll(Storage.alleSpillere)
            selectionModel.selectedItemProperty()
                .addListener { _, _, _ -> fillTxaBookinger() }
        }
        pane.add(lvwSpillere, 1, 1)

        //-------------------

        val lblBookings = Label("Spillerens bookinger")
        pane.add(lblBookings, 2, 0, 2, 1)

        with(txaBookings) {
            prefWidth = 300.0
            prefHeight = 200.0
        }
        pane.add(txaBookings, 2, 1, 2, 1)

        val lblOpretBooking = Label("Opret booking:")
        pane.add(lblOpretBooking, 2, 2)

        val lblDato = Label("Dato:")
        pane.add(lblDato, 2, 3)

        pane.add(txfDato, 3, 3)

        val lblTid = Label("Tid:")
        pane.add(lblTid, 2, 4)

        pane.add(txfTid, 3, 4)

        pane.add(cbxSingle, 3, 5)

        val btnBook = Button("Book bane til spiller")
        btnBook.setOnAction { bookAction() }
        pane.add(btnBook, 2, 6, 2, 1)
    }

    private fun fillAntalBookinger() {
        val bane: Bane? = lvwBaner.selectionModel.selectedItem
        if (bane == null) return

        txaAntalBookninger.clear()
        for ((index, value) in bane.antalBookningerPrTime().withIndex()) {
            val hour = bane.førsteTid.hour + index
            txaAntalBookninger.appendText("Tid: $hour\t antal: $value\n")
        }
    }

    private fun fillTxaBookinger() {
        val spiller: Spiller? = lvwSpillere.selectionModel.selectedItem

        txaBookings.clear()
        if (spiller == null) return
        for (booking: Booking in spiller.bookings) {
            txaBookings.appendText(booking.toString() + "\n")
        }
    }

    private fun bookAction() {
        val bane: Bane? = lvwBaner.selectionModel.selectedItem
        val spiller: Spiller? = lvwSpillere.selectionModel.selectedItem
        if (bane == null || spiller == null) {
            val alert = Alert(Alert.AlertType.ERROR)
            with(alert) {
                title = "Book bane til spiller"
                headerText = "Bane eller spiller er ikke valgt"
                contentText = "Vælg både en bane og en spiller."
            }
            alert.showAndWait()
            // wait for the modal dialog to close
            return
        }

        val dato = LocalDate.parse(txfDato.text.trim { it <= ' ' })
        val tid = LocalTime.parse(txfTid.text.trim { it <= ' ' })
        val single = cbxSingle.isSelected
        if (bane.tidLedig(dato, tid)) {

            Controller.opretBooking(dato, tid, single, spiller, bane)

            fillTxaBookinger()
            fillAntalBookinger()
        } else {
            val alert = Alert(Alert.AlertType.ERROR)
            with(alert) {
                title = "Book bane til spiller"
                headerText = "Banen er ikke ledig $dato kl. $tid"
                contentText = "Vælg et andet tidspunkt."
            }
            alert.showAndWait()
            // wait for the modal dialog to close
        }
    }
}
