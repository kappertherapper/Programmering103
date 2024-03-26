package Opgaver;

import java.util.Objects;

public class Bil {
    private String registreringsnummer;
    private String mærke;
    private String model;
    private String farve;

    // Constructor
    public Bil(String registreringsnummer, String mærke, String model, String farve) {
        this.registreringsnummer = registreringsnummer;
        this.mærke = mærke;
        this.model = model;
        this.farve = farve;
    }

    // Getters og setters
    public String getRegistreringsnummer() {
        return registreringsnummer;
    }

    public void setRegistreringsnummer(String registreringsnummer) {
        this.registreringsnummer = registreringsnummer;
    }

    public String getMærke() {
        return mærke;
    }

    public void setMærke(String mærke) {
        this.mærke = mærke;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getFarve() {
        return farve;
    }

    public void setFarve(String farve) {
        this.farve = farve;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        Bil bil = (Bil) obj;
        return registreringsnummer.equals(bil.registreringsnummer) && mærke.equals(bil.mærke);
    }

    @Override
    public int hashCode() {
        return Objects.hash(registreringsnummer, mærke);
    }

    @Override
    public String toString() {
        return "Bil{" +
                "registreringsnummer='" + registreringsnummer + '\n' +
                ", mærke='" + mærke + '\n' +
                ", model='" + model + '\n' +
                ", farve='" + farve + '\n' +
                '}';
    }
}

