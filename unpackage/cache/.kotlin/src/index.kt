package uni.UNIEF9A735;
import io.dcloud.uniapp.*;
import io.dcloud.uniapp.extapi.*;
import io.dcloud.uniapp.framework.*;
import io.dcloud.uniapp.runtime.*;
import io.dcloud.uniapp.vue.*;
import io.dcloud.uniapp.vue.shared.*;
import io.dcloud.unicloud.*;
import io.dcloud.uts.*;
import io.dcloud.uts.Map;
import io.dcloud.uts.Set;
import io.dcloud.uts.UTSAndroid;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.async;
import io.dcloud.uniapp.appframe.AppConfig;
import io.dcloud.uniapp.vue.createSSRApp;
import io.dcloud.uniapp.extapi.exit as uni_exit;
import io.dcloud.uniapp.extapi.showToast as uni_showToast;
var firstBackTime: Number = 0;
open class GenApp : BaseApp {
    constructor(instance: ComponentInternalInstance) : super(instance) {
        onLaunch(fun(_: OnLaunchOptions) {
            console.log("App Launch", " at App.uvue:5");
        }
        , instance);
        onAppShow(fun(_: OnShowOptions) {
            console.log("App Show", " at App.uvue:8");
        }
        , instance);
        onHide(fun() {
            console.log("App Hide", " at App.uvue:11");
        }
        , instance);
        onLastPageBackPress(fun() {
            console.log("App LastPageBackPress", " at App.uvue:15");
            if (firstBackTime == 0) {
                uni_showToast(ShowToastOptions(title = "再按一次退出应用", position = "bottom"));
                firstBackTime = Date.now();
                setTimeout(fun(){
                    firstBackTime = 0;
                }, 2000);
            } else if (Date.now() - firstBackTime < 2000) {
                firstBackTime = Date.now();
                uni_exit(null);
            }
        }
        , instance);
        onExit(fun() {
            console.log("App Exit", " at App.uvue:32");
        }
        , instance);
    }
    companion object {
        val styles: Map<String, Map<String, Map<String, Any>>>
            get() {
                return normalizeCssStyles(utsArrayOf(
                    styles0
                ));
            }
        val styles0: Map<String, Map<String, Map<String, Any>>>
            get() {
                return utsMapOf("uni-row" to padStyleMapOf(utsMapOf("flexDirection" to "row")), "uni-column" to padStyleMapOf(utsMapOf("flexDirection" to "column")));
            }
    }
}
val GenAppClass = CreateVueAppComponent(GenApp::class.java, fun(): VueComponentOptions {
    return VueComponentOptions(name = "", inheritAttrs = true, inject = Map(), props = Map(), propsNeedCastKeys = utsArrayOf(), emits = Map(), components = Map(), styles = GenApp.styles);
}
, fun(instance): GenApp {
    return GenApp(instance);
}
);
val GenComponentSearchItemClass = CreateVueComponent(GenComponentSearchItem::class.java, fun(): VueComponentOptions {
    return VueComponentOptions(name = "", inheritAttrs = GenComponentSearchItem.inheritAttrs, inject = GenComponentSearchItem.inject, props = GenComponentSearchItem.props, propsNeedCastKeys = GenComponentSearchItem.propsNeedCastKeys, emits = GenComponentSearchItem.emits, components = GenComponentSearchItem.components, styles = GenComponentSearchItem.styles);
}
, fun(instance): GenComponentSearchItem {
    return GenComponentSearchItem(instance);
}
);
val GenComponentPublishBtnClass = CreateVueComponent(GenComponentPublishBtn::class.java, fun(): VueComponentOptions {
    return VueComponentOptions(name = "", inheritAttrs = GenComponentPublishBtn.inheritAttrs, inject = GenComponentPublishBtn.inject, props = GenComponentPublishBtn.props, propsNeedCastKeys = GenComponentPublishBtn.propsNeedCastKeys, emits = GenComponentPublishBtn.emits, components = GenComponentPublishBtn.components, styles = GenComponentPublishBtn.styles);
}
, fun(instance): GenComponentPublishBtn {
    return GenComponentPublishBtn(instance);
}
);
val GenComponentTabItemClass = CreateVueComponent(GenComponentTabItem::class.java, fun(): VueComponentOptions {
    return VueComponentOptions(name = "", inheritAttrs = GenComponentTabItem.inheritAttrs, inject = GenComponentTabItem.inject, props = GenComponentTabItem.props, propsNeedCastKeys = GenComponentTabItem.propsNeedCastKeys, emits = GenComponentTabItem.emits, components = GenComponentTabItem.components, styles = GenComponentTabItem.styles);
}
, fun(instance): GenComponentTabItem {
    return GenComponentTabItem(instance);
}
);
val GenPagesIndexIndexClass = CreateVueComponent(GenPagesIndexIndex::class.java, fun(): VueComponentOptions {
    return VueComponentOptions(name = "", inheritAttrs = GenPagesIndexIndex.inheritAttrs, inject = GenPagesIndexIndex.inject, props = GenPagesIndexIndex.props, propsNeedCastKeys = GenPagesIndexIndex.propsNeedCastKeys, emits = GenPagesIndexIndex.emits, components = GenPagesIndexIndex.components, styles = GenPagesIndexIndex.styles);
}
, fun(instance): GenPagesIndexIndex {
    return GenPagesIndexIndex(instance);
}
);
val GenPagesMyMyClass = CreateVueComponent(GenPagesMyMy::class.java, fun(): VueComponentOptions {
    return VueComponentOptions(name = "", inheritAttrs = GenPagesMyMy.inheritAttrs, inject = GenPagesMyMy.inject, props = GenPagesMyMy.props, propsNeedCastKeys = GenPagesMyMy.propsNeedCastKeys, emits = GenPagesMyMy.emits, components = GenPagesMyMy.components, styles = GenPagesMyMy.styles);
}
, fun(instance): GenPagesMyMy {
    return GenPagesMyMy(instance);
}
);
val GenPagesGroundGroundClass = CreateVueComponent(GenPagesGroundGround::class.java, fun(): VueComponentOptions {
    return VueComponentOptions(name = "", inheritAttrs = GenPagesGroundGround.inheritAttrs, inject = GenPagesGroundGround.inject, props = GenPagesGroundGround.props, propsNeedCastKeys = GenPagesGroundGround.propsNeedCastKeys, emits = GenPagesGroundGround.emits, components = GenPagesGroundGround.components, styles = GenPagesGroundGround.styles);
}
, fun(instance): GenPagesGroundGround {
    return GenPagesGroundGround(instance);
}
);
val GenPagesMessageMessageClass = CreateVueComponent(GenPagesMessageMessage::class.java, fun(): VueComponentOptions {
    return VueComponentOptions(name = "", inheritAttrs = GenPagesMessageMessage.inheritAttrs, inject = GenPagesMessageMessage.inject, props = GenPagesMessageMessage.props, propsNeedCastKeys = GenPagesMessageMessage.propsNeedCastKeys, emits = GenPagesMessageMessage.emits, components = GenPagesMessageMessage.components, styles = GenPagesMessageMessage.styles);
}
, fun(instance): GenPagesMessageMessage {
    return GenPagesMessageMessage(instance);
}
);
val GenPagesPublishPublishClass = CreateVueComponent(GenPagesPublishPublish::class.java, fun(): VueComponentOptions {
    return VueComponentOptions(name = "", inheritAttrs = GenPagesPublishPublish.inheritAttrs, inject = GenPagesPublishPublish.inject, props = GenPagesPublishPublish.props, propsNeedCastKeys = GenPagesPublishPublish.propsNeedCastKeys, emits = GenPagesPublishPublish.emits, components = GenPagesPublishPublish.components, styles = GenPagesPublishPublish.styles);
}
, fun(instance): GenPagesPublishPublish {
    return GenPagesPublishPublish(instance);
}
);
val GenPagesRegisterRegisterClass = CreateVueComponent(GenPagesRegisterRegister::class.java, fun(): VueComponentOptions {
    return VueComponentOptions(name = "", inheritAttrs = GenPagesRegisterRegister.inheritAttrs, inject = GenPagesRegisterRegister.inject, props = GenPagesRegisterRegister.props, propsNeedCastKeys = GenPagesRegisterRegister.propsNeedCastKeys, emits = GenPagesRegisterRegister.emits, components = GenPagesRegisterRegister.components, styles = GenPagesRegisterRegister.styles);
}
, fun(instance): GenPagesRegisterRegister {
    return GenPagesRegisterRegister(instance);
}
);
val GenPagesLoginLoginClass = CreateVueComponent(GenPagesLoginLogin::class.java, fun(): VueComponentOptions {
    return VueComponentOptions(name = "", inheritAttrs = GenPagesLoginLogin.inheritAttrs, inject = GenPagesLoginLogin.inject, props = GenPagesLoginLogin.props, propsNeedCastKeys = GenPagesLoginLogin.propsNeedCastKeys, emits = GenPagesLoginLogin.emits, components = GenPagesLoginLogin.components, styles = GenPagesLoginLogin.styles);
}
, fun(instance): GenPagesLoginLogin {
    return GenPagesLoginLogin(instance);
}
);
val GenPagesInfoInfoClass = CreateVueComponent(GenPagesInfoInfo::class.java, fun(): VueComponentOptions {
    return VueComponentOptions(name = "", inheritAttrs = GenPagesInfoInfo.inheritAttrs, inject = GenPagesInfoInfo.inject, props = GenPagesInfoInfo.props, propsNeedCastKeys = GenPagesInfoInfo.propsNeedCastKeys, emits = GenPagesInfoInfo.emits, components = GenPagesInfoInfo.components, styles = GenPagesInfoInfo.styles);
}
, fun(instance): GenPagesInfoInfo {
    return GenPagesInfoInfo(instance);
}
);
fun createApp(): UTSJSONObject {
    val app = createSSRApp(GenAppClass);
    return object : UTSJSONObject() {
        var app = app
    };
}
fun main(app: IApp) {
    definePageRoutes();
    defineAppConfig();
    (createApp()["app"] as VueApp).mount(app);
}
open class UniAppConfig : AppConfig {
    override var name: String = "anime-area";
    override var appid: String = "__UNI__EF9A735";
    override var versionName: String = "1.0.0";
    override var versionCode: String = "100";
    override var uniCompileVersion: String = "3.99";
    constructor(){}
}
fun definePageRoutes() {
    __uniRoutes.push(PageRoute(path = "pages/index/index", component = GenPagesIndexIndexClass, meta = PageMeta(isQuit = true), style = utsMapOf("navigationBarTitleText" to "")));
    __uniRoutes.push(PageRoute(path = "pages/my/my", component = GenPagesMyMyClass, meta = PageMeta(isQuit = false), style = utsMapOf("navigationBarTitleText" to "", "enablePullDownRefresh" to false)));
    __uniRoutes.push(PageRoute(path = "pages/ground/ground", component = GenPagesGroundGroundClass, meta = PageMeta(isQuit = false), style = utsMapOf("navigationBarTitleText" to "", "enablePullDownRefresh" to false)));
    __uniRoutes.push(PageRoute(path = "pages/message/message", component = GenPagesMessageMessageClass, meta = PageMeta(isQuit = false), style = utsMapOf("navigationBarTitleText" to "", "enablePullDownRefresh" to false)));
    __uniRoutes.push(PageRoute(path = "pages/publish/publish", component = GenPagesPublishPublishClass, meta = PageMeta(isQuit = false), style = utsMapOf("navigationBarTitleText" to "", "enablePullDownRefresh" to false)));
    __uniRoutes.push(PageRoute(path = "pages/register/register", component = GenPagesRegisterRegisterClass, meta = PageMeta(isQuit = false), style = utsMapOf("navigationBarTitleText" to "", "enablePullDownRefresh" to false)));
    __uniRoutes.push(PageRoute(path = "pages/login/login", component = GenPagesLoginLoginClass, meta = PageMeta(isQuit = false), style = utsMapOf("navigationBarTitleText" to "", "enablePullDownRefresh" to false)));
    __uniRoutes.push(PageRoute(path = "pages/info/info", component = GenPagesInfoInfoClass, meta = PageMeta(isQuit = false), style = utsMapOf("navigationBarTitleText" to "", "enablePullDownRefresh" to false)));
}
val __uniTabBar: Map<String, Any?>? = utsMapOf("list" to utsArrayOf(
    utsMapOf("pagePath" to "pages/index/index", "iconPath" to "static/cute_un.png", "selectedIconPath" to "static/cute.png", "text" to "找妆娘"),
    utsMapOf("pagePath" to "pages/ground/ground", "iconPath" to "static/groud_un.png", "selectedIconPath" to "static/ground.png", "text" to "广场"),
    utsMapOf("pagePath" to "pages/message/message", "iconPath" to "static/msg_un.png", "selectedIconPath" to "static/msg.png", "text" to "消息"),
    utsMapOf("pagePath" to "pages/my/my", "iconPath" to "static/my_un.png", "selectedIconPath" to "static/my.png", "text" to "我的")
));
val __uniLaunchPage: Map<String, Any?> = utsMapOf("url" to "pages/index/index", "style" to utsMapOf("navigationBarTitleText" to ""));
@Suppress("UNCHECKED_CAST")
fun defineAppConfig() {
    __uniConfig.entryPagePath = "/pages/index/index";
    __uniConfig.globalStyle = utsMapOf("navigationBarTextStyle" to "black", "navigationBarTitleText" to "uni-app x", "navigationBarBackgroundColor" to "#F8F8F8", "backgroundColor" to "#F8F8F8");
    __uniConfig.tabBar = __uniTabBar as Map<String, Any>?;
    __uniConfig.conditionUrl = "";
    __uniConfig.uniIdRouter = utsMapOf();
    __uniConfig.ready = true;
}
fun getApp(): GenApp {
    return getBaseApp() as GenApp;
}
