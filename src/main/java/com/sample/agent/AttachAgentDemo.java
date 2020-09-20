package com.sample.agent;

import java.lang.instrument.Instrumentation;

/**
 * @author aster
 * 启动agent
 */
public class AttachAgentDemo {
    /**
     * -attach agent
     * */
    public static void agentmain(String agentArgs, Instrumentation inst) {
        System.out.println("load agent after main run. args=" + agentArgs);

        Class<?>[] classes = inst.getAllLoadedClasses();
        for (Class<?> cls : classes) {
            System.out.println(cls.getName());
        }

        System.out.println("agent run completely");
    }
}
