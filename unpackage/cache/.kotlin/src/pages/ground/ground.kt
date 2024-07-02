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
open class GenPagesGroundGround : BasePage {
    constructor(instance: ComponentInternalInstance) : super(instance) {}
    @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
    override fun `$render`(): VNode? {
        val _cache = this.`$`.renderCache;
        val _component_search_item = resolveComponent("search-item");
        val _component_tab_item = resolveComponent("tab-item");
        return createElementVNode("scroll-view", utsMapOf("style" to "flex:1"), utsArrayOf(
            createElementVNode("view", null, utsArrayOf(
                createVNode(_component_search_item)
            )),
            createElementVNode("view", utsMapOf("class" to "tabLine"), utsArrayOf(
                createVNode(_component_tab_item, utsMapOf("img" to "static/cute.png", "name" to "漫展汇总")),
                createVNode(_component_tab_item, utsMapOf("img" to "static/cute.png", "name" to "cos服饰")),
                createVNode(_component_tab_item, utsMapOf("img" to "static/cute.png", "name" to "约拍")),
                createVNode(_component_tab_item, utsMapOf("img" to "static/cute.png", "name" to "找搭档"))
            ))
        ));
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
                return utsMapOf("tabLine" to padStyleMapOf(utsMapOf("width" to "100%", "display" to "flex", "flexDirection" to "row", "padding" to "20rpx", "justifyContent" to "space-around", "marginTop" to "20rpx")));
            }
        var inheritAttrs = true;
        var inject: Map<String, Map<String, Any?>> = utsMapOf();
        var emits: Map<String, Any?> = utsMapOf();
        var props = normalizePropsOptions(utsMapOf());
        var propsNeedCastKeys: UTSArray<String> = utsArrayOf();
        var components: Map<String, CreateVueComponent> = utsMapOf("searchItem" to GenComponentSearchItemClass, "tabItem" to GenComponentTabItemClass);
    }
}
