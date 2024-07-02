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
open class GenPagesIndexIndex : BasePage {
    constructor(instance: ComponentInternalInstance) : super(instance) {}
    @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
    override fun `$render`(): VNode? {
        val _ctx = this;
        val _cache = this.`$`.renderCache;
        val _component_search_item = resolveComponent("search-item");
        val _component_publish_btn = resolveComponent("publish-btn");
        val _component_tab_item = resolveComponent("tab-item");
        return createElementVNode("scroll-view", utsMapOf("class" to "index"), utsArrayOf(
            createElementVNode("view", null, utsArrayOf(
                createVNode(_component_search_item)
            )),
            createVNode(_component_publish_btn, utsMapOf("onClick" to _ctx.publish), null, 8, utsArrayOf(
                "onClick"
            )),
            createVNode(_component_tab_item, utsMapOf("img" to "static/cute.png", "name" to "vv"))
        ));
    }
    override fun `$initMethods`() {
        this.publish = fun() {
            uni_navigateTo(NavigateToOptions(url = "/pages/publish/publish"));
        }
        ;
    }
    open lateinit var publish: () -> Unit;
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
                return utsMapOf("index" to padStyleMapOf(utsMapOf("position" to "relative")));
            }
        var inheritAttrs = true;
        var inject: Map<String, Map<String, Any?>> = utsMapOf();
        var emits: Map<String, Any?> = utsMapOf();
        var props = normalizePropsOptions(utsMapOf());
        var propsNeedCastKeys: UTSArray<String> = utsArrayOf();
        var components: Map<String, CreateVueComponent> = utsMapOf("searchItem" to GenComponentSearchItemClass, "publishBtn" to GenComponentPublishBtnClass, "tabItem" to GenComponentTabItemClass);
    }
}
