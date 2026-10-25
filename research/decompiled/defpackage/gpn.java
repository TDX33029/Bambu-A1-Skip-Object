package defpackage;

import android.app.Application;
import android.content.Context;
import com.facebook.hermes.reactexecutor.HermesExecutor;
import com.facebook.react.bridge.JSBundleLoader;
import com.facebook.react.bridge.ReactMarker;
import com.facebook.react.bridge.ReactMarkerConstants;
import com.facebook.react.common.LifecycleState;
import com.facebook.soloader.SoLoader;
import com.umeng.analytics.pro.ek;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes4.dex */
public abstract class gpn {
    public final Application a;

    static {
    }

    public gpn(Application r1) {
        this.a = r1;
    }

    public final void a() {
        ReactMarker.logMarker(ReactMarkerConstants.BUILD_REACT_INSTANCE_MANAGER_START);
        String r0 = mnn.g;
        nnn r02 = new nnn();
        r02.e = this.a;
        j03 r1 = (j03) this;
        String r2 = r1.d;
        r2.getClass();
        r02.d = r2;
        r02.f = r1.e;
        r02.g = true;
        r02.j = new w0k(21);
        r02.i = new tl7(r1, 29);
        r02.h = LifecycleState.a;
        new wxj(ek.m);
        Iterator r15 = b().iterator();
    L3:
        boolean r22 = r15.hasNext();
        ArrayList r8 = r02.a;
        if (r22 == false) goto L6;
        qpn r23 = (qpn) r15.next();
        r23.getClass();
        r8.add(r23);
        goto L3
    L6:
        r02.b = "assets://".concat("jsbundle/" + r1.c + "/main.jsbundle");
        r02.c = null;
        ReactMarker.logMarker(ReactMarkerConstants.BUILD_REACT_INSTANCE_MANAGER_END);
        Application r4 = r02.e;
        if (r4 == null) goto L48;
        if (r02.h == LifecycleState.c) goto L46;
        if (r02.f == true) goto L20;
        if (r02.b != null) goto L20;
        if (r02.c != null) goto L20;
        throw new IllegalStateException("JS Bundle File or Asset URL has to be provided when dev support is disabled");
    L20:
        if (r02.d == null) goto L22;
    L28:
        String r12 = r4.getPackageName();
        w0k.o();
        String r24 = r02.b;
        r12.getClass();
        Context r13 = r4.getApplicationContext();
        r13.getClass();
        SoLoader.init(r13, false);
        ybe r14 = HermesExecutor.a;     // Catch: UnsatisfiedLinkError -> L34
        if (HermesExecutor.b != null) goto L32;
        SoLoader.loadLibrary("hermesvm");     // Catch: UnsatisfiedLinkError -> L34
        SoLoader.loadLibrary("hermes_executor");     // Catch: UnsatisfiedLinkError -> L34
        HermesExecutor.b = "Release";     // Catch: UnsatisfiedLinkError -> L34
    L32:
        b1k r5 = new b1k(ek.n);     // Catch: UnsatisfiedLinkError -> L34
    L35:
        JSBundleLoader r16 = r02.c;
        if (r16 != null) goto L39;
        if (r24 == null) goto L39;
        r16 = JSBundleLoader.Companion.createAssetLoader(r4, r24, false);
    L39:
        JSBundleLoader r6 = r16;
        String r7 = r02.d;
        boolean r9 = r02.f;
        d3e r10 = new d3e(ek.k);
        boolean r11 = r02.g;
        LifecycleState r122 = r02.h;
        if (r122 == null) goto L44;
        new mnn(r4, r5, r6, r7, r8, r9, r10, r11, r122, r02.i, r02.j);
        throw null;
    L44:
        throw new IllegalStateException("Initial lifecycle state was not set");
    L34:
        j1c.f("nnn", "Unable to load Hermes. Your application is not built correctly and will fail to execute");
        r5 = null;
        goto L35
    L22:
        if (r02.b != null) goto L28;
        if (r02.c != null) goto L28;
        throw new IllegalStateException("Either MainModulePath or JS Bundle File needs to be provided");
    L46:
        throw new IllegalStateException("Activity needs to be set if initial lifecycle state is resumed");
    L48:
        throw new IllegalStateException("Application property has not been set with this builder");
    }

    public abstract ArrayList b();

    public final synchronized mnn c() {
        monitor-enter(this);
        ReactMarker.logMarker(ReactMarkerConstants.INIT_REACT_RUNTIME_START);     // Catch: Throwable -> L5
        ReactMarker.logMarker(ReactMarkerConstants.GET_REACT_INSTANCE_MANAGER_START);     // Catch: Throwable -> L5
        a();     // Catch: Throwable -> L5
        throw null;     // Catch: Throwable -> L5
    L5:
        th = move-exception;
        throw th;
    }
}
