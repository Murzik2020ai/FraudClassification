package com.example.FraudClassification;

import ai.catboost.CatBoostError;
import ai.catboost.CatBoostModel;
import ai.catboost.CatBoostPredictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
/*
 *@author Alex Bocharov
 * model is trained on this dataset (https://www.kaggle.com/datasets/mlg-ulb/creditcardfraud?resource=download)
 */

public class FraudPrediction{

    //static final Logger log =
    //        LoggerFactory.getLogger(com.example.com.example.FraudClassification.FraudPrediction.class);

    public static String Prediction (float[]line){

        CatBoostModel clf = null;
        try {
            clf = CatBoostModel.loadModel("./src/main/resources/model/clf_cb03.cbm");
            //log.info("model loaded.");
        } catch (CatBoostError cbe){
            //log.info("model not loaded.");
        }

        //float[] line = new float[]{0.1f, 0.2f, 0.9f, 0.7f, 0.1f, 0.4f, 0.5f, 0.8f, 0.9f, 0.5f, 0.2f, 0.3f, 0.5f, 0.6f, 1.0f, 0.4f, 0.5f, 0.6f, 0.3f, 0.4f, 0.5f, 0.6f, 1.2f, 0.3f, 0.3f, 1.0f, 1.01f, 0.1f, 1.1f};
        //float[] line = new float[]{0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f};
        //float[] line = new float[]{-8.7444146436792f,-3.4204679837707f,-4.85057473189452f,6.60684578567387f,-2.80054617200457f,0.105511583647205f,-3.26980129883546f,0.940377922978903f,-2.55869060182863f,-3.62477471396623f,5.26786160380362f,-5.58369692598496f,0.173895592410693f,-6.67997675520914f,2.08419914311417f,-4.3488914455328f,-8.76078602293495f,-3.40754854415232f,1.33293006548133f,-1.81831542477292f,0.102912553839685f,0.311626102287519f,-4.12919549979785f,0.0346387321763146f,-1.13363123097119f,0.272265246225774f,1.84130726881613f,-1.79636258672205f,720.38f};
        //float[] line = new float[]{0.0f,-3.4204679837707f,-4.85057473189452f,6.60684578567387f,-2.80054617200457f,0.105511583647205f,-3.26980129883546f,0.940377922978903f,-2.55869060182863f,-3.62477471396623f,5.26786160380362f,-5.58369692598496f,0.173895592410693f,-6.67997675520914f,2.08419914311417f,-4.3488914455328f,-8.76078602293495f,-3.40754854415232f,1.33293006548133f,-1.81831542477292f,0.102912553839685f,0.311626102287519f,-4.12919549979785f,0.0346387321763146f,0.0f,0.272265246225774f,1.84130726881613f,-1.79636258672205f,0.0f};
        CatBoostPredictions prediction = null;
        try {
            prediction = clf.predict(line, new String [0]);
            //prediction = clf.predict(line, new String[]{"clf"});
        } catch (CatBoostError cbe){
            //log.info("prediction error.");
        }
        //log.info("app started. Prediction is " + result(sigmoid(prediction.get(0, 0))));
        String res = result(sigmoid(prediction.get(0, 0)));
        return res;
    }
    public static double sigmoid(final double x) {
        return 1. / (1 + Math.pow(Math.E, -x));
    }
    public static String result(final double x){
        if (x < 0.5) {
            return "operation normal";
        }
        return "!fraud operation!";
    }
}
