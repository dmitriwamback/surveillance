package core.profiler;

import java.util.Random;
import core.Assigner;

public class Profile {


    public String           firstName, 
                            lastName;

    public int              age;
    public int              score;
    public int              uniqueId;
    public String           uniqueIdentifier;
    public String           nationality;

    public Assigner.Trust   trustworthiness;

    public void initializeProfile(String firstName, String lastName, String nationality, int age) {

        if (age < 18) return;

        this.firstName          = firstName;
        this.lastName           = lastName;
        this.age                = age;
        this.nationality        = nationality;
        this.score              = 750;
        this.trustworthiness    = Assigner.Trust.Neutral;

        double n = new Random().nextDouble();
        while (n <= 0.0) {
            n = new Random().nextDouble();
        }
        double newId = n * 100000000;
        int id = (int)newId;
        if (id < 10000000) {
            id *= 10;
        }

        this.uniqueId = id;
        this.uniqueIdentifier = firstName + "-" + lastName + "-" + id;
    }

    private void modifyTrustworthiness() {

        if (score <= 800  && score > 700)    trustworthiness = Assigner.Trust.Neutral;
        if (score <= 900  && score > 800)    trustworthiness = Assigner.Trust.Good;
        if (score <= 1100 && score > 900)    trustworthiness = Assigner.Trust.Satisfactory;
        if (score <= 1200 && score > 1100)   trustworthiness = Assigner.Trust.Merit;
        if (score <= 1300 && score > 1200)   trustworthiness = Assigner.Trust.Excellence;
        if (score <= 1500 && score > 1400)   trustworthiness = Assigner.Trust.Honored;

        if (score <= 700  && score >  600)   trustworthiness = Assigner.Trust.Neutral;
        if (score <= 600  && score >  500)   trustworthiness = Assigner.Trust.Dissatisfaction;
        if (score <= 500  && score >  300)   trustworthiness = Assigner.Trust.Imperfection;
        if (score <= 300  && score >  100)   trustworthiness = Assigner.Trust.Incompetent;
        if (score <= 100  && score > -500)   trustworthiness = Assigner.Trust.Inferiority;
        if (score <=-500)                    trustworthiness = Assigner.Trust.Dishonor;
    }

    public void deductScore(int score) {
        this.score -= score;
        if (this.score < -1000) { this.score = -1000; }
        modifyTrustworthiness();
    }

    public void increaseScore(int score) {
        this.score += score;
        if (this.score > 1500) { this.score = 1500; }
        modifyTrustworthiness();
    }
}
