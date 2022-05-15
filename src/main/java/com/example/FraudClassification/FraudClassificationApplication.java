package com.example.FraudClassification;
import ai.catboost.CatBoostError;
import ai.catboost.CatBoostModel;
import ai.catboost.CatBoostPredictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/*
	*@author Alex Bocharov
	* model is trained on this dataset (https://www.kaggle.com/datasets/mlg-ulb/creditcardfraud?resource=download)
 */

@SpringBootApplication
public class FraudClassificationApplication{

		static final Logger log =
				LoggerFactory.getLogger(FraudClassificationApplication.class);

		public static void main (String[]args){

			SpringApplication.run(FraudClassificationApplication.class, args);

			log.info("app started.");
		}
}
