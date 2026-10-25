package defpackage;

import android.content.Context;
import android.content.res.Configuration;
import androidx.compose.foundation.layout.FillElement;
import androidx.compose.foundation.layout.b;
import androidx.compose.runtime.f;
import androidx.compose.ui.node.LayoutNode;
import androidx.navigation3.runtime.NavBackStack;
import com.bambulab.bambulab.model.BizType;
import com.bambulab.bambulab.model.BizTypeKt;
import com.bambulab.bambulab.model.DeviceData;
import com.bambulab.bambulab.model.IotPlate;
import com.bambulab.bambulab.model.IotPlateObjectId;
import com.bambulab.bambulab.model.PlateImage;
import com.bambulab.bambulab.model.PrintHistoryModel;
import com.bambulab.bambulab.navigation.route.HomeAppRoute;
import com.bambulab.creator.R;
import com.brentvatne.exoplayer.ReactExoplayerView;
import com.tutk.IOTC.AVIOCTRLDEFs;
import com.umeng.analytics.pro.ek;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import io.agora.rtc2.internal.AudioRoutingController;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* loaded from: classes3.dex */
public abstract class rk9 {
    /* JADX WARN: Multi-variable type inference failed */
    public static final void a(jl9 r23, il9 r24, boolean r25, String r26, yl9 r27, final nod r28, o07 r29, int r30) {
        grd r12 = r29.z(1667932355);
        if (r23 != null) goto L5;
        int r1 = -1;
    L6:
        final byte r3 = 2;
        if (r12.u(r1) == false) goto L9;
        int r13 = 4;
    L10:
        int r14 = r30 | r13;
        if (r12.q(r24) == false) goto L13;
        int r5 = 32;
    L14:
        int r15 = r14 | r5;
        if (r12.s(r25) == false) goto L17;
        int r52 = 256;
    L18:
        int r16 = r15 | r52;
        if (r12.q(r26) == false) goto L21;
        int r53 = 2048;
    L22:
        int r17 = r16 | r53;
        if (r12.J(r27) == false) goto L25;
        int r54 = 16384;
    L26:
        int r18 = r17 | r54;
        final byte r132 = 0;
        if ((74899 & r18) == 74898) goto L29;
        boolean r55 = true;
    L31:
        if (r12.D(r18 & 1, r55) == false) goto L150;
        if (r23 != null) goto L34;
        int r56 = -1;
    L35:
        if (r56 == (-1)) goto L149;
        fqu r142 = n07.a;
        if (r56 == 1) goto L126;
        final byte r152 = 3;
        if (r56 == 2) goto L92;
        final byte r32 = 6;
        if (r56 == 3) goto L69;
        if (r56 == 4) goto L44;
        r12.r(860320000);
        Set r4 = yl9.G0;
        g(r23, r25, r27, r28, r12, ((((r18 & 14) | ((r18 >> 3) & 112)) | 512) | ((r18 >> 6) & AVIOCTRLDEFs.IOTYPE_USER_IPCAM_FORMATEXTSTORAGE_REQ)) | 3072);
        jl9 r2 = r23;
        r12.X(false);
        final yl9 r57 = r27;
    L151:
        evn r9 = r12.Z();
        if (r9 == null) goto L155;
        r9.d = new f8(12, r30, r28, r2, r24, r26, r57, r25);
        return;
    L155:
        return;
    L44:
        r2 = r23;
        r12.r(899282512);
        w13 r0 = (w13) r12.P(x13.c);
        ctk r33 = gti.n(R.drawable.ic_error_outline, r12, 0);
        String r153 = f5j.D(r12, R.string.confirmPrinting);
        if (r26 != null) goto L48;
        String r162 = "";
    L49:
        String r10 = f5j.D(r12, R.string.print);
        String r11 = f5j.D(r12, R.string.cancel);
        long r133 = r0.h0;
        long r42 = r0.G0;
        if ((r18 & 57344) == 16384) goto L55;
        yl9 r02 = r27;
        if (r12.J(r02) == true) goto L56;
        boolean r92 = false;
    L58:
        if ((r18 & 14) != 4) goto L60;
        boolean r172 = true;
    L61:
        boolean r19 = r92 | r172;
        Object r34 = r12.I();
        if (r19 == false) goto L64;
    L67:
        boolean r110 = false;
        r34 = new xj9(r28, r02, r2, 0 == true ? 1 : 0);
        r12.E(r34);
    L68:
        tx2.a(r33, r153, r162, r10, (nod) r34, r28, null, r11, r28, r133, new a96(r42), ux2.a, r12, 100859912, 64);
        r12 = r12;
        r12.X(r110);
        r57 = r02;
        goto L151
    L64:
        if (r34 == r142) goto L67;
        r110 = false;
        goto L68
    L60:
        r172 = false;
    L56:
        r92 = true;
        goto L58
    L55:
        r02 = r27;
        goto L56
    L48:
        r162 = r26;
        goto L49
    L69:
        r57 = r27;
        r2 = r23;
        r12.r(898276748);
        String r112 = f5j.D(r12, R.string.nozzleClumpingRecommendAutoModeTitle);
        String r03 = f5j.D(r12, R.string.confirm);
        String r134 = f5j.D(r12, R.string.ignore);
        int r111 = r18 & 57344;
        if (r111 != 16384) goto L72;
    L75:
        boolean r102 = true;
    L76:
        Object r143 = r12.I();
        if (r102 == true) goto L79;
        if (r143 == r142) goto L79;
    L80:
        nod r103 = (nod) r143;
        if (r111 != 16384) goto L83;
    L86:
        boolean r173 = true;
    L87:
        Object r113 = r12.I();
        if (r173 == true) goto L90;
        if (r113 == r142) goto L90;
    L91:
        et2.b(true, r28, r03, r103, r112, msu.c, r134, (nod) r113, false, false, null, null, r12, 196662, 0, 3840);
        r12 = r12;
        r12.X(false);
    L90:
        r113 = new wj9(r28, r57, r32);
        r12.E(r113);
        goto L91
    L83:
        if (r12.J(r57) == true) goto L86;
        r173 = false;
    L79:
        final byte r104 = 5;
        r143 = new wj9(r28, r57, r104);
        r12.E(r143);
        goto L80
    L72:
        if (r12.J(r57) == true) goto L75;
        r102 = false;
        goto L76
    L92:
        r57 = r27;
        r2 = r23;
        r12.r(860235969);
        int r04 = r18 & 57344;
        if (r04 != 16384) goto L95;
    L98:
        boolean r135 = true;
    L99:
        Object r105 = r12.I();
        if (r135 == true) goto L102;
        if (r105 == r142) goto L102;
    L103:
        nod r106 = (nod) r105;
        if (r04 != 16384) goto L106;
    L109:
        boolean r136 = true;
    L110:
        Object r35 = r12.I();
        if (r136 == true) goto L113;
        if (r35 == r142) goto L113;
    L114:
        nod r36 = (nod) r35;
        if (r04 != 16384) goto L117;
    L120:
        boolean r114 = true;
    L121:
        Object r05 = r12.I();
        if (r114 == true) goto L124;
        if (r05 == r142) goto L124;
    L125:
        h(r24, r106, r36, (nod) r05, r28, r12, (r18 >> 3) & 57358);
        r12.X(false);
    L124:
        final byte r7 = 4;
        r05 = new wj9(r28, r57, r7);
        r12.E(r05);
        goto L125
    L117:
        if (r12.J(r57) == true) goto L120;
        r114 = false;
    L113:
        r35 = new wj9(r28, r57, r152);
        r12.E(r35);
        goto L114
    L106:
        if (r12.J(r57) == true) goto L109;
        r136 = false;
    L102:
        r105 = new wj9(r28, r57, r3);
        r12.E(r105);
        goto L103
    L95:
        if (r12.J(r57) == true) goto L98;
        r135 = false;
        goto L99
    L126:
        r57 = r27;
        r2 = r23;
        r12.r(896660470);
        String r115 = f5j.D(r12, R.string.confirmNozzleInfo);
        String r06 = f5j.D(r12, R.string.confirm);
        String r137 = f5j.D(r12, R.string.refresh);
        int r116 = r18 & 57344;
        if (r116 != 16384) goto L129;
    L132:
        boolean r37 = true;
    L133:
        Object r107 = r12.I();
        if (r37 == true) goto L136;
        if (r107 == r142) goto L136;
    L137:
        nod r108 = (nod) r107;
        if (r116 != 16384) goto L140;
    L143:
        boolean r117 = true;
    L144:
        Object r38 = r12.I();
        if (r117 == true) goto L147;
        if (r38 == r142) goto L147;
    L148:
        et2.b(true, r28, r06, r108, r115, msu.b, r137, (nod) r38, false, false, null, null, r12, 196662, 0, 3840);
        r12 = r12;
        r12.X(false);
    L147:
        final byte r118 = 1;
        r38 = new wj9(r28, r57, r118);
        r12.E(r38);
        goto L148
    L140:
        if (r12.J(r57) == true) goto L143;
        r117 = false;
    L136:
        r107 = new wj9(r28, r57, r132);
        r12.E(r107);
        goto L137
    L129:
        if (r12.J(r57) == true) goto L132;
        r37 = false;
        goto L133
    L149:
        r57 = r27;
        r2 = r23;
        r12.r(860202183);
        r12.X(false);
        goto L151
    L34:
        r56 = pk9.a[r23.ordinal()];
        goto L35
    L150:
        r57 = r27;
        r2 = r23;
        r12.m();
        goto L151
    L29:
        r55 = false;
        goto L31
    L25:
        r54 = 8192;
        goto L26
    L21:
        r53 = 1024;
        goto L22
    L17:
        r52 = 128;
        goto L18
    L13:
        r5 = 16;
        goto L14
    L9:
        r13 = 2;
        goto L10
    L5:
        r1 = r23.ordinal();
        goto L6
    }

    public static final void b(String r26, o07 r27, int r28) {
        grd r1 = r27.z(72964932);
        if (r1.q(r26) == false) goto L5;
        int r2 = 4;
    L6:
        int r22 = r28 | r2;
        if ((r22 & 3) == 2) goto L9;
        boolean r3 = true;
    L11:
        if (r1.D(r22 & 1, r3) == false) goto L13;
        grd r21 = r1;
        onr.b(r26, null, ((w13) r1.P(x13.c)).J, null, npr.m(14), null, null, 0, null, null, npr.l(21.0d), 0, false, 0, 0, null, null, r21, (r22 & 14) | 24576, 48, 260074);
    L14:
        evn r12 = r21.Z();
        if (r12 == null) goto L18;
        r12.d = new ck9(r26, r28, 0);
        return;
    L18:
        return;
    L13:
        r21 = r1;
        r21.m();
        goto L14
    L9:
        r3 = false;
        goto L11
    L5:
        r2 = 2;
        goto L6
    }

    public static final void c(yl9 r14, o0o r15, nod r16, Function1 r17, agq r18, nod r19, t63 r20, nod r21, Function1 r22, Function1 r23, o07 r24, int r25) {
        grd r0 = r24.z(450487299);
        if (r0.J(r14) == false) goto L5;
        int r1 = 4;
    L6:
        int r12 = r25 | r1;
        if (r0.q(r15) == false) goto L9;
        int r5 = 32;
    L10:
        int r13 = r12 | r5;
        if (r0.J(r16) == false) goto L13;
        int r6 = 256;
    L14:
        int r110 = r13 | r6;
        if (r0.J(r17) == false) goto L17;
        int r7 = 2048;
    L18:
        int r111 = r110 | r7;
        if (r0.q(r18) == false) goto L21;
        int r8 = 16384;
    L22:
        int r112 = r111 | r8;
        if (r0.q(r20) == false) goto L25;
        int r9 = 1048576;
    L26:
        int r113 = r112 | r9;
        if ((306783379 & r113) == 306783378) goto L29;
        boolean r92 = true;
    L31:
        if (r0.D(r113 & 1, r92) == false) goto L33;
        d0j.d("DesignPrintScreen", r0, 6);
        lsf.c("MWPreparePrint", null, r0, 6, 2);
        xpr.b(false, mi6.v(368512721, new oj9(r14, r15, r16, r17, r18, r19, r20, r21, r22, r23), r0), r0, 48, 1);
    L34:
        evn r02 = r0.Z();
        if (r02 == null) goto L38;
        r02.d = new oj9(r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r25, 1);
        return;
    L38:
        return;
    L33:
        r0.m();
        goto L34
    L29:
        r92 = false;
        goto L31
    L25:
        r9 = CommonNetImpl.MAX_SEND_SIZE_IN_KB;
        goto L26
    L21:
        r8 = 8192;
        goto L22
    L17:
        r7 = 1024;
        goto L18
    L13:
        r6 = 128;
        goto L14
    L9:
        r5 = 16;
        goto L10
    L5:
        r1 = 2;
        goto L6
    }

    public static final void d(final yl9 r53, o0o r54, nod r55, final Function1 r56, agq r57, nod r58, t63 r59, nod r60, Function1 r61, Function1 r62, o07 r63, int r64) {
        yl9 r1 = r53;
        grd r8 = r63.z(674777058);
        if (r8.J(r1) == false) goto L5;
        int r0 = 4;
    L6:
        int r02 = r64 | r0;
        if (r8.q(r54) == false) goto L9;
        int r2 = 32;
    L10:
        int r03 = r02 | r2;
        if (r8.J(r55) == false) goto L13;
        int r22 = 256;
    L14:
        int r04 = r03 | r22;
        if (r8.J(r56) == false) goto L17;
        int r23 = 2048;
    L18:
        int r05 = r04 | r23;
        if (r8.q(r57) == false) goto L21;
        int r24 = 16384;
    L22:
        int r06 = r05 | r24;
        if (r8.J(r58) == false) goto L25;
        int r3 = 131072;
    L26:
        int r07 = r06 | r3;
        if (r8.q(r59) == false) goto L29;
        int r4 = 1048576;
    L30:
        int r08 = r07 | r4;
        if (r8.J(r60) == false) goto L33;
        int r5 = AudioRoutingController.DEVICE_OUTPUT_OUT_IP;
    L34:
        int r09 = r08 | r5;
        if (r8.J(r61) == false) goto L37;
        int r6 = AudioRoutingController.DEVICE_OUT_USB_HEADSET;
    L38:
        int r010 = r09 | r6;
        if (r8.J(r62) == false) goto L41;
        int r7 = CommonNetImpl.FLAG_SHARE;
    L42:
        int r011 = r010 | r7;
        if ((306783379 & r011) == 306783378) goto L45;
        boolean r72 = true;
    L47:
        if (r8.D(r011 & 1, r72) == false) goto L179;
        NavBackStack r11 = (NavBackStack) r8.P(vo1.a);
        Configuration r73 = (Configuration) r8.P(ve0.a);
        boolean r16 = r8.q(r73);
        Object r13 = r8.I();
        fqu r74 = n07.a;
        Object r132 = r13;
        if (r16 == true) goto L51;
        if (r13 == r74) goto L51;
    L52:
        String r133 = (String) r132;
        fwj r9 = (fwj) r8.P(gwj.a);
        alj r012 = mi6.j(r1.v, r8, 0);
        Context r65 = (Context) r8.P(ve0.b);
        Object r013 = r8.I();
        Object r014 = r013;
        if (r013 != r74) goto L55;
        lm7 r015 = idb.i(zfb.INSTANCE, r8);
        r8.E(r015);
        r014 = r015;
    L55:
        final lm7 r28 = (lm7) r014;
        rig r66 = uig.a(0, 0, r8, 3);
        int r67 = r011 & 14;
        if (r67 != 4) goto L58;
    L61:
        boolean r016 = true;
    L62:
        Object r25 = r8.I();
        if (r016 == true) goto L67;
        if (r25 == r74) goto L67;
        int r33 = r67;
        fqu r35 = r74;
        int r29 = r011;
        Context r31 = r65;
        alj r30 = r012;
        rig r32 = r66;
        byte r10 = 0;
        int r34 = 3;
    L68:
        final fgq r15 = new fgq(r57, r58, r59, r60, r62, r61, (Function1) ((v1g) r25), (xhc) r1.p.f);
        alj r36 = mi6.j(r9.C, r8, r10);
        xvj r68 = (xvj) r36.getValue();
        boolean r017 = r8.q(r36);
        int r75 = r33;
        if (r75 != 4) goto L71;
    L74:
        byte r26 = 1;
    L75:
        int r018 = ((r017 ? 1 : 0) | r26) | (r8.J(r9) ? 1 : 0);
        Object r27 = r8.I();
        rf7 r42 = null;
        fqu r152 = r35;
        if (r018 != 0) goto L80;
        if (r27 == r152) goto L80;
        wl9 r332 = null;
    L81:
        idb.e(r8, r68, (Function2) r27);
        Object r019 = r8.I();
        Object r020 = r019;
        if (r019 != r152) goto L84;
        alj r021 = f.f(Boolean.FALSE);
        r8.E(r021);
        r020 = r021;
    L84:
        alj r92 = (alj) r020;
        Object r022 = r8.I();
        Object r023 = r022;
        if (r022 != r152) goto L87;
        alj r024 = f.f("");
        r8.E(r024);
        r023 = r024;
    L87:
        alj r025 = (alj) r023;
        Object r210 = r8.I();
        Object r211 = r210;
        if (r210 != r152) goto L90;
        alj r212 = f.f(r332);
        r8.E(r212);
        r211 = r212;
    L90:
        final alj r162 = (alj) r211;
        Object r213 = r8.I();
        Object r214 = r213;
        if (r213 != r152) goto L93;
        alj r215 = f.f(r332);
        r8.E(r215);
        r214 = r215;
    L93:
        alj r17 = (alj) r214;
        Object r216 = r8.I();
        Object r217 = r216;
        if (r216 != r152) goto L96;
        alj r218 = f.f(egb.a);
        r8.E(r218);
        r217 = r218;
    L96:
        alj r18 = (alj) r217;
        Object r219 = r8.I();
        Object r220 = r219;
        if (r219 != r152) goto L99;
        alj r221 = f.f(r332);
        r8.E(r221);
        r220 = r221;
    L99:
        alj r19 = (alj) r220;
        Object r222 = r8.I();
        Object r223 = r222;
        if (r222 != r152) goto L102;
        alj r224 = f.f(r332);
        r8.E(r224);
        r223 = r224;
    L102:
        final alj r20 = (alj) r223;
        Context r225 = r31;
        boolean r37 = r8.q(r225);
        Object r43 = r8.I();
        Object r44 = r43;
        if (r37 == true) goto L105;
        if (r43 == r152) goto L105;
    L106:
        final Function1 r312 = (Function1) r44;
        final String r352 = f5j.D(r8, R.string.fromMakerLab);
        final String r372 = f5j.D(r8, R.string.fromMakerKids);
        Object r38 = r8.I();
        Object r39 = r38;
        if (r38 != r152) goto L109;
        alj r310 = f.f(Boolean.FALSE);
        r8.E(r310);
        r39 = r310;
    L109:
        alj r311 = (alj) r39;
        Object r45 = r8.I();
        Object r46 = r45;
        if (r45 != r152) goto L112;
        alj r47 = f.f(r332);
        r8.E(r47);
        r46 = r47;
    L112:
        final alj r226 = (alj) r46;
        Object r48 = r8.I();
        Object r49 = r48;
        if (r48 != r152) goto L115;
        alj r410 = f.f(r332);
        r8.E(r410);
        r49 = r410;
    L115:
        final alj r232 = (alj) r49;
        Object r411 = r8.I();
        Object r412 = r411;
        if (r411 != r152) goto L118;
        alj r413 = f.f(r332);
        r8.E(r413);
        r412 = r413;
    L118:
        final alj r21 = (alj) r412;
        Object r414 = r8.I();
        Object r415 = r414;
        if (r414 != r152) goto L121;
        alj r416 = f.f(r332);
        r8.E(r416);
        r415 = r416;
    L121:
        alj r417 = (alj) r415;
        Object r52 = r8.I();
        Object r510 = r52;
        if (r52 != r152) goto L124;
        ljj r511 = f.b(r10);
        r8.E(r511);
        r510 = r511;
    L124:
        ljj r512 = (ljj) r510;
        Object r69 = r8.I();
        Object r610 = r69;
        if (r69 != r152) goto L127;
        ljj r611 = f.b(r10);
        r8.E(r611);
        r610 = r611;
    L127:
        ljj r612 = (ljj) r610;
        if (r75 != 4) goto L130;
    L133:
        boolean r272 = true;
    L134:
        alj r102 = r30;
        final rig r026 = r32;
        boolean r273 = ((r272 | r8.J(r225)) | r8.q(r102)) | r8.q(r026);
        if ((r29 & AVIOCTRLDEFs.IOTYPE_USER_IPCAM_FORMATEXTSTORAGE_REQ) != 256) goto L137;
        boolean r027 = true;
    L138:
        boolean r028 = (r273 | r027) | r8.J(r11);
        if ((r29 & 112) == 32) goto L141;
        boolean r029 = false;
    L142:
        boolean r030 = (r028 | r029) | r8.q(r133);
        Object r12 = r8.I();
        if (r030 == true) goto L147;
        if (r12 == r152) goto L147;
        Context r172 = r225;
        int r227 = 2;
        final alj r242 = r92;
        NavBackStack r93 = r11;
        alj r112 = r17;
        Object r031 = r12;
        alj r134 = r311;
        alj r122 = r417;
        ljj r14 = r512;
        int r41 = r75;
        fqu r422 = r152;
        final alj r153 = r18;
        final alj r182 = r19;
        final alj r252 = r025;
        boolean r382 = false;
        yl9 r110 = r53;
        ljj r192 = r612;
        grd r82 = r8;
    L148:
        idb.e(r82, trs.a, (Function2) r031);
        String r032 = f5j.D(r82, R.string.ok);
        String r313 = f5j.D(r82, R.string.gotIt);
        xl9 r418 = (xl9) r102.getValue();
        if ((r418 instanceof wl9) == false) goto L151;
        wl9 r419 = (wl9) r418;
    L152:
        if (r419 == null) goto L158;
        HomeAppRoute.DesignPrint r420 = r419.a;
        if (r420 == null) goto L158;
        boolean r513 = true;
        if (r420.getEnableAddToQueue() == true) goto L160;
    L159:
        r34 = r227;
    L160:
        ook r228 = new ook(0.0f, 0.0f, 0.0f, 0.0f);
        if (r41 != 4) goto L163;
    L166:
        Object r421 = r82.I();
        if (r513 == true) goto L172;
        fqu r514 = r422;
        if (r421 == r514) goto L173;
        ook r442 = r228;
        NavBackStack r632 = r93;
        alj r302 = r102;
        alj r274 = r112;
        int r262 = r34;
        String r94 = r032;
        String r103 = r313;
        fqu r113 = r514;
    L174:
        v1g r423 = (v1g) r421;
        Integer r482 = Integer.valueOf(r262);
        int r229 = r262;
        boolean r033 = (r82.u(r229) | r82.q(r103)) | r82.q(r94);
        Object r111 = r82.I();
        Object r114 = r111;
        if (r033 == true) goto L177;
        if (r111 == r113) goto L177;
    L178:
        xo2 r432 = new xo2(r442, 12.0f, 0, r482, (Function1) r114, (nod) r423, 12);
        final alj r202 = r134;
        final ljj r135 = r14;
        final ljj r142 = r192;
        final NavBackStack r424 = r632;
        final Context r104 = r172;
        final alj r173 = r274;
        final alj r314 = r302;
        final alj r2110 = r122;
        grd r515 = r82;
        hp2.a(null, r432, false, mi6.v(414736684, new zj9(r53, r026, r314, r424, r352, r372, r312, r21, r28, r104, r56, r15, r135, r142, r153, r162, r173, r182, r20, r202, r2110, r226, r232, r242, r252), r515), r515, 3072, 5);
    L180:
        evn r136 = r515.Z();
        if (r136 == null) goto L184;
        r136.d = new oj9(r53, r54, r55, r56, r57, r58, r59, r60, r61, r62, r64, 2);
        return;
    L184:
        return;
    L177:
        m91 r115 = new m91(r229, r103, r94, 5);
        r82.E(r115);
        r114 = r115;
    L173:
        fqu r425 = r514;
        r442 = r228;
        r632 = r93;
        r302 = r102;
        r103 = r313;
        r94 = r032;
        r262 = r34;
        r274 = r112;
        r113 = r425;
        hr7 r034 = new hr7(0, r53, yl9.class, "dismissPreparePrintGuide", "dismissPreparePrintGuide()V", 0, 9);
        r82.E(r034);
        r421 = r034;
        goto L174
    L172:
        r514 = r422;
        goto L173
    L163:
        if (r82.J(r110) == true) goto L166;
        r513 = r382;
    L158:
        r513 = true;
        goto L159
    L151:
        r419 = r332;
    L147:
        r422 = r152;
        r41 = r75;
        r382 = false;
        r110 = r53;
        r134 = r311;
        r031 = new nk9(r110, r225, r026, r55, r11, r54, r133, r025, r92, r102, r512, r612, r134, r226, r232, r162, r17, r18, r19, r20, r21, r417, null);
        r252 = r025;
        r232 = r232;
        r153 = r18;
        r182 = r19;
        grd r83 = r8;
        r192 = r612;
        r122 = r417;
        r226 = r226;
        r14 = r512;
        r112 = r17;
        r172 = r225;
        r227 = 2;
        r242 = r92;
        r93 = r11;
        r83.E(r031);
        r82 = r83;
        goto L148
    L141:
        r029 = true;
        goto L142
    L137:
        r027 = false;
        goto L138
    L130:
        if (r8.J(r1) == true) goto L133;
        r272 = false;
    L105:
        vj9 r426 = new vj9(r225, r10);
        r8.E(r426);
        r44 = r426;
    L80:
        l80 r035 = new l80(r1, r9, r36, r42, 24);
        r332 = null;
        r8.E(r035);
        r27 = r035;
        goto L81
    L71:
        if (r8.J(r1) == true) goto L74;
        r26 = r10;
    L67:
        r10 = 0;
        r34 = 3;
        r33 = r67;
        r29 = r011;
        r31 = r65;
        r30 = r012;
        r32 = r66;
        r35 = r74;
        gr7 r036 = new gr7(1, r53, yl9.class, "rereadUnknownAmsFilament", "rereadUnknownAmsFilament(Lcom/bambulab/bambulab/common/device/component/prepareprint/model/BblAmsSlot;)V", 0, ek.k);
        r1 = r53;
        r8.E(r036);
        r25 = r036;
        goto L68
    L58:
        if (r8.J(r1) == true) goto L61;
        r016 = false;
    L51:
        String r137 = r73.getLocales().get(0).getLanguage();
        r8.E(r137);
        r132 = r137;
        goto L52
    L179:
        r515 = r8;
        r515.m();
        goto L180
    L45:
        r72 = false;
        goto L47
    L41:
        r7 = CommonNetImpl.FLAG_AUTH;
        goto L42
    L37:
        r6 = CommonNetImpl.FLAG_SHARE_JUMP;
        goto L38
    L33:
        r5 = 4194304;
        goto L34
    L29:
        r4 = CommonNetImpl.MAX_SEND_SIZE_IN_KB;
        goto L30
    L25:
        r3 = 65536;
        goto L26
    L21:
        r24 = 8192;
        goto L22
    L17:
        r23 = 1024;
        goto L18
    L13:
        r22 = 128;
        goto L14
    L9:
        r2 = 16;
        goto L10
    L5:
        r0 = 2;
        goto L6
    }

    public static final void e(wl9 r18, yl9 r19, rig r20, nod r21, int r22, nod r23, int r24, nod r25, nod r26, boolean r27, Function1 r28, nod r29, fgq r30, o07 r31, int r32) {
        grd r14 = r31.z(-1460405684);
        char r1 = 2;
        if (r14.q(r18) == false) goto L5;
        int r0 = 4;
    L6:
        int r02 = r32 | r0;
        char r5 = 16;
        if (r14.J(r19) == false) goto L9;
        int r4 = 32;
    L10:
        int r03 = r02 | r4;
        char r7 = 128;
        if (r14.q(r20) == false) goto L13;
        int r42 = 256;
    L14:
        int r04 = r03 | r42;
        if (r14.J(r21) == false) goto L17;
        int r43 = 2048;
    L18:
        int r05 = r04 | r43;
        if (r14.u(r22) == false) goto L21;
        int r44 = 16384;
    L22:
        int r06 = r05 | r44;
        if (r14.u(r24) == false) goto L25;
        int r45 = 1048576;
    L26:
        int r07 = r06 | r45;
        if (r14.J(r26) == false) goto L29;
        int r46 = AudioRoutingController.DEVICE_OUT_USB_HEADSET;
    L30:
        int r08 = r07 | r46;
        if (r14.s(r27) == false) goto L33;
        int r16 = CommonNetImpl.FLAG_SHARE;
    L34:
        int r09 = r08 | r16;
        if (r14.J(r28) == false) goto L38;
        r1 = 4;
    L38:
        if (r14.J(r29) == false) goto L40;
        r5 = ' ';
    L40:
        int r12 = r1 | r5;
        if (r14.q(r30) == false) goto L43;
        r7 = 256;
    L43:
        int r13 = r12 | r7;
        boolean r162 = false;
        if ((306783379 & r09) == 306783378) goto L46;
    L49:
        boolean r15 = true;
    L51:
        if (r14.D(r09 & 1, r15) == false) goto L65;
        p9b r17 = o3m.a;
        if ((r09 & 112) != 32) goto L55;
    L56:
        r162 = true;
    L57:
        Object r010 = r14.I();
        if (r162 == false) goto L60;
    L63:
        p9b r8 = r17;
        r010 = new gr7(1, r19, yl9.class, "onModuleImpression", "onModuleImpression(Ljava/lang/String;)V", 0, ek.l);
        r14.E(r010);
    L64:
        z86.a(r8.a((v1g) r010), mi6.v(137293196, new yj9(r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30), r14), r14, 56);
    L66:
        evn r152 = r14.Z();
        if (r152 == null) goto L70;
        r152.d = new yj9(r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r32);
        return;
    L70:
        return;
    L60:
        if (r010 == n07.a) goto L63;
        r8 = r17;
        goto L64
    L55:
        if (r14.J(r19) == false) goto L57;
    L65:
        r14.m();
        goto L66
    L46:
        if ((r13 & 147) != 146) goto L49;
        r15 = false;
        goto L51
    L33:
        r16 = CommonNetImpl.FLAG_AUTH;
        goto L34
    L29:
        r46 = CommonNetImpl.FLAG_SHARE_JUMP;
        goto L30
    L25:
        r45 = CommonNetImpl.MAX_SEND_SIZE_IN_KB;
        goto L26
    L21:
        r44 = 8192;
        goto L22
    L17:
        r43 = 1024;
        goto L18
    L13:
        r42 = 128;
        goto L14
    L9:
        r4 = 16;
        goto L10
    L5:
        r0 = 2;
        goto L6
    }

    public static final void f(final wl9 r33, final yl9 r34, final rig r35, nod r36, bj9 r37, final nod r38, final boolean r39, final Function1 r40, final nod r41, final fgq r42, o07 r43, int r44) {
        grd r2 = r43.z(1100759086);
        if (r2.q(r33) == false) goto L5;
        int r3 = 4;
    L6:
        int r32 = r44 | r3;
        if (r2.J(r34) == false) goto L9;
        int r7 = 32;
    L10:
        int r310 = r32 | r7;
        if (r2.q(r35) == false) goto L13;
        int r72 = 256;
    L14:
        int r311 = r310 | r72;
        if (r2.J(r36) == false) goto L17;
        int r73 = 2048;
    L18:
        int r312 = r311 | r73;
        if (r2.q(r37) == false) goto L21;
        int r74 = 16384;
    L22:
        int r313 = r312 | r74;
        if (r2.J(r38) == false) goto L25;
        int r75 = 131072;
    L26:
        int r314 = r313 | r75;
        if (r2.s(r39) == false) goto L29;
        int r8 = 1048576;
    L30:
        int r315 = r314 | r8;
        if (r2.J(r40) == false) goto L33;
        int r10 = AudioRoutingController.DEVICE_OUTPUT_OUT_IP;
    L34:
        int r316 = r315 | r10;
        if (r2.J(r41) == false) goto L37;
        int r11 = AudioRoutingController.DEVICE_OUT_USB_HEADSET;
    L38:
        int r317 = r316 | r11;
        if (r2.q(r42) == false) goto L41;
        int r12 = CommonNetImpl.FLAG_SHARE;
    L42:
        int r318 = r317 | r12;
        if ((306783379 & r318) == 306783378) goto L45;
        boolean r5 = true;
    L47:
        if (r2.D(r318 & 1, r5) == false) goto L126;
        HomeAppRoute.DesignPrint r52 = r33.a;
        List r122 = r33.c();
        Integer r18 = r52.getPlateIndex();
        if (r18 != null) goto L52;
        HomeAppRoute.DesignPrint r23 = r52;
    L51:
        final List r53 = r122;
        if (r23.isPublicProfile() == false) goto L70;
    L72:
        final boolean r15 = false;
    L73:
        String r76 = r23.getSourceFrom();
        String r123 = r23.getBizKey();
        String r13 = r23.getBizType();
        if (lsf.l(r13, BizType.Course.getValue()) == false) goto L77;
    L75:
        final boolean r182 = false;
    L84:
        String r77 = r23.getBizType();
        if (BizTypeKt.courseBizKeyOf(BizType.Companion.fromValue(r77), r23.getBizKey()) == null) goto L87;
        boolean r132 = true;
    L88:
        NavBackStack r78 = (NavBackStack) r2.P(vo1.a);
        final int r14 = r37.a;
        nod r79 = r37.b;
        final int r124 = r37.c;
        final nod r125 = r37.d;
        final alj r1 = mi6.j(r34.l0, r2, 0);
        final boolean r21 = r23.isPublicProfile();
        if (r33.x0 == false) goto L92;
        List r126 = egb.a;
    L91:
        final List r25 = r126;
        if (r53.isEmpty() == true) goto L96;
        int r102 = 2;
    L97:
        int r127 = r318 >> 6;
        zo2 r16 = (zo2) r2.P(hp2.a);
        Object r54 = r2.I();
        fqu r128 = n07.a;
        if (r54 != r128) goto L100;
        r54 = idb.i(zfb.INSTANCE, r2);
        r2.E(r54);
    L100:
        lm7 r55 = (lm7) r54;
        boolean r28 = r2.q(r16) | r2.q(r55);
        byte r31 = 6;
        if (((r127 & 14) ^ 6) <= 4) goto L105;
        if (r2.q(r35) == false) goto L105;
    L106:
        boolean r17 = true;
    L108:
        boolean r19 = (r28 | r17) | r2.u(r102);
        Object r56 = r2.I();
        if (r19 == true) goto L111;
        if (r56 == r128) goto L111;
        nod r110 = r79;
        boolean r24 = false;
        Object r710 = r56;
        fqu r57 = r128;
    L114:
        final nod r711 = (nod) r710;
        boolean r82 = r33.w0;
        if ((r318 & 14) != 4) goto L117;
        boolean r129 = true;
    L119:
        if ((r318 & 7168) != 2048) goto L121;
        r24 = true;
    L121:
        boolean r319 = r129 | r24;
        Object r9 = r2.I();
        if (r319 == true) goto L124;
        if (r9 == r57) goto L124;
    L125:
        nod r242 = (nod) r9;
        FillElement r27 = b.c;
        final nod r92 = r110;
        final boolean r20 = r132;
        final HomeAppRoute.DesignPrint r133 = r23;
        gpd r0 = new ak9(r35, r21, r711, r33, r39, r34, r25, r14, r92, r53, r41, r40, r133, r1, r15, r124, r125, r182, r42, r20, r38);
        grd r1210 = r2;
        wzh.e(r82, r242, false, r27, false, null, null, null, mi6.v(62276775, r0, r1210), r1210, 100666752, AVIOCTRLDEFs.AVIOCTRL_RECORD_PLAY_NEXT);
    L127:
        evn r1211 = r1210.Z();
        if (r1211 == null) goto L135;
        r1211.d = new vh9(r33, r34, r35, r36, r37, r38, r39, r40, r41, r42, r44);
        return;
    L135:
        return;
    L124:
        r9 = new gc9(r33, r36, r31);
        r2.E(r9);
        goto L125
    L117:
        r129 = r24;
    L111:
        r110 = r79;
        r57 = r128;
        r24 = false;
        r710 = new n91(r55, r35, r102, r16, 3);
        r2.E(r710);
    L105:
        if ((r127 & 6) == 4) goto L106;
        r17 = false;
        goto L108
    L96:
        r102 = 1;
        goto L97
    L92:
        r126 = r33.p;
        goto L91
    L87:
        r132 = false;
        goto L88
    L77:
        if (lsf.l(r13, BizType.MakerLab.getValue()) == false) goto L80;
    L78:
        r182 = true;
        goto L84
    L80:
        if (lsf.l(r76, "makerLab") == true) goto L78;
        if (BizTypeKt.intBizIdFromBizKey(r123) == null) goto L75;
    L70:
        if (lsf.l(r23.getMode(), PrintHistoryModel.MODE_CLOUD_SLICE) == false) goto L72;
        r15 = true;
        goto L73
    L52:
        ArrayList r134 = new ArrayList();
        Iterator r192 = r122.iterator();
    L54:
        if (r192.hasNext() == false) goto L62;
        Object r142 = r192.next();
        Integer r22 = ((IotPlate) r142).getIndex();
        HomeAppRoute.DesignPrint r232 = r52;
        int r58 = r18.intValue();
        if (r22 == null) goto L61;
        if (r22.intValue() != r58) goto L61;
        r134.add(r142);
    L61:
        r52 = r232;
        goto L54
    L62:
        r23 = r52;
        if (r134.isEmpty() == true) goto L66;
        r122 = r134;
    L66:
        r122 = r122;
        goto L51
    L126:
        r1210 = r2;
        r1210.m();
        goto L127
    L45:
        r5 = false;
        goto L47
    L41:
        r12 = CommonNetImpl.FLAG_AUTH;
        goto L42
    L37:
        r11 = CommonNetImpl.FLAG_SHARE_JUMP;
        goto L38
    L33:
        r10 = 4194304;
        goto L34
    L29:
        r8 = CommonNetImpl.MAX_SEND_SIZE_IN_KB;
        goto L30
    L25:
        r75 = 65536;
        goto L26
    L21:
        r74 = 8192;
        goto L22
    L17:
        r73 = 1024;
        goto L18
    L13:
        r72 = 128;
        goto L14
    L9:
        r7 = 16;
        goto L10
    L5:
        r3 = 2;
        goto L6
    }

    public static final void g(final jl9 r17, final boolean r18, final yl9 r19, final nod r20, o07 r21, final int r22) {
        grd r12 = r21.z(-1713749200);
        if (r12.u(r17.ordinal()) == false) goto L5;
        int r0 = 4;
    L6:
        int r02 = r0 | r22;
        if ((r22 & 48) != 0) goto L14;
        if (r12.s(r18) == false) goto L11;
        int r6 = 32;
    L12:
        r02 = r02 | r6;
        goto L14
    L11:
        r6 = 16;
    L14:
        if ((r22 & 384) != 0) goto L21;
        if (r12.J(r19) == false) goto L18;
        int r62 = 256;
    L19:
        r02 = r02 | r62;
        goto L21
    L18:
        r62 = 128;
    L21:
        if ((r22 & 3072) == 0) goto L23;
    L27:
        byte r11 = 1;
        if ((r02 & 1171) == 1170) goto L30;
        boolean r63 = true;
    L32:
        if (r12.D(r02 & 1, r63) == false) goto L104;
        int r64 = r17.ordinal();
        if (r64 != 0) goto L36;
        nod r5 = r20;
        yl9 r4 = r19;
        boolean r3 = r18;
        jl9 r2 = r17;
        r12.r(-1940497783);
        yh9 r65 = new yh9(f5j.D(r12, R.string.defectsMayOccur), f5j.D(r12, R.string.defectsMayOccurContent), f5j.D(r12, R.string.resumePrint), f5j.D(r12, R.string.cancelPrinting));
        r12.X(false);
    L48:
        jl9 r7 = jl9.c;
        fqu r10 = n07.a;
        if (r2 != r7) goto L72;
        r12.r(-24803631);
        int r66 = r02 & 7168;
        if (r66 != 2048) goto L53;
        boolean r72 = true;
    L55:
        if ((r02 & AVIOCTRLDEFs.IOTYPE_USER_IPCAM_FORMATEXTSTORAGE_REQ) != 256) goto L57;
    L60:
        boolean r8 = true;
    L61:
        boolean r73 = r72 | r8;
        if ((r02 & 14) != 4) goto L64;
        boolean r1 = true;
    L65:
        boolean r13 = r1 | r73;
        Object r74 = r12.I();
        Object r75 = r74;
        if (r13 == true) goto L68;
        if (r74 == r10) goto L68;
    L69:
        vsu.a(r3, (nod) r75, r5, r12, ((r02 & 112) | 6) | r66);
        r12.X(false);
        evn r76 = r12.Z();
        if (r76 == null) goto L109;
        final byte r67 = 1;
        final jl9 r14 = r2;
        final boolean r23 = r3;
        final yl9 r32 = r4;
        final nod r42 = r5;
        Function2 r03 = new dk9(r14, r23, r32, r42, r22, r67);
    L40:
        r76.d = r03;
        return;
    L109:
        return;
    L68:
        xj9 r77 = new xj9(r5, r4, r2, r11);
        r12.E(r77);
        r75 = r77;
        goto L69
    L64:
        r1 = false;
        goto L65
    L57:
        if (r12.J(r4) == true) goto L60;
        r8 = false;
        goto L61
    L53:
        r72 = false;
        goto L55
    L72:
        yl9 r33 = r4;
        nod r43 = r5;
        r12.r(-24525902);
        r12.X(false);
        String r52 = r65.d;
        if (r52 != null) goto L75;
        r12.r(-24111588);
        r12.X(false);
        nod r78 = null;
    L85:
        if ((r02 & 7168) != 2048) goto L87;
        char r9 = 1;
    L88:
        int r92 = r9 | (r12.q(r65) ? 1 : 0);
        if ((r02 & AVIOCTRLDEFs.IOTYPE_USER_IPCAM_FORMATEXTSTORAGE_REQ) != 256) goto L91;
    L94:
        int r82 = 1;
    L95:
        int r83 = r82 | r92;
        if ((r02 & 14) == 4) goto L99;
        r11 = 0;
    L99:
        int r15 = r83 | r11;
        Object r84 = r12.I();
        Object r85 = r84;
        if (r15 != 0) goto L102;
        if (r84 == r10) goto L102;
    L103:
        et2.b(true, r43, r65.c, (nod) r85, r65.a, mi6.v(-703096105, new vd7(r65, ek.n), r12), r52, r78, false, false, null, null, r12, ((r02 >> 6) & 112) | 196614, 0, 3840);
    L105:
        r76 = r12.Z();
        if (r76 == null) goto L110;
        final byte r68 = 2;
        r03 = new dk9(r17, r18, r19, r20, r22, r68);
        goto L40
    L110:
        return;
    L102:
        xj9 r86 = new xj9(r43, r65, r33, r2);
        r12.E(r86);
        r85 = r86;
        goto L103
    L91:
        if (r12.J(r33) == true) goto L94;
        r82 = 0;
        goto L95
    L87:
        r9 = 0;
        goto L88
    L75:
        r12.r(-24111587);
        if ((r02 & 7168) != 2048) goto L78;
        boolean r79 = true;
    L79:
        Object r142 = r12.I();
        Object r143 = r142;
        if (r79 == true) goto L82;
        if (r142 == r10) goto L82;
    L83:
        r78 = (nod) r143;
        r12.X(false);
    L82:
        wm4 r144 = new wm4(r43, ek.k);
        r12.E(r144);
        r143 = r144;
        goto L83
    L78:
        r79 = false;
        goto L79
    L36:
        if (r64 == 3) goto L42;
        r12.r(-24900692);
        r12.X(false);
        r76 = r12.Z();
        if (r76 == null) goto L108;
        final byte r69 = 0;
        r03 = new dk9(r17, r18, r19, r20, r22, r69);
        goto L40
    L108:
        return;
    L42:
        r5 = r20;
        r4 = r19;
        r3 = r18;
        r2 = r17;
        r12.r(-1940485332);
        String r102 = f5j.D(r12, R.string.firmwareUpgrade);
        if (r3 == false) goto L45;
        int r145 = R.string.firmwareForceUpgradeDesc;
    L46:
        r65 = new yh9(r102, f5j.D(r12, r145), f5j.D(r12, R.string.upgradeNow), f5j.D(r12, R.string.cancel));
        r12.X(false);
        goto L48
    L45:
        r145 = R.string.firmwareFixUpgradeDesc2;
        goto L46
    L104:
        r12.m();
        goto L105
    L30:
        r63 = false;
        goto L32
    L23:
        if (r12.J(r20) == false) goto L25;
        int r610 = 2048;
    L26:
        r02 = r02 | r610;
        goto L27
    L25:
        r610 = 1024;
        goto L26
    L5:
        r0 = 2;
        goto L6
    }

    public static final void h(final il9 r13, final nod r14, final nod r15, final nod r16, final nod r17, o07 r18, final int r19) {
        grd r0 = r18.z(-608134942);
        if ((r19 & 6) == 0) goto L5;
        int r1 = r19;
    L14:
        if ((r19 & 48) != 0) goto L21;
        if (r0.J(r14) == false) goto L18;
        int r2 = 32;
    L19:
        r1 = r1 | r2;
        goto L21
    L18:
        r2 = 16;
    L21:
        if ((r19 & 384) != 0) goto L28;
        if (r0.J(r15) == false) goto L25;
        int r22 = 256;
    L26:
        r1 = r1 | r22;
        goto L28
    L25:
        r22 = 128;
    L28:
        if ((r19 & 3072) != 0) goto L35;
        if (r0.J(r16) == false) goto L32;
        int r23 = 2048;
    L33:
        r1 = r1 | r23;
        goto L35
    L32:
        r23 = 1024;
    L35:
        if ((r19 & 24576) != 0) goto L42;
        if (r0.J(r17) == false) goto L39;
        int r24 = 16384;
    L40:
        r1 = r1 | r24;
        goto L42
    L39:
        r24 = 8192;
    L42:
        if ((r1 & 9363) == 9362) goto L44;
        boolean r25 = true;
    L46:
        if (r0.D(r1 & 1, r25) == false) goto L73;
        if (r13 != null) goto L53;
        evn r8 = r0.Z();
        if (r8 == null) goto L77;
        final byte r7 = 0;
        Function2 r02 = new bk9(r13, r14, r15, r16, r17, r19, r7);
    L51:
        r8.d = r02;
        return;
    L77:
        return;
    L53:
        final nod r10 = r15;
        boolean r26 = r13.b;
        boolean r3 = r13.a;
        String r4 = f5j.D(r0, R.string.timelapseCancelContinuePrint);
        if (r3 == true) goto L57;
        if (r26 == true) goto L57;
        boolean r5 = true;
    L58:
        if (r3 == false) goto L60;
        String r27 = "Internal";
    L64:
        if (r5 == false) goto L68;
        r0.r(-775429619);
        upu.a(f5j.D(r0, R.string.timelapseExternalStorageNoVideoMessage), s86.E(new ec3(r4, false, "CancelTimelapseClick", r15)), r17, "MWPreparePrint", r27, r0, ((r1 >> 6) & AVIOCTRLDEFs.IOTYPE_USER_IPCAM_FORMATEXTSTORAGE_REQ) | 3072);
        r0.X(false);
        r8 = r0.Z();
        if (r8 == null) goto L78;
        final byte r72 = 1;
        r02 = new bk9(r13, r14, r10, r16, r17, r19, r72);
        goto L51
    L78:
        return;
    L68:
        nod r11 = r16;
        String r52 = r27;
        r0.r(-774919328);
        r0.X(false);
        if (r3 == false) goto L71;
        int r28 = R.string.timelapseStorageLabelInternal;
    L72:
        grd r6 = r0;
        upu.a(f5j.C(R.string.timelapseStorageInsufficientMessage, new Object[]{f5j.D(r0, r28)}, r0), s86.F(new ec3[]{new ec3(f5j.D(r0, R.string.timelapseOkStartPrint), true, "ContinueTimelapseClick", r14), new ec3(r4, false, "CancelTimelapseClick", r15), new ec3(f5j.D(r0, R.string.timelapseCleanFiles), false, "CleanFileClick", r11)}), r17, "MWPreparePrint", r52, r6, ((r1 >> 6) & AVIOCTRLDEFs.IOTYPE_USER_IPCAM_FORMATEXTSTORAGE_REQ) | 3072);
    L74:
        r8 = r6.Z();
        if (r8 == null) goto L79;
        final byte r73 = 2;
        final nod r32 = r10;
        final nod r42 = r11;
        r02 = new bk9(r13, r14, r32, r42, r17, r19, r73);
        goto L51
    L79:
        return;
    L71:
        r28 = R.string.timelapseStorageLabelExternal;
        goto L72
    L60:
        if (r26 == false) goto L62;
        r27 = "ExternalTimelapse";
        goto L64
    L62:
        r27 = "ExternalNoTimelapse";
    L57:
        r5 = false;
        goto L58
    L73:
        r6 = r0;
        r10 = r15;
        r11 = r16;
        r6.m();
        goto L74
    L44:
        r25 = false;
        goto L46
    L5:
        if ((r19 & 8) != 0) goto L7;
        boolean r12 = r0.q(r13);
    L8:
        if (r12 == false) goto L10;
        int r110 = 4;
    L11:
        r1 = r110 | r19;
        goto L14
    L10:
        r110 = 2;
        goto L11
    L7:
        r12 = r0.J(r13);
        goto L8
    }

    public static final void i(Map r38, String r39, long r40, long r42, o07 r44, int r45) {
        long r10 = r40;
        grd r7 = r44.z(1998649693);
        if (r7.q(r38) == false) goto L5;
        int r2 = 4;
    L6:
        int r22 = r45 | r2;
        if (r7.q(r39) == false) goto L9;
        int r3 = 32;
    L10:
        int r23 = r22 | r3;
        if (r7.v(r10) == false) goto L13;
        int r32 = 256;
    L14:
        int r24 = r23 | r32;
        if (r7.v(r42) == false) goto L17;
        int r33 = 2048;
    L18:
        int r25 = r24 | r33;
        if ((r25 & 1171) == 1170) goto L21;
        boolean r34 = true;
    L23:
        if (r7.D(r25 & 1, r34) == false) goto L77;
        LinkedHashMap r35 = new LinkedHashMap(vvh.f0(r38.size()));
        Iterator r4 = r38.entrySet().iterator();
    L26:
        if (r4.hasNext() == false) goto L38;
        Map.Entry r12 = (Map.Entry) r4.next();
        Object r13 = r12.getKey();
        String r122 = (String) r12.getValue();
        if (lsf.l(r122, "GFU00") == false) goto L30;
    L35:
        boolean r123 = true;
    L36:
        r35.put(r13, Boolean.valueOf(r123));
        goto L26
    L30:
        if (lsf.l(r122, "GFU01") == true) goto L35;
        if (lsf.l(r122, "GFU03") == true) goto L35;
        r123 = false;
        goto L36
    L38:
        if (r35.size() <= 1) goto L51;
        Collection r43 = r35.values();
        if ((r43 instanceof Collection) == true) goto L42;
    L44:
        Iterator r46 = r43.iterator();
    L46:
        if (r46.hasNext() == false) goto L50;
        if (((Boolean) r46.next()).booleanValue() == true) goto L46;
    L50:
        boolean r47 = true;
    L52:
        ub6 r124 = sb6.a(q61.c, ox.m, r7, 0);
        int r132 = Long.hashCode(r7.T);
        a4l r14 = r7.S();
        z8j r15 = z8j.b;
        a9j r8 = m07.c(r7, r15);
        e07.o0.getClass();
        r7.k();
        if (r7.S == false) goto L55;
        r7.K(LayoutNode.T);
    L56:
        txr.k(r7, r124, l6j.g);
        txr.k(r7, r14, l6j.f);
        txr.k(r7, Integer.valueOf(r132), l6j.h);
        txr.i(r7);
        txr.k(r7, r8, l6j.e);
        z8j r72 = r15;
        onr.b(f5j.D(r7, R.string.howToFeedTPUFilament), null, 0, null, 0, null, null, 0, null, null, 0, 0, false, 0, 0, null, bns.c(16, ho1.a, new a96(r10), ReactExoplayerView.DEFAULT_MIN_BUFFER_MEMORY_RESERVE, null, 24), r7, 0, 0, 131070);
        grd r82 = r7;
        e0j.a(r82, b.g(r72, 10.0f));
        if (r47 == false) goto L60;
        r82.r(1812258161);
        j(f5j.D(r82, R.string.howToFeedTPUFilamentUsingTopFeedRack), r42, gru.d(r39, true, true), null, 0, r82, (r25 >> 6) & 112, 24);
        r82.X(false);
        boolean r133 = true;
    L76:
        r82.X(r133);
    L78:
        evn r83 = r82.Z();
        if (r83 == null) goto L90;
        r83.d = new ek9(r38, r39, r40, r42, r45);
        return;
    L90:
        return;
    L60:
        if (r35.size() > 1) goto L62;
        r82.r(1812717054);
        r133 = true;
        m(lsf.l(r86.j0(r35.values()), Boolean.TRUE), r39, r42, null, 0, r82, ((r25 >> 3) & AVIOCTRLDEFs.IOTYPE_USER_IPCAM_FORMATEXTSTORAGE_REQ) | (r25 & 112), 24);
        r82 = r82;
        r82.X(false);
        goto L76
    L62:
        r133 = true;
        r82.r(1813032851);
        Iterator r142 = r86.I0(r35.entrySet(), new mf6(12)).iterator();
        int r0 = 0;
    L64:
        if (r142.hasNext() == false) goto L75;
        Object r1 = r142.next();
        int r152 = r0 + 1;
        if (r0 < 0) goto L73;
        Map.Entry r16 = (Map.Entry) r1;
        if (r0 <= 0) goto L71;
        ul7.C(24.0f, 1969900058, r82, r82, r72);
    L70:
        r82.X(false);
        long r5 = r10;
        z8j r11 = r72;
        grd r73 = r82;
        m(((Boolean) r16.getValue()).booleanValue(), r39, r42, (oi2) r16.getKey(), r5, r73, ((r25 & 112) | ((r25 >> 3) & AVIOCTRLDEFs.IOTYPE_USER_IPCAM_FORMATEXTSTORAGE_REQ)) | (57344 & (r25 << 6)), 0);
        r82 = r73;
        r25 = r25;
        r72 = r11;
        r0 = r152;
        r10 = r40;
        goto L64
    L71:
        r82.r(937399057);
        goto L70
    L73:
        s86.M();
        throw null;
    L75:
        r82.X(false);
        goto L76
    L55:
        r7.h();
        goto L56
    L42:
        if (r43.isEmpty() == false) goto L44;
    L51:
        r47 = false;
        goto L52
    L77:
        r82 = r7;
        r82.m();
        goto L78
    L21:
        r34 = false;
        goto L23
    L17:
        r33 = 1024;
        goto L18
    L13:
        r32 = 128;
        goto L14
    L9:
        r3 = 16;
        goto L10
    L5:
        r2 = 2;
        goto L6
    }

    public static final void j(final String r38, final long r39, final int r41, String r42, long r43, o07 r45, final int r46, final int r47) {
        grd r0 = r45.z(-1614110211);
        if ((r46 & 6) == 0) goto L5;
        int r5 = r46;
    L11:
        if ((r46 & 48) != 0) goto L18;
        if (r0.v(r39) == false) goto L15;
        int r6 = 32;
    L16:
        r5 = r5 | r6;
        goto L18
    L15:
        r6 = 16;
    L18:
        if ((r46 & 384) == 0) goto L20;
    L24:
        int r62 = r47 & 8;
        if (r62 == 0) goto L29;
        r5 = r5 | 3072;
    L27:
        String r7 = r42;
    L36:
        if ((r46 & 24576) == 0) goto L38;
        long r9 = r43;
    L47:
        if ((r5 & 9363) == 9362) goto L49;
        boolean r11 = true;
    L51:
        if (r0.D(r5 & 1, r11) == false) goto L77;
        r0.y0();
        if ((r46 & 1) != 0) goto L55;
    L61:
        if (r62 == 0) goto L63;
        String r63 = null;
    L65:
        if ((r47 & 16) == 0) goto L67;
        int r72 = r5 & (-57345);
        String r92 = r63;
        long r52 = r39;
    L68:
        r0.Y();
        ub6 r10 = sb6.a(q61.c, ox.m, r0, 0);
        int r112 = Long.hashCode(r0.T);
        a4l r12 = r0.S();
        z8j r15 = z8j.b;
        a9j r13 = m07.c(r0, r15);
        e07.o0.getClass();
        r0.k();
        if (r0.S == false) goto L71;
        r0.K(LayoutNode.T);
    L72:
        txr.k(r0, r10, l6j.g);
        txr.k(r0, r12, l6j.f);
        txr.k(r0, Integer.valueOf(r112), l6j.h);
        txr.i(r0);
        txr.k(r0, r13, l6j.e);
        if (r92 == null) goto L75;
        r0.r(1903170917);
        z8j r1 = r15;
        onr.b(r92, f67.H(r15, 0.0f, 0.0f, 0.0f, 10.0f, 7), 0, null, 0, null, null, 0, null, null, 0, 0, false, 0, 0, null, bns.c(14, ho1.a, new a96(r52), ReactExoplayerView.DEFAULT_MIN_BUFFER_MEMORY_RESERVE, null, 24), r0, ((r72 >> 9) & 14) | 48, 0, 131068);
        String r35 = r92;
        grd r93 = r0;
        r93.X(false);
    L76:
        grd r30 = r93;
        onr.b(r38, null, 0, null, 0, null, null, 0, null, null, npr.l(22.400000000000002d), 0, false, 0, 0, null, bns.c(14, gfd.h, new a96(r39), ReactExoplayerView.DEFAULT_MIN_BUFFER_MEMORY_RESERVE, null, 24), r30, r72 & 14, 48, 129022);
        jb6.j(gti.n(r41, r30, (r72 >> 6) & 14), null, f67.H(b.e(r1, 1.0f), 0.0f, 5.0f, 10.0f, 0.0f, 9), null, o26.e, 0.0f, null, r30, 25016, 104);
        r0 = r30;
        r0.X(true);
        final long r64 = r52;
        final String r53 = r35;
    L78:
        evn r102 = r0.Z();
        if (r102 == null) goto L82;
        r102.d = new gk9(r38, r39, r41, r53, r64, r46, r47);
        return;
    L82:
        return;
    L75:
        r35 = r92;
        r1 = r15;
        r93 = r0;
        r93.r(1903467215);
        r93.X(false);
        goto L76
    L71:
        r0.h();
        goto L72
    L67:
        r72 = r5;
        long r36 = r9;
        r92 = r63;
        r52 = r36;
        goto L68
    L63:
        r63 = r7;
        goto L65
    L55:
        if (r0.f0() == true) goto L61;
        r0.m();
        if ((r47 & 16) == 0) goto L60;
        r5 = r5 & (-57345);
    L60:
        String r362 = r7;
        r72 = r5;
        r52 = r9;
        r92 = r362;
        goto L68
    L77:
        r0.m();
        r53 = r7;
        r64 = r9;
        goto L78
    L49:
        r11 = false;
        goto L51
    L38:
        if ((r47 & 16) != 0) goto L42;
        r9 = r43;
        if (r0.v(r9) == false) goto L43;
        int r113 = 16384;
    L44:
        r5 = r5 | r113;
    L43:
        r113 = 8192;
        goto L44
    L42:
        r9 = r43;
        goto L43
    L29:
        if ((r46 & 3072) != 0) goto L27;
        r7 = r42;
        if (r0.q(r7) == false) goto L33;
        int r94 = 2048;
    L34:
        r5 = r5 | r94;
        goto L36
    L33:
        r94 = 1024;
        goto L34
    L20:
        if (r0.u(r41) == false) goto L22;
        int r65 = 256;
    L23:
        r5 = r5 | r65;
        goto L24
    L22:
        r65 = 128;
        goto L23
    L5:
        if (r0.q(r38) == false) goto L7;
        int r54 = 4;
    L8:
        r5 = r54 | r46;
        goto L11
    L7:
        r54 = 2;
        goto L8
    }

    public static final void k(Map r36, String r37, o07 r38, int r39) {
        grd r14 = r38.z(1552553352);
        if (r14.q(r36) == false) goto L5;
        int r2 = 4;
    L6:
        int r22 = r39 | r2;
        if (r14.q(r37) == false) goto L9;
        int r3 = 32;
    L10:
        int r23 = r22 | r3;
        if ((r23 & 19) == 18) goto L13;
        boolean r32 = true;
    L15:
        if (r14.D(r23 & 1, r32) == false) goto L41;
        long r33 = ((w13) r14.P(x13.c)).I;
        if (xpr.d(r14) == false) goto L19;
        long r5 = go1.m1;
    L20:
        ub6 r7 = sb6.a(q61.c, ox.m, r14, 0);
        int r11 = Long.hashCode(r14.T);
        a4l r12 = r14.S();
        z8j r13 = z8j.b;
        a9j r15 = m07.c(r14, r13);
        e07.o0.getClass();
        r14.k();
        boolean r9 = r14.S;
        ezf r10 = LayoutNode.T;
        if (r9 == false) goto L23;
        r14.K(r10);
    L24:
        d07 r92 = l6j.g;
        txr.k(r14, r7, r92);
        j11 r72 = l6j.f;
        txr.k(r14, r12, r72);
        Integer r112 = Integer.valueOf(r11);
        d07 r122 = l6j.h;
        txr.k(r14, r112, r122);
        txr.i(r14);
        j11 r113 = l6j.e;
        txr.k(r14, r15, r113);
        long r4 = r5;
        i(r36, r37, r33, r4, r14, r23 & 126);
        e0j.a(r14, b.g(r13, 30.0f));
        too r0 = soo.a(q61.a, ox.k, r14, 48);
        int r73 = Long.hashCode(r14.T);
        a4l r8 = r14.S();
        a9j r152 = m07.c(r14, r13);
        r14.k();
        if (r14.S == false) goto L27;
        r14.K(r10);
    L28:
        txr.k(r14, r0, r92);
        txr.k(r14, r8, r72);
        r77.x(r73, r14, r122, r14);
        txr.k(r14, r152, r113);
        j3f.b(gti.n(R.drawable.ic_print_error_outline, r14, 0), null, b.m(r13, 16.0f), a96.j, r14, 3512, 0);
        onr.b(kn2.h(4.0f, R.string.important, r14, r14, r13), null, 0, null, 0, null, null, 0, null, null, 0, 0, false, 0, 0, null, bns.c(14, ho1.a, new a96(r33), ReactExoplayerView.DEFAULT_MIN_BUFFER_MEMORY_RESERVE, null, 24), r14, 0, 0, 131070);
        ul7.D(r14, true, r13, 10.0f, r14);
        String r24 = f5j.D(r14, R.string.tutorialBeforeUsingTPU);
        String r34 = f5j.D(r14, R.string.tutorialBeforeUsingTPUHighlight);
        wq0 r6 = new wq0();
        if (fuq.B0(r34) == false) goto L31;
        int r74 = -1;
    L32:
        if (r74 >= 0) goto L34;
        r6.f(r24);
    L37:
        onr.c(r6.l(), null, 0, 0, null, null, 0, null, npr.l(19.599999999999998d), 0, false, 0, 0, null, null, bns.c(14, gfd.h, new a96(r4), ReactExoplayerView.DEFAULT_MIN_BUFFER_MEMORY_RESERVE, null, 24), r14, 0, 48, 260094);
        r14 = r14;
        r14.X(true);
    L42:
        evn r02 = r14.Z();
        if (r02 == null) goto L48;
        r02.d = new sq8(r36, r37, r39, ek.m);
        return;
    L48:
        return;
    L34:
        r6.f(r24.substring(0, r74));
        int r1 = r6.k(new v9q(0, 0, gfd.i, null, null, null, null, 0, null, null, null, 0, null, null, 65531));
        r6.f(r24.substring(r74, r34.length() + r74));     // Catch: Throwable -> L38
        r6.h(r1);
        r6.f(r24.substring(r34.length() + r74));
    L38:
        th = move-exception;
        r6.h(r1);
        throw th;
    L31:
        r74 = fuq.z0(r24, r34, 0, false, 6);
        goto L32
    L27:
        r14.h();
        goto L28
    L23:
        r14.h();
        goto L24
    L19:
        r5 = go1.Z0;
        goto L20
    L41:
        r14.m();
        goto L42
    L13:
        r32 = false;
        goto L15
    L9:
        r3 = 16;
        goto L10
    L5:
        r2 = 2;
        goto L6
    }

    public static final void l(Map r21, String r22, nod r23, nod r24, o07 r25, int r26) {
        grd r0 = r25.z(1701490070);
        if (r0.q(r21) == false) goto L5;
        int r3 = 4;
    L6:
        int r32 = r26 | r3;
        if (r0.q(r22) == false) goto L9;
        int r5 = 32;
    L10:
        int r33 = r32 | r5;
        if (r0.J(r24) == false) goto L13;
        int r52 = 2048;
    L14:
        int r34 = r33 | r52;
        if ((r34 & 1171) == 1170) goto L17;
        boolean r53 = true;
    L19:
        if (r0.D(r34 & 1, r53) == false) goto L25;
        w13 r35 = (w13) r0.P(x13.c);
        if (xpr.d(r0) == false) goto L23;
        float r54 = 0.8f;
    L24:
        grd r17 = r0;
        q42.h(r23, null, null, new r42(0.85f, a96.c(r54, a96.b), null, 242), new nj2(new ook(20.0f, 10.0f, 10.0f, 10.0f), f67.i(0.0f, 30.0f, 0.0f, 20.0f, 5), 28), r35.a, false, false, null, mi6.v(1220054329, new l88(r24, 26), r0), mi6.v(142851771, new uc7(r21, r22, 18), r0), r17, 805306374, 6, 454);
    L26:
        evn r7 = r17.Z();
        if (r7 == null) goto L30;
        r7.d = new ce6(r21, r22, r23, r24, r26, 23);
        return;
    L30:
        return;
    L23:
        r54 = 0.6f;
        goto L24
    L25:
        r17 = r0;
        r17.m();
        goto L26
    L17:
        r53 = false;
        goto L19
    L13:
        r52 = 1024;
        goto L14
    L9:
        r5 = 16;
        goto L10
    L5:
        r3 = 2;
        goto L6
    }

    public static final void m(final boolean r19, final String r20, final long r21, oi2 r23, long r24, o07 r26, final int r27, final int r28) {
        grd r0 = r26.z(-767955056);
        if (r0.s(r19) == false) goto L5;
        int r3 = 4;
    L6:
        int r32 = r3 | r27;
        if (r0.q(r20) == false) goto L9;
        int r5 = 32;
    L10:
        int r33 = r32 | r5;
        if ((r27 & 384) == 0) goto L13;
    L17:
        int r52 = r28 & 8;
        int r6 = -1;
        if (r52 == 0) goto L20;
        int r34 = r33 | 3072;
    L29:
        if ((r27 & 24576) != 0) goto L37;
        long r12 = r24;
        if ((r28 & 16) == 0) goto L33;
    L35:
        int r7 = 8192;
    L36:
        r34 = r34 | r7;
    L39:
        if ((r34 & 9363) == 9362) goto L41;
        boolean r72 = true;
    L43:
        if (r0.D(r34 & 1, r72) == false) goto L75;
        r0.y0();
        String r16 = null;
        if ((r27 & 1) != 0) goto L47;
    L53:
        if (r52 == 0) goto L55;
        final oi2 r53 = null;
    L57:
        if ((r28 & 16) == 0) goto L59;
        r34 = r34 & (-57345);
        r12 = r21;
    L59:
        r0.Y();
        if (r53 == null) goto L63;
        r6 = pk9.b[r53.ordinal()];
    L63:
        if (r6 == 1) goto L67;
        if (r6 == 2) goto L66;
        r0.r(1142083629);
        r0.X(false);
        String r4 = null;
    L68:
        if (r4 != null) goto L70;
        r0.r(1142121325);
        r0.X(false);
    L71:
        if (r19 == false) goto L73;
        int r42 = R.string.howToFeedTPUFilamentDesc;
    L74:
        long r14 = r12;
        String r13 = r16;
        grd r162 = r0;
        j(f5j.D(r0, r42), r21, gru.d(r20, r19, false), r13, r14, r162, ((r34 >> 3) & 112) | (r34 & 57344), 0);
        final long r62 = r14;
    L76:
        evn r10 = r162.Z();
        if (r10 == null) goto L80;
        r10.d = new hk9(r19, r20, r21, r53, r62, r27, r28);
        return;
    L80:
        return;
    L73:
        r42 = R.string.howToFeedTPUFilamentFor85ADesc;
        goto L74
    L70:
        r0.r(1142121326);
        String r63 = f5j.D(r0, R.string.nozzle).toLowerCase(Locale.ROOT);
        r63.getClass();
        r16 = w3m.o(r4, r63);
        r0.X(false);
        goto L71
    L66:
        r4 = ul7.h(r0, 729576435, R.string.left, r0, false);
        goto L68
    L67:
        r4 = ul7.h(r0, 729574132, R.string.right, r0, false);
        goto L68
    L55:
        r53 = r23;
        goto L57
    L47:
        if (r0.f0() == true) goto L53;
        r0.m();
        if ((r28 & 16) == 0) goto L52;
        r34 = r34 & (-57345);
    L52:
        r53 = r23;
        goto L59
    L75:
        r162 = r0;
        r162.m();
        r53 = r23;
        r62 = r12;
        goto L76
    L41:
        r72 = false;
        goto L43
    L33:
        if (r0.v(r12) == false) goto L35;
        r7 = 16384;
        goto L36
    L37:
        r12 = r24;
        goto L39
    L20:
        if (r23 != null) goto L22;
        int r73 = -1;
    L24:
        if (r0.u(r73) == false) goto L26;
        int r74 = 2048;
    L27:
        r34 = r33 | r74;
        goto L29
    L26:
        r74 = 1024;
        goto L27
    L22:
        r73 = r23.ordinal();
        goto L24
    L13:
        if (r0.v(r21) == false) goto L15;
        int r54 = 256;
    L16:
        r33 = r33 | r54;
        goto L17
    L15:
        r54 = 128;
        goto L16
    L9:
        r5 = 16;
        goto L10
    L5:
        r3 = 2;
        goto L6
    }

    public static final HomeAppRoute.DesignSkipObjects n(wl9 r14, IotPlate r15) {
        String r0 = null;
        if (r15 == null) goto L5;
        Integer r1 = r15.getIndex();
    L6:
        if (r15 == null) goto L8;
        List<IotPlateObjectId> r7 = r15.getObjects();
    L9:
        if (r15 == null) goto L93;
        if (r1 == null) goto L93;
        if (r7 == null) goto L93;
        int r2 = r7.size();
        PlateImage r3 = r15.getPickPicture();
        if (r3 == null) goto L16;
        String r32 = r3.getUrl();
    L18:
        if (2 > r2) goto L93;
        if (r2 >= 65) goto L93;
        if (r32 == null) goto L93;
        if (r32.length() == 0) goto L93;
        List<IotPlateObjectId> r22 = r15.getSkippedObjects();
        if (r22 == null) goto L34;
        ArrayList r33 = new ArrayList();
        Iterator<T> r23 = r22.iterator();
    L29:
        if (r23.hasNext() == false) goto L33;
        Long r4 = ((IotPlateObjectId) r23.next()).getIdentifyId();
        if (r4 == null) goto L29;
        r33.add(r4);
        goto L29
    L33:
        Set r24 = r86.V0(r33);
    L35:
        Set r34 = mgb.a;
        if (r24 != null) goto L38;
        r24 = r34;
    L38:
        String r42 = r14.a.getSkipObjects();
        if (r42 == null) goto L50;
        List r43 = fuq.Q0(r42, new char[]{','}, 6);
        ArrayList r5 = new ArrayList();
        Iterator r44 = r43.iterator();
    L42:
        if (r44.hasNext() == false) goto L49;
        String r6 = fuq.f1((String) r44.next()).toString();
        if (r6.length() > 0) goto L47;
        r6 = null;
    L47:
        if (r6 == null) goto L42;
        r5.add(r6);
        goto L42
    L49:
        Set r45 = r86.V0(r5);
    L51:
        if (r45 == null) goto L54;
        r34 = r45;
    L54:
        Set r46 = r14.q0;
        if (r46 == null) goto L63;
        Integer r52 = r15.getIndex();
        IotPlate r62 = r14.f;
        if (r62 == null) goto L59;
        Integer r63 = r62.getIndex();
    L61:
        if (lsf.l(r52, r63) == false) goto L63;
    L64:
        if (r46 != null) goto L80;
        r46 = scv.b(r15, r34);
        if (r46 != null) goto L80;
        ArrayList r47 = new ArrayList();
        Iterator<T> r35 = r7.iterator();
    L69:
        if (r35.hasNext() == false) goto L73;
        Long r53 = ((IotPlateObjectId) r35.next()).getIdentifyId();
        if (r53 == null) goto L69;
        r47.add(r53);
        goto L69
    L73:
        ArrayList r36 = new ArrayList();
        Iterator r48 = r47.iterator();
    L75:
        if (r48.hasNext() == false) goto L79;
        Object r54 = r48.next();
        if (r24.contains(Long.valueOf(((Number) r54).longValue())) == true) goto L75;
        r36.add(r54);
        goto L75
    L79:
        r46 = r86.V0(r36);
    L80:
        int r12 = r1.intValue();
        PlateImage r55 = r15.getPickPicture();
        if (r55 == null) goto L83;
        String r56 = r55.getUrl();
    L84:
        PlateImage r152 = r15.getTopPicture();
        if (r152 == null) goto L87;
        String r64 = r152.getUrl();
    L88:
        List r8 = r86.Q0(r24);
        List r9 = r86.Q0(r46);
        DeviceData r142 = r14.e;
        if (r142 == null) goto L92;
        r0 = r142.getModelName();
    L92:
        return new HomeAppRoute.DesignSkipObjects(r12, r56, r64, r7, r8, r9, r0, false, 128, null);
    L87:
        r64 = null;
        goto L88
    L83:
        r56 = null;
        goto L84
    L59:
        r63 = null;
    L63:
        r46 = null;
        goto L64
    L50:
        r45 = null;
        goto L51
    L34:
        r24 = null;
        goto L35
    L16:
        r32 = null;
    L93:
        return null;
    L8:
        r7 = null;
        goto L9
    L5:
        r1 = null;
        goto L6
    }

    public static final Object o(rig r8, int r9, tf7 r10) {
        if ((r10 instanceof qk9) == false) goto L7;
        qk9 r0 = (qk9) r10;
        int r1 = r0.f;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.f = r1 - Integer.MIN_VALUE;
    L8:
        Object r102 = r0.e;
        Object r12 = nsf.getCOROUTINE_SUSPENDED();
        int r2 = r0.f;
        Object r3 = null;
        trs r6 = trs.a;
        if (r2 == 0) goto L17;
        if (r2 == 1) goto L16;
        if (r2 != 2) goto L14;
        vhg r82 = (vhg) r0.c;
        cig r83 = (cig) r0.b;
        rig r84 = (rig) r0.a;
        gti.r(r102);
        return r6;
    L14:
        jfn.u("call to 'resume' before 'invoke' with coroutine");
        return null;
    L16:
        r9 = r0.d;
        r8 = (rig) r0.a;
        gti.r(r102);
    L20:
        cig r103 = r8.j();
        Iterator r22 = r103.g().iterator();
    L22:
        if (r22.hasNext() == false) goto L26;
        Object r5 = r22.next();
        if (((vhg) r5).getIndex() != r9) goto L22;
        r3 = r5;
    L26:
        vhg r32 = (vhg) r3;
        if (r32 == null) goto L34;
        int r23 = r103.i() - r103.h();
        int r52 = r32.l() - r23;
        if (r52 == 0) goto L34;
        r0.a = ibq.nullOutSpilledVariable(r8);
        r0.b = ibq.nullOutSpilledVariable(r103);
        r0.c = ibq.nullOutSpilledVariable(r32);
        r0.d = r9;
        r0.f = 2;
        if (r8.f(r9, r52, r0) != r12) goto L34;
    L33:
        return r12;
    L34:
        return r6;
    L17:
        gti.r(r102);
        r0.a = r8;
        r0.d = r9;
        r0.f = 1;
        klj r104 = rig.y;
        if (r8.f(r9, 0, r0) != r12) goto L20;
    L7:
        r0 = new qk9(r10);
        goto L8
    }
}
