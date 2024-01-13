package pl.projekt.procesfaktur;

import org.camunda.bpm.application.ProcessApplication;
import org.camunda.bpm.application.impl.ServletProcessApplication;

@ProcessApplication("Obieg faktury")
public class Faktura extends ServletProcessApplication{

}
