package r;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainApp
{
    public static void main( String[] args )
    {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(MainAppConfig.class);

        MyBean myBean = ctx.getBean(MyBean.class);

        System.out.println("ok. Let go");
    }
}
