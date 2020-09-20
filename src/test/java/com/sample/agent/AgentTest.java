package com.sample.agent;

import com.sun.tools.attach.VirtualMachine;
import com.sun.tools.attach.VirtualMachineDescriptor;

import java.util.List;

/**
 * @author aster
 */
public class AgentTest {
    public static void main(String[] args) {
        try {
            List<VirtualMachineDescriptor> virtualMachineDescriptorList = VirtualMachine.list();
            String tomcatPID = "";
            for (VirtualMachineDescriptor descriptor : virtualMachineDescriptorList) {
                System.out.println(descriptor.id() + "," + descriptor.displayName());
                if ((descriptor.displayName().startsWith("org.apache.catalina.startup.Bootstrap start"))) {
                    tomcatPID = descriptor.id();
                    break;
                }
            }

            VirtualMachine vm = VirtualMachine.attach(tomcatPID);
            // TODO replace path for your agent jar
            vm.loadAgent("~/Attach-Agent/target/agent-demo-1.0-SNAPSHOT.jar", "args-from-test");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
