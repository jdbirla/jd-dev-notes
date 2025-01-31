package com.jd.interviewprep.designpattern.abstractfactory;

public class Test {

	public static void main(String[] args) {

		DaoAbstractFactory daf = DaoFactoryProducer.produce("db");
		Dao dao = daf.createDao("emp");
		dao.save();

	}

}
