package com.czk.module_annotation_compiler;

import com.czk.moudle_annotation.annotation.Module;
import com.google.auto.service.AutoService;
import com.squareup.javapoet.ClassName;
import com.squareup.javapoet.TypeName;

import java.util.Collections;
import java.util.Set;

import javax.annotation.processing.Filer;
import javax.annotation.processing.Messager;
import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.Processor;
import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.RoundEnvironment;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;
import javax.lang.model.util.Elements;
import javax.lang.model.util.Types;

/**
 * 注解处理器
 * create by czk at 2019-11-25
 */
@AutoService(Processor.class)
public class EnvironmentProcessor extends AbstractProcessor{

    public static final String ENVIRONMENT = "Environment";

    public static final String METHOD_NAME_GET_XX_ENVIRONMENT = "get%sEnvironment";
    public static final String METHOD_NAME_GET_XX_ENVIRONMENT_BEAN = "get%sEnvironmentBean";
    public static final String METHOD_NAME_SET_XX_ENVIRONMENT = "set%sEnvironment";
    public static final String METHOD_NAME_ADD_ON_ENVIRONMENT_CHANGE_LISTENER = "addOnEnvironmentChangeListener";
    public static final String METHOD_NAME_REMOVE_ON_ENVIRONMENT_CHANGE_LISTENER = "removeOnEnvironmentChangeListener";
    public static final String METHOD_NAME_REMOVE_ALL_ON_ENVIRONMENT_CHANGE_LISTENER = "removeAllOnEnvironmentChangeListener";
    public static final String METHOD_NAME_ON_ENVIRONMENT_CHANGE = "onEnvironmentChange";

    public static final String MODE_PRIVATE = "android.content.Context.MODE_PRIVATE";

    public static final String VAR_CONTEXT = "context";
    public static final String VAR_ENVIRONMENT_URL_SUFFIX = "Url";
    public static final String VAR_ENVIRONMENT_NAME_SUFFIX = "Name";
    public static final String VAR_ENVIRONMENT_ALIAS_SUFFIX = "Alias";
    public static final String VAR_MODULE_PREFIX = "MODULE_";
    public static final String VAR_DEFAULT_ENVIRONMENT_PREFIX = "DEFAULT_";
    public static final String VAR_DEFAULT_ENVIRONMENT_SUFFIX = "_ENVIRONMENT";
    public static final String VAR_CURRENT_XX_ENVIRONMENT = "sCurrent%sEnvironment";
    public static final String VAR_MODULE_LIST = "MODULE_LIST";
    public static final String VAR_ON_ENVIRONMENT_CHANGE_LISTENERS = "ON_ENVIRONMENT_CHANGE_LISTENERS";

    public static final String VAR_PARAMETER_ON_ENVIRONMENT_CHANGE_LISTENER = "onEnvironmentChangeListener";
    public static final String VAR_PARAMETER_IS_DEBUG = "isDebug";
    public static final String VAR_PARAMETER_MODULE = "module";
    public static final String VAR_PARAMETER_OLD_ENVIRONMENT = "oldEnvironment";
    public static final String VAR_PARAMETER_NEW_ENVIRONMENT = "newEnvironment";

    public static final TypeName CONTEXT_TYPE_NAME = ClassName.get("android.content", "Context");

    //获取一些工具类
    private Elements mElementUtils;
    private Types mTypeUtils;
    private Filer mFiler;
    private Messager mMessages;


    /**
     * 初始化处理器，一般在这里获取我们需要的工具类。
     */
    @Override
    public synchronized void init(ProcessingEnvironment env) {
        super.init(env);

        //Element代表程序的元素，例如包、类、方法。
        mElementUtils = env.getElementUtils();

        //处理TypeMirror的工具类，用于取类信息
        mTypeUtils = env.getTypeUtils();

        //Filer可以创建文件
        mFiler = env.getFiler();

        //错误处理工具
        mMessages = env.getMessager();
    }

    /**
     * 指定注解处理器是注册给哪个注解的，返回指定支持的注解类集合。
     * @return
     */
    @Override
    public Set<String> getSupportedAnnotationTypes() {
        //大部分class而已getName、getCanonicalNam这两个方法没有什么不同的。
        //但是对于array或内部类等就不一样了。
        //getName返回的是[[Ljava.lang.String之类的表现形式，
        //getCanonicalName返回的就是跟我们声明类似的形式。
        return Collections.singleton(Module.class.getCanonicalName());
    }

    /**
     * 指定java版本
     * @return
     */
    @Override
    public SourceVersion getSupportedSourceVersion() {
        return SourceVersion.RELEASE_7;
    }

    /**
     * 处理器实际处理逻辑入口
     *
     * 首先，我们梳理下一般处理器处理逻辑：
     * 1、遍历得到源码中，需要解析的元素列表。
     * 2、判断元素是否可见和符合要求。
     * 3、组织数据结构得到输出类参数。
     * 4、输入生成java文件。
     * 5、错误处理。
     *
     * @return
     */
    @Override
    public boolean process(Set<? extends TypeElement> set, RoundEnvironment roundEnvironment) {
        //1.获取注解列表
        Set<? extends Element> elements = roundEnvironment.getElementsAnnotatedWith(Module.class);

        //遍历得到源码中，需要解析的元素列表，获取到想要的数据
        for (Element element : elements) {

        }

        //

        return false;
    }
}
