package Transformation;

import cucumber.api.Transformer;

public class TransformerClasse extends Transformer<String > {

    @Override
    public String transform (String email){
        return email.concat("@gmail.com");
    }
}
