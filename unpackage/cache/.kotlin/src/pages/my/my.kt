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
open class GenPagesMyMy : BasePage {
    constructor(instance: ComponentInternalInstance) : super(instance) {}
    @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
    override fun `$render`(): VNode? {
        val _ctx = this;
        val _cache = this.`$`.renderCache;
        return createElementVNode("scroll-view", utsMapOf("style" to "flex:1"), utsArrayOf(
            createElementVNode("view", utsMapOf("class" to "avatar")),
            createElementVNode("view", utsMapOf("onClick" to _ctx.login), "点我登录", 8, utsArrayOf(
                "onClick"
            )),
            createElementVNode("view", utsMapOf("onClick" to _ctx.register), "点我注册", 8, utsArrayOf(
                "onClick"
            ))
        ));
    }
    override fun `$initMethods`() {
        this.login = fun() {
            uni_navigateTo(NavigateToOptions(url = "/pages/login/login"));
        }
        ;
        this.register = fun() {
            uni_navigateTo(NavigateToOptions(url = "/pages/register/register"));
        }
        ;
    }
    open lateinit var login: () -> Unit;
    open lateinit var register: () -> Unit;
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
                return utsMapOf("avatar" to padStyleMapOf(utsMapOf("width" to 10, "height" to 10)));
            }
        var inheritAttrs = true;
        var inject: Map<String, Map<String, Any?>> = utsMapOf();
        var emits: Map<String, Any?> = utsMapOf();
        var props = normalizePropsOptions(utsMapOf());
        var propsNeedCastKeys: UTSArray<String> = utsArrayOf();
        var components: Map<String, CreateVueComponent> = utsMapOf();
    }
}
