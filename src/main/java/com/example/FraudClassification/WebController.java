package com.example.FraudClassification;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestParam;
//import com.example.FraudClassification.com.example.FraudClassification.FraudPrediction;

@Controller
public class WebController {

    @GetMapping("/")
    public String index(Model model){
        //String prediction = "Здесь будет предсказание характера операции";
        String amount = "720.38";
        String v26 = "-1.13363123097119";
        String v1 = "8.7444146436792";
        float[] line = new float[]{0.0f,-3.4204679837707f,-4.85057473189452f,6.60684578567387f,-2.80054617200457f,0.105511583647205f,-3.26980129883546f,0.940377922978903f,-2.55869060182863f,-3.62477471396623f,5.26786160380362f,-5.58369692598496f,0.173895592410693f,-6.67997675520914f,2.08419914311417f,-4.3488914455328f,-8.76078602293495f,-3.40754854415232f,1.33293006548133f,-1.81831542477292f,0.102912553839685f,0.311626102287519f,-4.12919549979785f,0.0346387321763146f,0.0f,0.272265246225774f,1.84130726881613f,-1.79636258672205f,0.0f};
        String prediction = FraudPrediction.Prediction(line);
        model.addAttribute("amount",amount);
        model.addAttribute("v1",v1);
        model.addAttribute("v26",v26);
        model.addAttribute("prediction",prediction);
        return "index";
    }
    @GetMapping("/sendline")
    public String send(@RequestParam("amount") String amount){
        //String prediction = "Здесь будет предсказание характера операции";
        //String amount = "720.38";
        //String v26 = "-1.13363123097119";
        //String v1 = "8.7444146436792";
        float[] line = new float[]{0.0f,-3.4204679837707f,-4.85057473189452f,6.60684578567387f,-2.80054617200457f,0.105511583647205f,-3.26980129883546f,0.940377922978903f,-2.55869060182863f,-3.62477471396623f,5.26786160380362f,-5.58369692598496f,0.173895592410693f,-6.67997675520914f,2.08419914311417f,-4.3488914455328f,-8.76078602293495f,-3.40754854415232f,1.33293006548133f,-1.81831542477292f,0.102912553839685f,0.311626102287519f,-4.12919549979785f,0.0346387321763146f,0.0f,0.272265246225774f,1.84130726881613f,-1.79636258672205f,0.0f};
        String prediction = FraudPrediction.Prediction(line);
        //model.addAttribute("amount",amount);
        //model.addAttribute("v1",v1);
        //model.addAttribute("v26",v26);
        //model.addAttribute("prediction",prediction);
        return "redirect:/";
    }
}
