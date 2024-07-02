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
open class GenPagesInfoInfo : BasePage {
    constructor(instance: ComponentInternalInstance) : super(instance) {}
    @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
    override fun `$render`(): VNode? {
        val _ctx = this;
        val _cache = this.`$`.renderCache;
        val _component_uni_datetime_picker = resolveComponent("uni-datetime-picker");
        val _component_button = resolveComponent("button");
        return createElementVNode("scroll-view", utsMapOf("class" to "page"), utsArrayOf(
            createElementVNode("view", utsMapOf("class" to "title"), utsArrayOf(
                createElementVNode("text", utsMapOf("style" to "color:#fff; font-size: 50rpx;font-weight: 700;"), "萌喵酱")
            )),
            createElementVNode("image", utsMapOf("class" to "avatar", "src" to "/static/avatar.png", "mode" to "aspectFit")),
            createElementVNode("view", utsMapOf("class" to "pickers"), utsArrayOf(
                createVNode(_component_uni_datetime_picker, utsMapOf("type" to "date", "clear-icon" to false, "modelValue" to _ctx.date, "onUpdate:modelValue" to fun(`$event`: String){
                    _ctx.date = `$event`;
                }
                , "onMaskClick" to _ctx.maskClick), null, 8, utsArrayOf(
                    "modelValue",
                    "onUpdate:modelValue",
                    "onMaskClick"
                ))
            )),
            createVNode(_component_button, utsMapOf("class" to "register", "onClick" to _ctx.info), utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                return utsArrayOf(
                    "保存ฅ"
                );
            }
            ), "_" to 1), 8, utsArrayOf(
                "onClick"
            ))
        ));
    }
    open var date: String by `$data`;
    @Suppress("USELESS_CAST")
    override fun data(): Map<String, Any?> {
        return utsMapOf("date" to "2021-2-12");
    }
    override fun `$initMethods`() {
        this.info = fun() {
            uni_navigateTo(NavigateToOptions(url = "/pages/info/info"));
        }
        ;
        this.maskClick = fun(e: Any) {
            console.log("maskClick事件:", e, " at pages/info/info.uvue:31");
        }
        ;
    }
    open lateinit var info: () -> Unit;
    open lateinit var maskClick: (e: Any) -> Unit;
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
                return utsMapOf("title" to padStyleMapOf(utsMapOf("width" to "100%", "display" to "flex", "alignItems" to "center", "justifyContent" to "center", "textAlign" to "center", "backgroundImage" to "linear-gradient(to bottom, #FF5853, #fff)", "height" to "20%", "color" to "#ffffff")), "pickers" to padStyleMapOf(utsMapOf("width" to "300rpx", "height" to "100rpx", "backgroundColor" to "#FF5853")), "avatar" to padStyleMapOf(utsMapOf("marginTop" to "75rpx", "width" to "200rpx", "height" to "200rpx", "borderRadius" to "100rpx", "marginBottom" to "80rpx")), "page" to padStyleMapOf(utsMapOf("display" to "flex", "flexDirection" to "column", "alignItems" to "center", "width" to "100%", "height" to "100%")), "input-group" to padStyleMapOf(utsMapOf("display" to "flex", "flexDirection" to "row", "width" to "75%", "height" to "90rpx", "alignItems" to "center", "borderWidth" to 1, "borderStyle" to "solid", "borderColor" to "#979797", "borderRadius" to "20rpx", "marginTop" to "30rpx")), "icon" to padStyleMapOf(utsMapOf("width" to "100rpx", "height" to "75rpx")), "input" to padStyleMapOf(utsMapOf("width" to "500rpx", "paddingLeft" to "20rpx")), "btn" to padStyleMapOf(utsMapOf("width" to "150rpx", "height" to "80rpx", "marginLeft" to "-200rpx", "backgroundColor" to "#FF5853", "borderRadius" to "30rpx", "color" to "#ffffff", "textAlign" to "center")), "register" to padStyleMapOf(utsMapOf("width" to "500rpx", "height" to "100rpx", "marginTop" to "75rpx", "textAlign" to "center", "borderRadius" to "50rpx", "backgroundColor" to "#FF5853", "color" to "#ffffff", "fontSize" to "40rpx")));
            }
        var inheritAttrs = true;
        var inject: Map<String, Map<String, Any?>> = utsMapOf();
        var emits: Map<String, Any?> = utsMapOf();
        var props = normalizePropsOptions(utsMapOf());
        var propsNeedCastKeys: UTSArray<String> = utsArrayOf();
        var components: Map<String, CreateVueComponent> = utsMapOf();
    }
}
