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
import io.dcloud.uniapp.extapi.navigateTo as uni_navigateTo;
open class GenPagesRegisterRegister : BasePage {
    constructor(instance: ComponentInternalInstance) : super(instance) {}
    @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
    override fun `$render`(): VNode? {
        val _ctx = this;
        val _cache = this.`$`.renderCache;
        val _component_button = resolveComponent("button");
        return createElementVNode("scroll-view", utsMapOf("class" to "page"), utsArrayOf(
            createElementVNode("view", utsMapOf("class" to "title"), utsArrayOf(
                createElementVNode("text", utsMapOf("style" to "color:#fff; font-size: 50rpx;font-weight: 700;"), "萌喵酱")
            )),
            createElementVNode("image", utsMapOf("class" to "avatar", "src" to "/static/avatar.png", "mode" to "aspectFit")),
            createElementVNode("view", utsMapOf("class" to "input-group"), utsArrayOf(
                createElementVNode("image", utsMapOf("class" to "icon", "src" to "/static/email.png", "mode" to "aspectFit")),
                createElementVNode("input", utsMapOf("class" to "input", "placeholder" to "请输入邮箱"))
            )),
            createElementVNode("view", utsMapOf("class" to "input-group"), utsArrayOf(
                createElementVNode("image", utsMapOf("class" to "icon", "src" to "/static/yanzhengma.png", "mode" to "aspectFit")),
                createElementVNode("input", utsMapOf("class" to "input", "placeholder" to "验证码")),
                createVNode(_component_button, utsMapOf("class" to "btn"), utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                    return utsArrayOf(
                        "发送"
                    );
                }
                ), "_" to 1))
            )),
            createElementVNode("view", utsMapOf("class" to "input-group"), utsArrayOf(
                createElementVNode("image", utsMapOf("class" to "icon", "src" to "/static/passwd.png", "mode" to "aspectFit")),
                createElementVNode("input", utsMapOf("class" to "input", "placeholder" to "密码"))
            )),
            createVNode(_component_button, utsMapOf("class" to "register", "onClick" to _ctx.info), utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                return utsArrayOf(
                    "注册ฅ"
                );
            }
            ), "_" to 1), 8, utsArrayOf(
                "onClick"
            ))
        ));
    }
    override fun `$initMethods`() {
        this.info = fun() {
            uni_navigateTo(NavigateToOptions(url = "/pages/info/info"));
        }
        ;
    }
    open lateinit var info: () -> Unit;
    companion object {
        val styles: Map<String, Map<String, Map<String, Any>>>
            get() {
                return normalizeCssStyles(utsArrayOf(
                    styles0
                ), utsArrayOf(
                    GenApp.styles
                ));
            }
        val styles0: Map<String, Map<String, Map<String, Any>>>
            get() {
                return utsMapOf("title" to padStyleMapOf(utsMapOf("width" to "100%", "display" to "flex", "alignItems" to "center", "justifyContent" to "center", "textAlign" to "center", "backgroundImage" to "linear-gradient(to bottom, #FF5853, #fff)", "height" to "20%", "color" to "#ffffff")), "avatar" to padStyleMapOf(utsMapOf("marginTop" to "75rpx", "width" to "200rpx", "height" to "200rpx", "borderRadius" to "100rpx", "marginBottom" to "80rpx")), "page" to padStyleMapOf(utsMapOf("display" to "flex", "flexDirection" to "column", "alignItems" to "center", "width" to "100%", "height" to "100%")), "input-group" to padStyleMapOf(utsMapOf("display" to "flex", "flexDirection" to "row", "width" to "75%", "height" to "90rpx", "alignItems" to "center", "borderWidth" to 1, "borderStyle" to "solid", "borderColor" to "#979797", "borderRadius" to "20rpx", "marginTop" to "30rpx")), "icon" to padStyleMapOf(utsMapOf("width" to "100rpx", "height" to "75rpx")), "input" to padStyleMapOf(utsMapOf("width" to "500rpx", "paddingLeft" to "20rpx")), "btn" to padStyleMapOf(utsMapOf("width" to "150rpx", "height" to "80rpx", "marginLeft" to "-200rpx", "backgroundColor" to "#FF5853", "borderRadius" to "30rpx", "color" to "#ffffff", "textAlign" to "center")), "register" to padStyleMapOf(utsMapOf("width" to "500rpx", "height" to "100rpx", "marginTop" to "75rpx", "textAlign" to "center", "borderRadius" to "50rpx", "backgroundColor" to "#FF5853", "color" to "#ffffff", "fontSize" to "40rpx")));
            }
        var inheritAttrs = true;
        var inject: Map<String, Map<String, Any?>> = utsMapOf();
        var emits: Map<String, Any?> = utsMapOf();
        var props = normalizePropsOptions(utsMapOf());
        var propsNeedCastKeys: UTSArray<String> = utsArrayOf();
        var components: Map<String, CreateVueComponent> = utsMapOf();
    }
}
