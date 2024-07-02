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
open class GenPagesPublishPublish : BasePage {
    constructor(instance: ComponentInternalInstance) : super(instance) {}
    @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
    override fun `$render`(): VNode? {
        val _ctx = this;
        val _cache = this.`$`.renderCache;
        return createElementVNode("scroll-view", null, utsArrayOf(
            createElementVNode("view", utsMapOf("class" to "publish"), utsArrayOf(
                createElementVNode("view", utsMapOf("class" to "title"), utsArrayOf(
                    createElementVNode("text", null, "标题"),
                    createElementVNode("input", utsMapOf("class" to "input-title", "modelValue" to _ctx.title, "onInput" to fun(`$event`: InputEvent): Any {
                        _ctx.title = `$event`.detail.value;
                        return `$event`.detail.value;
                    }
                    , "maxlength" to "15", "type" to "text", "placeholder" to "请最多输入15字标题~"), null, 40, utsArrayOf(
                        "modelValue",
                        "onInput"
                    ))
                )),
                createElementVNode("textarea", utsMapOf("class" to "text", "modelValue" to _ctx.content, "onInput" to fun(`$event`: InputEvent): Any {
                    _ctx.content = `$event`.detail.value;
                    return `$event`.detail.value;
                }
                , "placeholder" to "请输入", "auto-height" to ""), null, 40, utsArrayOf(
                    "modelValue",
                    "onInput"
                ))
            )),
            createElementVNode("image", utsMapOf("class" to "upload", "src" to "/static/upload.png"))
        ));
    }
    open var title: String by `$data`;
    open var content: String by `$data`;
    @Suppress("USELESS_CAST")
    override fun data(): Map<String, Any?> {
        return utsMapOf("title" to "", "content" to "");
    }
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
                return utsMapOf("title" to padStyleMapOf(utsMapOf("display" to "flex", "flexDirection" to "row", "margin" to "20rpx 80rpx")), "text" to padStyleMapOf(utsMapOf("width" to "90%", "padding" to "50rpx", "marginTop" to "20rpx")), "publish" to padStyleMapOf(utsMapOf("display" to "flex", "flexDirection" to "column", "alignItems" to "center")), "upload" to padStyleMapOf(utsMapOf("borderWidth" to 2, "borderStyle" to "solid", "borderColor" to "rgba(151,151,151,0.5)", "width" to "200rpx", "height" to "200rpx", "marginLeft" to "50rpx")), "input-title" to padStyleMapOf(utsMapOf("marginLeft" to "30rpx")));
            }
        var inheritAttrs = true;
        var inject: Map<String, Map<String, Any?>> = utsMapOf();
        var emits: Map<String, Any?> = utsMapOf();
        var props = normalizePropsOptions(utsMapOf());
        var propsNeedCastKeys: UTSArray<String> = utsArrayOf();
        var components: Map<String, CreateVueComponent> = utsMapOf();
    }
}
