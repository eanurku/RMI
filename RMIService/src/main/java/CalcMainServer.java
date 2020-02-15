import com.model.Calculator;
import com.impl.CalculatorImpl;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class CalcMainServer {
    static String registryHost="127.0.0.1";
    static int registryPort=1099;
    public static void main(String[] args) throws RemoteException, AlreadyBoundException {

        Calculator calcObject=new CalculatorImpl();

        Calculator calcstub = (Calculator)UnicastRemoteObject.exportObject(calcObject, 0);

        LocateRegistry.createRegistry(registryPort);
        Registry registry = LocateRegistry.getRegistry(registryHost, registryPort);
        registry.bind("calculator",calcstub);
        System.out.println("rmi registry is up and runnning with calculator service.....");

    }
}
