package org.academiadecodigo.apiores.test.cutscene;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Cutscene {


    public void rocketCutscene()throws InterruptedException{
        Picture pic = new Picture(10,10, "rocket-cutscene/Frame1.png");
        pic.draw();
        Thread.sleep(800);

        pic.load("rocket-cutscene/Frame2.png");
        Thread.sleep(400);

        pic.load("rocket-cutscene/Frame3.png");
        Thread.sleep(2000);

        pic.load("rocket-cutscene/Frame2.png");
        Thread.sleep(400);

        pic.load("rocket-cutscene/Frame4.png");
        Thread.sleep(2000);

        pic.load("rocket-cutscene/Frame5.png");
        Thread.sleep(300);

        pic.load("rocket-cutscene/Frame6.png");
        Thread.sleep(200);

        pic.load("rocket-cutscene/Frame7.png");
        Thread.sleep(200);

        pic.load("rocket-cutscene/Frame8.png");
        Thread.sleep(200);

        pic.load("rocket-cutscene/Frame9.png");
        Thread.sleep(200);

        pic.load("rocket-cutscene/Frame10.png");
        Thread.sleep(200);

        pic.load("rocket-cutscene/Frame11.png");
        Thread.sleep(200);

        pic.load("rocket-cutscene/Frame12.png");
        Thread.sleep(200);


        pic.load("rocket-cutscene/Frame13.png");
        Thread.sleep(200);

        pic.delete();
    }



    public void landingCutscene()throws InterruptedException{
        Picture pic = new Picture(10,10,"landing-cutscene/End1.png");

        pic.draw();
        Thread.sleep(800);

        pic.load("landing-cutscene/End2.png");
        Thread.sleep(400);

        pic.load("landing-cutscene/End3.png");
        Thread.sleep(1000);

        pic.load("landing-cutscene/EndText1.png");
        Thread.sleep(2000);

        pic.load("landing-cutscene/End3.png");
        Thread.sleep(500);

        pic.load("landing-cutscene/EndText2.png");
        Thread.sleep(2000);

        pic.load("landing-cutscene/End3.png");
        Thread.sleep(200);

        pic.load("landing-cutscene/End4.png");
        Thread.sleep(200);

        pic.load("landing-cutscene/End5.png");
        Thread.sleep(200);

        pic.load("landing-cutscene/End6.png");
        Thread.sleep(200);

        pic.load("landing-cutscene/End7.png");
        Thread.sleep(200);

        pic.load("landing-cutscene/End8.png");
        Thread.sleep(200);

        pic.load("landing-cutscene/End9.png");
        Thread.sleep(200);

        pic.load("landing-cutscene/End10.png");
        Thread.sleep(200);

        pic.load("landing-cutscene/End11.png");
        Thread.sleep(1000);

        pic.delete();

    }



}
