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
open class GenComponentTabItem : VueComponent {
    constructor(instance: ComponentInternalInstance) : super(instance) {}
    @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
    override fun `$render`(): VNode? {
        val _ctx = this;
        val _cache = this.`$`.renderCache;
        return createElementVNode("view", utsMapOf("class" to "item"), utsArrayOf(
            createElementVNode("image", utsMapOf("class" to "tableItem", "src" to _ctx.img), null, 8, utsArrayOf(
                "src"
            )),
            createElementVNode("text", utsMapOf("class" to "name"), toDisplayString(_ctx.name), 1)
        ));
    }
    open var img: String by `$props`;
    open var name: String by `$props`;
    companion object {
        val styles: Map<String, Map<String, Map<String, Any>>>
            get() {
                return normalizeCssStyles(utsArrayOf(
                    styles0
                ));
            }
        val styles0: Map<String, Map<String, Map<String, Any>>>
            get() {
                return utsMapOf("tableItem" to padStyleMapOf(utsMapOf("width" to "100rpx", "height" to "100rpx")), "item" to padStyleMapOf(utsMapOf("width" to "100rpx", "display" to "flex", "flexDirection" to "column", "justifyContent" to "center", "alignItems" to "center")), "name" to padStyleMapOf(utsMapOf("fontSize" to "20rpx")));
            }
        var inheritAttrs = true;
        var inject: Map<String, Map<String, Any?>> = utsMapOf();
        var emits: Map<String, Any?> = utsMapOf();
        var props = normalizePropsOptions(utsMapOf("img" to utsMapOf("type" to "String", "required" to true), "name" to utsMapOf("type" to "String", "required" to true)));
        var propsNeedCastKeys: UTSArray<String> = utsArrayOf();
        var components: Map<String, CreateVueComponent> = utsMapOf();
    }
}
