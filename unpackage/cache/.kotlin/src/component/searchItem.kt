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
open class GenComponentSearchItem : VueComponent {
    constructor(instance: ComponentInternalInstance) : super(instance) {}
    @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
    override fun `$render`(): VNode? {
        val _cache = this.`$`.renderCache;
        return createElementVNode("view", utsMapOf("class" to "search-item"), utsArrayOf(
            createElementVNode("view", utsMapOf("class" to "search"), utsArrayOf(
                createElementVNode("input", utsMapOf("class" to "search-box", "placeholder" to "客观你想要搜什么～")),
                createElementVNode("view", utsMapOf("class" to "btn"), "搜索")
            ))
        ));
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
                return utsMapOf("search" to padStyleMapOf(utsMapOf("display" to "flex", "flexDirection" to "row", "alignItems" to "center")), "search-item" to padStyleMapOf(utsMapOf("width" to "100%", "display" to "flex", "alignItems" to "center")), "search-box" to padStyleMapOf(utsMapOf("width" to "500rpx", "height" to "85rpx", "padding" to "20rpx 20rpx", "borderWidth" to "1rpx", "borderStyle" to "solid", "borderColor" to "#D9D9D9", "borderRadius" to 10, "alignItems" to "center", "display" to "flex", "justifyContent" to "center")), "btn" to padStyleMapOf(utsMapOf("marginLeft" to "10rpx")));
            }
        var inheritAttrs = true;
        var inject: Map<String, Map<String, Any?>> = utsMapOf();
        var emits: Map<String, Any?> = utsMapOf();
        var props = normalizePropsOptions(utsMapOf());
        var propsNeedCastKeys: UTSArray<String> = utsArrayOf();
        var components: Map<String, CreateVueComponent> = utsMapOf();
    }
}
