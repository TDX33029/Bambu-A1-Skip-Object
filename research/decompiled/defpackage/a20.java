package defpackage;

import android.hardware.camera2.CaptureRequest;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.ActionMode;
import android.view.View;
import com.bambulab.bambulab.core.device.storage.api.MemDataRequest;
import com.bambulab.bambulab.dokit.devicedebug.DeviceDebugActivity;
import com.bambulab.bambulab.model.DesignModel;
import com.bambulab.bambulab.model.SpeedLevel;
import com.bambulab.bambulab.model.User;
import com.bambulab.printer.model.generated.BblpAmsControlAction;
import com.bambulab.printer.model.generated.BblpSpeedLevel;
import com.umeng.analytics.pro.ek;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* loaded from: classes3.dex */
public final class a20 extends o7r implements Function1 {
    public final /* synthetic */ byte a;
    public boolean b;
    public final /* synthetic */ Object c;
    public final /* synthetic */ Object d;

    public a20(hys r2, List r3, rf7 r4) {
        this.a = 20;
        this.c = r2;
        this.d = r3;
        super(1, r4);
    }

    public /* synthetic */ a20(Object r1, Object r2, rf7 r3, byte r4) {
        this.a = r4;
        this.c = r1;
        this.d = r2;
        super(1, r3);
    }

    @Override // defpackage.ft1
    public final rf7 create(rf7 r4) {
        byte r0 = this.a;
        Object r1 = this.d;
        Object r3 = this.c;
        switch(r0) {
            case 0: goto L51;
            case 1: goto L49;
            case 2: goto L47;
            case 3: goto L45;
            case 4: goto L43;
            case 5: goto L41;
            case 6: goto L39;
            case 7: goto L37;
            case 8: goto L35;
            case 9: goto L33;
            case 10: goto L31;
            case 11: goto L29;
            case 12: goto L27;
            case 13: goto L25;
            case 14: goto L23;
            case 15: goto L21;
            case 16: goto L19;
            case 17: goto L17;
            case 18: goto L15;
            case 19: goto L13;
            case 20: goto L11;
            case 21: goto L9;
            case 22: goto L7;
            default: goto L5;
        };
    L5:
        return new a20((Function2) r3, (User) r1, r4, 23);
    L7:
        return new a20((Function1) r3, (alj) r1, r4, 22);
    L9:
        return new a20((DesignModel) r3, (l2t) r1, r4, 21);
    L11:
        return new a20((hys) r3, (List) r1, r4);
    L13:
        return new a20((blq) r3, (String) r1, r4, 19);
    L15:
        return new a20((o8p) r3, (User) r1, r4, 18);
    L17:
        return new a20((v6n) r3, (String) r1, r4, 17);
    L19:
        return new a20((ine) r3, (MemDataRequest) r1, r4, ek.n);
    L21:
        return new a20((jgd) r3, (alj) r1, r4, ek.m);
    L23:
        return new a20((tvc) r3, (nzn) r1, r4, ek.l);
    L25:
        return new a20((fnb) r3, (ArrayList) r1, r4, ek.k);
    L27:
        return new a20((DeviceDebugActivity) r3, (String) r1, r4, 12);
    L29:
        return new a20((cz9) r3, (SpeedLevel) r1, r4, 11);
    L31:
        return new a20((cz9) r3, (fs7) r1, r4, 10);
    L33:
        return new a20((be3) r3, (sjp) r1, r4, 9);
    L35:
        return new a20((ks) r3, (gv) r1, r4, 8);
    L37:
        return new a20((iw1) r3, (hw1) r1, r4, 7);
    L39:
        return new a20((yn1) r3, (String) r1, r4, 6);
    L41:
        return new a20((yn1) r3, (pn1) r1, r4, 5);
    L43:
        return new a20((gk0) r3, (fjr) r1, r4, 4);
    L45:
        return new a20((hc0) r3, (gpd) r1, r4, 3);
    L47:
        return new a20((gc0) r3, (gpd) r1, r4, 2);
    L49:
        return new a20((l20) r3, (x10) r1, r4, 1);
    L51:
        return new a20((l20) r3, (BblpAmsControlAction) r1, r4, 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object r3) {
        byte r0 = this.a;
        trs r1 = trs.a;
        rf7 r32 = (rf7) r3;
        switch(r0) {
            case 0: goto L51;
            case 1: goto L49;
            case 2: goto L47;
            case 3: goto L45;
            case 4: goto L43;
            case 5: goto L41;
            case 6: goto L39;
            case 7: goto L37;
            case 8: goto L35;
            case 9: goto L33;
            case 10: goto L31;
            case 11: goto L29;
            case 12: goto L27;
            case 13: goto L25;
            case 14: goto L23;
            case 15: goto L21;
            case 16: goto L19;
            case 17: goto L17;
            case 18: goto L15;
            case 19: goto L13;
            case 20: goto L11;
            case 21: goto L9;
            case 22: goto L7;
            default: goto L5;
        };
    L5:
        return ((a20) create(r32)).invokeSuspend(r1);
    L7:
        return ((a20) create(r32)).invokeSuspend(r1);
    L9:
        return ((a20) create(r32)).invokeSuspend(r1);
    L11:
        return ((a20) create(r32)).invokeSuspend(r1);
    L13:
        return ((a20) create(r32)).invokeSuspend(r1);
    L15:
        return ((a20) create(r32)).invokeSuspend(r1);
    L17:
        return ((a20) create(r32)).invokeSuspend(r1);
    L19:
        return ((a20) create(r32)).invokeSuspend(r1);
    L21:
        return ((a20) create(r32)).invokeSuspend(r1);
    L23:
        return ((a20) create(r32)).invokeSuspend(r1);
    L25:
        return ((a20) create(r32)).invokeSuspend(r1);
    L27:
        return ((a20) create(r32)).invokeSuspend(r1);
    L29:
        return ((a20) create(r32)).invokeSuspend(r1);
    L31:
        return ((a20) create(r32)).invokeSuspend(r1);
    L33:
        return ((a20) create(r32)).invokeSuspend(r1);
    L35:
        return ((a20) create(r32)).invokeSuspend(r1);
    L37:
        return ((a20) create(r32)).invokeSuspend(r1);
    L39:
        return ((a20) create(r32)).invokeSuspend(r1);
    L41:
        return ((a20) create(r32)).invokeSuspend(r1);
    L43:
        return ((a20) create(r32)).invokeSuspend(r1);
    L45:
        return ((a20) create(r32)).invokeSuspend(r1);
    L47:
        return ((a20) create(r32)).invokeSuspend(r1);
    L49:
        return ((a20) create(r32)).invokeSuspend(r1);
    L51:
        return ((a20) create(r32)).invokeSuspend(r1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v19, types: [c7q] */
    /* JADX WARN: Type inference failed for: r1v20, types: [c7q] */
    /* JADX WARN: Type inference failed for: r1v29, types: [android.os.Handler] */
    /* JADX WARN: Type inference failed for: r4v11, types: [eir] */
    @Override // defpackage.ft1
    public final Object invokeSuspend(Object r20) {
        byte r1 = this.a;
        byte r2 = ek.m;
        byte r3 = 3;
        int r4 = 0;
        boolean r42 = false;
        boolean r43 = false;
        boolean r44 = false;
        trs r5 = trs.a;
        Object r6 = this.d;
        Object r7 = this.c;
        byte r9 = 1;
        BblpSpeedLevel r10 = null;
        boolean r102 = false;
        boolean r103 = false;
        boolean r104 = false;
        boolean r105 = false;
        boolean r106 = false;
        switch(r1) {
            case 0: goto L322;
            case 1: goto L313;
            case 2: goto L304;
            case 3: goto L288;
            case 4: goto L221;
            case 5: goto L212;
            case 6: goto L195;
            case 7: goto L176;
            case 8: goto L167;
            case 9: goto L158;
            case 10: goto L148;
            case 11: goto L138;
            case 12: goto L129;
            case 13: goto L120;
            case 14: goto L107;
            case 15: goto L98;
            case 16: goto L88;
            case 17: goto L79;
            case 18: goto L70;
            case 19: goto L61;
            case 20: goto L42;
            case 21: goto L25;
            case 22: goto L13;
            default: goto L4;
        };
    L4:
        Object r12 = nsf.getCOROUTINE_SUSPENDED();
        boolean r22 = this.b;
        if (r22 == false) goto L9;
        if (r22 != true) goto L8;
        gti.r(r20);
        return r5;
    L8:
        jfn.u("call to 'resume' before 'invoke' with coroutine");
        return null;
    L9:
        gti.r(r20);
        this.b = true;
        if (((Function2) r7).invoke((User) r6, this) == r12) goto L12;
        return r5;
    L12:
        return r12;
    L13:
        Object r13 = nsf.getCOROUTINE_SUSPENDED();
        boolean r23 = this.b;
        if (r23 == false) goto L18;
        if (r23 != true) goto L17;
        gti.r(r20);
        Object r0 = r20;
    L22:
        if (((Boolean) r0).booleanValue() == true) goto L343;
        ((alj) r6).setValue(Boolean.TRUE);
        return r5;
    L343:
        return r5;
    L17:
        jfn.u("call to 'resume' before 'invoke' with coroutine");
        return null;
    L18:
        gti.r(r20);
        this.b = true;
        r0 = ((Function1) r7).invoke(this);
        if (r0 != r13) goto L22;
        return r13;
    L25:
        Object r14 = nsf.getCOROUTINE_SUSPENDED();
        boolean r24 = this.b;
        if (r24 == false) goto L30;
        if (r24 != true) goto L29;
        gti.r(r20);
        return r20;
    L29:
        jfn.u("call to 'resume' before 'invoke' with coroutine");
        return null;
    L30:
        gti.r(r20);
        DesignModel r72 = (DesignModel) r7;
        l2t r132 = (l2t) r6;
        this.b = true;
        wto r25 = new wto(msf.intercepted(this));
        Long r52 = r72.getId();
        if (r52 != null) goto L33;
        r25.resumeWith(rs4.boxBoolean(false));
    L35:
        Object r26 = r25.getOrThrow();
        if (r26 != nsf.getCOROUTINE_SUSPENDED()) goto L38;
        q78.probeCoroutineSuspended(this);
    L38:
        if (r26 != r14) goto L41;
        return r14;
    L41:
        return r26;
    L33:
        if (r132 == null) goto L35;
        long r142 = r52.longValue();
        dy4.c(zq4.l(r132), null, null, new g1s(r72.isPrivate(), r132, r142, new m0t(r25, (byte) 0), null, 2), 3);
        goto L35
    L42:
        hys r73 = (hys) r7;
        LinkedHashMap r15 = r73.k;
        List r62 = (List) r6;
        Object r32 = nsf.getCOROUTINE_SUSPENDED();
        boolean r45 = this.b;
        if (r45 == false) goto L47;
        if (r45 != true) goto L46;
        gti.r(r20);
        return r20;
    L46:
        jfn.u("call to 'resume' before 'invoke' with coroutine");
        return null;
    L47:
        gti.r(r20);
        boolean r53 = gev.g("CXCP");
        wxs r8 = wxs.b;
        if (r53 == false) goto L50;
        Log.d("CXCP", "UseCaseCameraRequestControlImpl#removeParametersAsync: [" + r8 + "] keys = " + r62);
    L50:
        Object r46 = r15.get(r8);
        Object r47 = r46;
        if (r46 != null) goto L53;
        zxs r48 = new zxs(r106 ? 1 : 0, r105 ? 1 : 0, r104 ? 1 : 0, r2);
        r15.put(r8, r48);
        r47 = r48;
    L53:
        zxs r49 = (zxs) r47;
        bno r27 = new bno((byte) 11);
        r27.y((fkj) r49.a.b);
        Iterator r54 = r62.iterator();
    L55:
        if (r54.hasNext() == false) goto L57;
        ((fkj) r27.b).C(k8v.b((CaptureRequest.Key) r54.next()));
        goto L55
    L57:
        r15.put(r8, new zxs(r27, vvh.q0(r49.b), r86.U0(r49.c), r49.d));
        zxs r16 = hys.n(r73.k);
        this.b = true;
        Object r02 = r73.q(r16, null, this);
        if (r02 == r32) goto L60;
        return r02;
    L60:
        return r32;
    L61:
        Object r17 = nsf.getCOROUTINE_SUSPENDED();
        boolean r28 = this.b;
        if (r28 == false) goto L66;
        if (r28 != true) goto L65;
        gti.r(r20);
        return r20;
    L65:
        jfn.u("call to 'resume' before 'invoke' with coroutine");
        return null;
    L66:
        gti.r(r20);
        this.b = true;
        List r29 = blq.n;
        Object r03 = ((blq) r7).b((String) r6, this);
        if (r03 == r17) goto L69;
        return r03;
    L69:
        return r17;
    L70:
        Object r18 = nsf.getCOROUTINE_SUSPENDED();
        boolean r210 = this.b;
        if (r210 == false) goto L75;
        if (r210 != true) goto L74;
        gti.r(r20);
        return r5;
    L74:
        jfn.u("call to 'resume' before 'invoke' with coroutine");
        return null;
    L75:
        gti.r(r20);
        this.b = true;
        if (((o8p) r7).e((User) r6, this) == r18) goto L78;
        return r5;
    L78:
        return r18;
    L79:
        Object r19 = nsf.getCOROUTINE_SUSPENDED();
        boolean r211 = this.b;
        if (r211 == false) goto L84;
        if (r211 != true) goto L83;
        gti.r(r20);
        return r5;
    L83:
        jfn.u("call to 'resume' before 'invoke' with coroutine");
        return null;
    L84:
        gti.r(r20);
        this.b = true;
        if (((v6n) r7).d((String) r6, this) == r19) goto L87;
        return r5;
    L87:
        return r19;
    L88:
        Object r110 = nsf.getCOROUTINE_SUSPENDED();
        boolean r212 = this.b;
        if (r212 == false) goto L93;
        if (r212 != true) goto L92;
        gti.r(r20);
        Object r04 = ((pfo) r20).a;
    L97:
        return new pfo(r04);
    L92:
        jfn.u("call to 'resume' before 'invoke' with coroutine");
        return null;
    L93:
        gti.r(r20);
        this.b = true;
        r04 = ((ine) r7).c.mo66getMemDatagIAlus((MemDataRequest) r6, this);
        if (r04 != r110) goto L97;
        return r110;
    L98:
        Object r111 = nsf.getCOROUTINE_SUSPENDED();
        boolean r213 = this.b;
        if (r213 == false) goto L103;
        if (r213 != true) goto L102;
        gti.r(r20);
        return r20;
    L102:
        jfn.u("call to 'resume' before 'invoke' with coroutine");
        return null;
    L103:
        gti.r(r20);
        Function2 r214 = ((jgd) r7).b;
        String r33 = (String) ((alj) r6).getValue();
        this.b = true;
        Object r05 = r214.invoke(r33, this);
        if (r05 == r111) goto L106;
        return r05;
    L106:
        return r111;
    L107:
        nzn r63 = (nzn) r6;
        Object r112 = nsf.getCOROUTINE_SUSPENDED();
        boolean r215 = this.b;
        if (r215 == false) goto L112;
        if (r215 != true) goto L111;
        gti.r(r20);
    L118:
        r63.a = null;
        return r5;
    L111:
        jfn.u("call to 'resume' before 'invoke' with coroutine");
        return null;
    L112:
        gti.r(r20);
        tvc r74 = (tvc) r7;
        e8g r216 = ue0.l;
        Object r34 = r63.a;
        if (r34 != r216) goto L115;
        r34 = null;
    L115:
        this.b = true;
        if (r74.emit(r34, this) != r112) goto L118;
        return r112;
    L120:
        Object r113 = nsf.getCOROUTINE_SUSPENDED();
        boolean r217 = this.b;
        if (r217 == false) goto L125;
        if (r217 != true) goto L124;
        gti.r(r20);
        return r20;
    L124:
        jfn.u("call to 'resume' before 'invoke' with coroutine");
        return null;
    L125:
        gti.r(r20);
        fnb r75 = (fnb) r7;
        a1k r218 = r75.c;
        zw2 r35 = r75.g;
        this.b = true;
        r218.getClass();
        Object r06 = zw2.F(r35, new ab2((ArrayList) r6), this);
        if (r06 == r113) goto L128;
        return r06;
    L128:
        return r113;
    L129:
        Object r114 = nsf.getCOROUTINE_SUSPENDED();
        boolean r219 = this.b;
        if (r219 == false) goto L134;
        if (r219 != true) goto L133;
        gti.r(r20);
        return r20;
    L133:
        jfn.u("call to 'resume' before 'invoke' with coroutine");
        return null;
    L134:
        gti.r(r20);
        this.b = true;
        int r220 = DeviceDebugActivity.h;
        Object r07 = ((DeviceDebugActivity) r7).l((String) r6, this);
        if (r07 == r114) goto L137;
        return r07;
    L137:
        return r114;
    L138:
        Object r115 = nsf.getCOROUTINE_SUSPENDED();
        boolean r221 = this.b;
        if (r221 == false) goto L143;
        if (r221 != true) goto L142;
        gti.r(r20);
        Object r08 = ((pfo) r20).a;
    L146:
        gti.r(r08);
        return r5;
    L142:
        jfn.u("call to 'resume' before 'invoke' with coroutine");
        return null;
    L143:
        gti.r(r20);
        cz9 r76 = (cz9) r7;
        this.b = true;
        r08 = r76.f.a.b(r76.a, (SpeedLevel) r6, this);
        if (r08 != r115) goto L146;
        return r115;
    L148:
        Object r116 = nsf.getCOROUTINE_SUSPENDED();
        boolean r222 = this.b;
        if (r222 == false) goto L153;
        if (r222 != true) goto L152;
        gti.r(r20);
        Object r09 = ((pfo) r20).a;
    L156:
        gti.r(r09);
        return r5;
    L152:
        jfn.u("call to 'resume' before 'invoke' with coroutine");
        return null;
    L153:
        gti.r(r20);
        cz9 r77 = (cz9) r7;
        this.b = true;
        r09 = r77.f.d.a(r77.a, (fs7) r6, this);
        if (r09 != r116) goto L156;
        return r116;
    L158:
        Object r117 = nsf.getCOROUTINE_SUSPENDED();
        boolean r223 = this.b;
        if (r223 == false) goto L163;
        if (r223 != true) goto L162;
        gti.r(r20);
        return r20;
    L162:
        jfn.u("call to 'resume' before 'invoke' with coroutine");
        return null;
    L163:
        gti.r(r20);
        this.b = true;
        wq3 r224 = be3.e;
        Object r010 = ((be3) r7).h((sjp) r6, this);
        if (r010 == r117) goto L166;
        return r010;
    L166:
        return r117;
    L167:
        Object r118 = nsf.getCOROUTINE_SUSPENDED();
        boolean r225 = this.b;
        if (r225 == false) goto L172;
        if (r225 != true) goto L171;
        gti.r(r20);
        return r5;
    L171:
        jfn.u("call to 'resume' before 'invoke' with coroutine");
        return null;
    L172:
        gti.r(r20);
        this.b = true;
        if (((ks) r7).i((gv) r6, this) == r118) goto L175;
        return r5;
    L175:
        return r118;
    L176:
        hw1 r64 = (hw1) r6;
        alj r119 = ((iw1) r7).c;
        Object r226 = nsf.getCOROUTINE_SUSPENDED();
        boolean r36 = this.b;
        if (r36 == false) goto L184;
        if (r36 != true) goto L183;
        gti.r(r20);     // Catch: Throwable -> L181
    L191:
        r119 = (o6q) r119;
        r119.setValue(null);
        return r5;
    L183:
        jfn.u("call to 'resume' before 'invoke' with coroutine");
        return null;
    L184:
        gti.r(r20);
        ((o6q) r119).setValue(r64);     // Catch: Throwable -> L181
        this.b = true;     // Catch: Throwable -> L181
        Object r011 = r64.b.r(this);     // Catch: Throwable -> L181
        if (r011 == nsf.getCOROUTINE_SUSPENDED()) goto L189;
        r011 = r5;
    L189:
        if (r011 != r226) goto L191;
        return r226;
    L181:
        th = move-exception;
        ((o6q) r119).setValue(null);
        throw th;
    L195:
        Object r120 = nsf.getCOROUTINE_SUSPENDED();
        boolean r227 = this.b;
        if (r227 == false) goto L200;
        if (r227 != true) goto L199;
        gti.r(r20);
        return r20;
    L199:
        jfn.u("call to 'resume' before 'invoke' with coroutine");
        return null;
    L200:
        gti.r(r20);
        wxj r228 = ((yn1) r7).g;
        String r65 = (String) r6;
        this.b = true;
        r228.getClass();
        BblpSpeedLevel[] r37 = BblpSpeedLevel.values();
        int r55 = r37.length;
    L201:
        if (r4 >= r55) goto L206;
        BblpSpeedLevel r78 = r37[r4];
        if (lsf.l(r78.name(), r65) == true) goto L204;
        r4 = r4 + 1;
        goto L201
    L204:
        r10 = r78;
    L206:
        if (r10 != null) goto L208;
        r10 = BblpSpeedLevel.STANDARD;
    L208:
        Object r012 = zw2.F(r228.l(), new za2(r10), this);
        if (r012 == r120) goto L211;
        return r012;
    L211:
        return r120;
    L212:
        Object r121 = nsf.getCOROUTINE_SUSPENDED();
        boolean r229 = this.b;
        if (r229 == false) goto L217;
        if (r229 != true) goto L216;
        gti.r(r20);
        return r20;
    L216:
        jfn.u("call to 'resume' before 'invoke' with coroutine");
        return null;
    L217:
        gti.r(r20);
        wxj r230 = ((yn1) r7).g;
        pn1 r66 = (pn1) r6;
        boolean r38 = r66.k;
        boolean r410 = r66.l;
        boolean r56 = r66.m;
        this.b = true;
        Object r013 = zw2.F(r230.l(), new p92(r38, r410, r56), this);
        if (r013 == r121) goto L220;
        return r013;
    L220:
        return r121;
    L221:
        gk0 r79 = (gk0) r7;
        ?? r122 = r79.e;
        View r231 = r79.a;
        Object r11 = nsf.getCOROUTINE_SUSPENDED();
        boolean r123 = this.b;
        if (r123 == false) goto L229;
        if (r123 != true) goto L228;
        gti.r(r20);     // Catch: Throwable -> L226
    L254:
        r122.a();
        Looper r014 = Looper.myLooper();
        r122 = r231.getHandler();
        if (r122 == 0) goto L257;
        Looper r124 = r122.getLooper();
    L258:
        if (r014 == r124) goto L263;
        Runnable r015 = r79.j;
        if (r015 != null) goto L262;
        r015 = new up0(r79, r9);
        r79.j = r015;
    L262:
        rs4.boxBoolean(r231.post(r015));
    L266:
        wai r016 = r79.i;
        if (r016 == null) goto L269;
        rs4.boxBoolean(r231.removeCallbacks(r016));
    L269:
        r79.h = null;
        return r5;
    L263:
        ActionMode r017 = r79.h;
        if (r017 == null) goto L266;
        r017.finish();
        goto L266
    L257:
        r124 = null;
        goto L258
    L228:
        jfn.u("call to 'resume' before 'invoke' with coroutine");
        return null;
    L229:
        gti.r(r20);
        fk0 r82 = new fk0();
        fjr r67 = (fjr) r6;
        ek0 r125 = new ek0(r82, new bk0(r79, r67, r44 ? 1 : 0), new bk0(r79, r67, r9), r231);
        Function1 r411 = r79.b;
        if (r411 == null) goto L235;
        ?? r412 = (eir) r411.invoke(r125);
        if (r412 == 0) goto L235;
        r125 = r412;
    L235:
        Looper r413 = Looper.myLooper();
        Handler r68 = r231.getHandler();
        if (r68 == null) goto L238;
        Looper r69 = r68.getLooper();
    L239:
        if (r413 == r69) goto L244;
        wai r414 = r79.i;
        if (r414 != null) goto L243;
        r414 = new wai(r79, r125, r82, r3);
        r79.i = r414;
    L243:
        rs4.boxBoolean(r231.post(r414));
    L248:
        this.b = true;     // Catch: Throwable -> L226
        Object r018 = r82.a.r(this);     // Catch: Throwable -> L226
        if (r018 == nsf.getCOROUTINE_SUSPENDED()) goto L252;
        r018 = r5;
    L252:
        if (r018 != r11) goto L254;
        return r11;
    L244:
        ActionMode r39 = r231.startActionMode(new qvc(r125), 1);
        if (r39 == null) goto L392;
        r79.h = r39;
        goto L248
    L392:
        return r5;
    L238:
        r69 = null;
    L226:
        th = move-exception;
        r122.a();
        Looper r126 = Looper.myLooper();
        Handler r310 = r231.getHandler();
        if (r310 == null) goto L274;
        Looper r311 = r310.getLooper();
    L275:
        if (r126 == r311) goto L280;
        Runnable r127 = r79.j;
        if (r127 != null) goto L279;
        r127 = new up0(r79, r9);
        r79.j = r127;
    L279:
        rs4.boxBoolean(r231.post(r127));
    L283:
        wai r128 = r79.i;
        if (r128 == null) goto L286;
        rs4.boxBoolean(r231.removeCallbacks(r128));
    L286:
        r79.h = null;
        throw th;
    L280:
        ActionMode r129 = r79.h;
        if (r129 == null) goto L283;
        r129.finish();
        goto L283
    L274:
        r311 = null;
        goto L275
    L288:
        hc0 r710 = (hc0) r7;
        Object r130 = nsf.getCOROUTINE_SUSPENDED();
        boolean r312 = this.b;
        if (r312 == false) goto L293;
        if (r312 != true) goto L292;
        gti.r(r20);
    L296:
        x2b r019 = r710.c();
        fjj r131 = r710.j;
        Object r020 = r019.b(((h6q) r131).d());
        if (r020 != null) goto L299;
        return r5;
    L299:
        if (Math.abs(((h6q) r131).d() - r710.c().c(r020)) < 0.5f) goto L301;
        return r5;
    L301:
        if (((Boolean) r710.a.invoke(r020)).booleanValue() == false) goto L397;
        ((o6q) r710.h).setValue(r020);
        ((o6q) r710.g).setValue(r020);
        return r5;
    L397:
        return r5;
    L292:
        jfn.u("call to 'resume' before 'invoke' with coroutine");
        return null;
    L293:
        gti.r(r20);
        xb0 r313 = new xb0(r710, r43 ? 1 : 0);
        xf8 r415 = new xf8((gpd) r6, r710, r103 ? 1 : 0, r2);
        this.b = true;
        if (f67.M(r313, r415, this) != r130) goto L296;
        return r130;
    L304:
        Object r133 = nsf.getCOROUTINE_SUSPENDED();
        boolean r232 = this.b;
        if (r232 == false) goto L309;
        if (r232 != true) goto L308;
        gti.r(r20);
        return r5;
    L308:
        jfn.u("call to 'resume' before 'invoke' with coroutine");
        return null;
    L309:
        gti.r(r20);
        gc0 r711 = (gc0) r7;
        wb0 r233 = new wb0(r711, r42 ? 1 : 0);
        xf8 r314 = new xf8((gpd) r6, r711, r102 ? 1 : 0, ek.l);
        this.b = true;
        if (fy4.x(r233, r314, this) == r133) goto L312;
        return r5;
    L312:
        return r133;
    L313:
        Object r134 = nsf.getCOROUTINE_SUSPENDED();
        boolean r234 = this.b;
        if (r234 == false) goto L318;
        if (r234 != true) goto L317;
        gti.r(r20);
        return r20;
    L317:
        jfn.u("call to 'resume' before 'invoke' with coroutine");
        return null;
    L318:
        gti.r(r20);
        zw2 r235 = ((l20) r7).f;
        x10 r610 = (x10) r6;
        h82 r315 = new h82(r610.v, r610.w, r610.x);
        this.b = true;
        Object r021 = zw2.F(r235, r315, this);
        if (r021 == r134) goto L321;
        return r021;
    L321:
        return r134;
    L322:
        Object r135 = nsf.getCOROUTINE_SUSPENDED();
        boolean r236 = this.b;
        if (r236 == false) goto L327;
        if (r236 != true) goto L326;
        gti.r(r20);
        return r20;
    L326:
        jfn.u("call to 'resume' before 'invoke' with coroutine");
        return null;
    L327:
        gti.r(r20);
        zw2 r237 = ((l20) r7).f;
        b82 r316 = new b82((BblpAmsControlAction) r6);
        this.b = true;
        Object r022 = zw2.F(r237, r316, this);
        if (r022 == r135) goto L330;
        return r022;
    L330:
        return r135;
    }
}
