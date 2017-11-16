package br.com.vagas.merchantsguide.model.expressions;

import br.com.vagas.merchantsguide.factory.CheckLanguage;

public class ErrorExpression implements Expression {

	public void evaluate() {
		System.out.println(CheckLanguage.Error);
	}

}
