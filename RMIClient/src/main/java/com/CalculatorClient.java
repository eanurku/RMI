package com;

import com.model.Calculator;

import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class CalculatorClient {

    static String registryHost="127.0.0.1";
    static int registryPort=1099;
    static String calculatorServicePublicName="calculator";
    public static void main(String[] args) throws RemoteException, NotBoundException {

        Registry registry = LocateRegistry.getRegistry(registryHost, registryPort);
        Calculator calculatorStub = (Calculator) registry.lookup(calculatorServicePublicName);
        
        //use returned object from remote service in client side
        int sum = calculatorStub.add(13, 14);
        System.out.println("sum="+sum);
        

    }
}
