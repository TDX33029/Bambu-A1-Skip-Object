package defpackage;

import androidx.compose.foundation.layout.FillElement;
import androidx.compose.foundation.layout.b;
import androidx.compose.runtime.f;
import androidx.compose.ui.node.LayoutNode;
import androidx.navigation3.runtime.NavBackStack;
import androidx.profileinstaller.ProfileVerifier;
import com.bambulab.bambulab.common.device.data.hms.HmsDebugSnapshot;
import com.bambulab.bambulab.model.DesignInstances;
import com.bambulab.bambulab.model.IotPlate;
import com.bambulab.bambulab.model.MessageAuditBasic;
import com.bambulab.bambulab.model.MessageCommunityComment;
import com.bambulab.bambulab.model.MessageCommunityPost;
import com.bambulab.bambulab.model.PrintHistoryModel;
import com.bambulab.bambulab.model.RateModel;
import com.bambulab.bambulab.model.User;
import com.bambulab.bambulab.navigation.route.HomeAppRoute;
import com.umeng.analytics.pro.ek;
import j$.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* loaded from: classes3.dex */
public final /* synthetic */ class to9 implements Function2 {
    public final /* synthetic */ byte a;
    public final /* synthetic */ Object b;
    public final /* synthetic */ Object c;
    public final /* synthetic */ Object d;
    public final /* synthetic */ Object e;
    public final /* synthetic */ Object f;
    public final /* synthetic */ Object g;

    public /* synthetic */ to9(Object r1, Object r2, Object r3, Object r4, Object r5, Object r6, byte r7) {
        this.a = r7;
        this.b = r1;
        this.g = r2;
        this.c = r3;
        this.e = r4;
        this.f = r5;
        this.d = r6;
    }

    public /* synthetic */ to9(Object r1, Object r2, Object r3, Object r4, Object r5, Object r6, int r7, byte r8) {
        this.a = r8;
        this.b = r1;
        this.g = r2;
        this.c = r3;
        this.e = r4;
        this.f = r5;
        this.d = r6;
    }

    public /* synthetic */ to9(ArrayList r2, Set r3, b1q r4, HomeAppRoute.DesignSkipObjects r5, fwj r6, NavBackStack r7) {
        this.a = 2;
        this.b = r2;
        this.g = r3;
        this.c = r4;
        this.e = r5;
        this.f = r6;
        this.d = r7;
    }

    public /* synthetic */ to9(qo9 r2, hp9 r3, up9 r4, io9 r5, sp9 r6, fo9 r7) {
        this.a = 1;
        this.g = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
    }

    private final Object a(Object r10, Object r11) {
        ((Integer) r11).getClass();
        w5l.a((x5l) this.b, (d9f) this.g, (k95) this.c, (Function1) this.e, (nod) this.f, (nod) this.d, (o07) r10, e0j.w(1));
        return trs.a;
    }

    private final Object b(Object r10, Object r11) {
        ((Integer) r11).getClass();
        rbm.c((LocalDate) this.b, (LocalDate) this.g, (Function2) this.c, (nod) this.e, (a9j) this.f, (nod) this.d, (o07) r10, e0j.w(1));
        return trs.a;
    }

    private final Object d(Object r13, Object r14) {
        PrintHistoryModel r1 = (PrintHistoryModel) this.b;
        nod r2 = (nod) this.g;
        nod r3 = (nod) this.c;
        nod r4 = (nod) this.e;
        nod r7 = (nod) this.f;
        Function2 r8 = (Function2) this.d;
        o07 r9 = (o07) r13;
        int r12 = ((Integer) r14).intValue();
        if ((r12 & 3) == 2) goto L5;
        boolean r132 = true;
    L7:
        if (r9.D(r12 & 1, r132) == false) goto L9;
        ucm.b(r1, r2, r3, r4, null, false, r7, r8, r9, 0, 48);
    L11:
        return trs.a;
    L9:
        r9.m();
        goto L11
    L5:
        r132 = false;
        goto L7
    }

    private final Object f(Object r11, Object r12) {
        ((Integer) r12).getClass();
        int r9 = e0j.w(196609);
        z8j r5 = z8j.b;
        vzu.b((DesignInstances) this.b, (List) this.g, (IotPlate) this.c, (gpd) this.e, r5, (rv6) this.f, (Function1) this.d, (o07) r11, r9);
        return trs.a;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object r52, Object r53) {
        byte r1 = this.a;
        fqu r7 = n07.a;
        boolean r8 = false;
        boolean r82 = false;
        boolean r83 = false;
        boolean r84 = false;
        boolean r85 = false;
        trs r12 = trs.a;
        Object r13 = this.d;
        Object r14 = this.f;
        Object r15 = this.e;
        Object r3 = this.c;
        Object r2 = this.g;
        Object r4 = this.b;
        switch(r1) {
            case 0: goto L328;
            case 1: goto L299;
            case 2: goto L287;
            case 3: goto L285;
            case 4: goto L272;
            case 5: goto L260;
            case 6: goto L258;
            case 7: goto L236;
            case 8: goto L234;
            case 9: goto L232;
            case 10: goto L230;
            case 11: goto L166;
            case 12: goto L164;
            case 13: goto L135;
            case 14: goto L87;
            case 15: goto L85;
            case 16: goto L83;
            case 17: goto L81;
            case 18: goto L79;
            case 19: goto L77;
            case 20: goto L75;
            case 21: goto L73;
            case 22: goto L71;
            case 23: goto L69;
            case 24: goto L14;
            case 25: goto L13;
            case 26: goto L11;
            case 27: goto L9;
            case 28: goto L7;
            default: goto L4;
        };
    L4:
        RateModel r25 = (RateModel) r52;
        int r26 = ((Integer) r53).intValue();
        r25.getClass();
        ikm.c((Long) r4, (RateModel) r2, (vkm) r3, (String) r15, (alj) r14, (alj) r13, r25, r26);
        return r12;
    L14:
        alj r42 = (alj) r4;
        final z5l r22 = (z5l) r2;
        nod r32 = (nod) r3;
        alj r152 = (alj) r15;
        final alj r142 = (alj) r14;
        final alj r132 = (alj) r13;
        o07 r0 = (o07) r52;
        int r16 = ((Integer) r53).intValue();
        if ((r16 & 3) == 2) goto L17;
        boolean r5 = true;
    L19:
        if (r0.D(r16 & 1, r5) == false) goto L67;
        x5l r17 = (x5l) r152.getValue();
        boolean r43 = ((Boolean) r42.getValue()).booleanValue();
        boolean r54 = r0.J(r22);
        Object r6 = r0.I();
        if (r54 == true) goto L23;
        if (r6 == r7) goto L23;
    L24:
        nod r62 = (nod) ((v1g) r6);
        boolean r55 = r0.J(r22);
        Object r9 = r0.I();
        if (r55 == true) goto L27;
        if (r9 == r7) goto L27;
    L28:
        Function1 r92 = (Function1) ((v1g) r9);
        boolean r56 = r0.J(r22);
        Object r11 = r0.I();
        if (r56 == true) goto L31;
        if (r11 == r7) goto L31;
    L32:
        nod r112 = (nod) ((v1g) r11);
        boolean r57 = r0.J(r22);
        Object r10 = r0.I();
        if (r57 == true) goto L35;
        if (r10 == r7) goto L35;
    L36:
        w5l.c(r17, r43, r62, r92, r112, (nod) ((v1g) r10), r0, 0);
        if (((Boolean) r142.getValue()).booleanValue() == false) goto L50;
        r0.r(251360012);
        boolean r18 = lsf.l(((x5l) r152.getValue()).g, Boolean.FALSE);
        boolean r44 = ((x5l) r152.getValue()).h;
        boolean r58 = r0.J(r22);
        Object r63 = r0.I();
        if (r58 == true) goto L41;
        if (r63 == r7) goto L41;
    L42:
        Function1 r182 = (Function1) ((v1g) r63);
        boolean r59 = r0.J(r22);
        Object r64 = r0.I();
        if (r59 == true) goto L45;
        if (r64 == r7) goto L45;
    L46:
        nod r20 = (nod) r64;
        Object r510 = r0.I();
        if (r510 != r7) goto L49;
        r510 = new uqj(r142, (byte) 3);
        r0.E(r510);
    L49:
        f6l.f(r18, r44, r182, r32, r20, (nod) r510, r0, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE);
        r0.o();
    L51:
        String r19 = (String) r132.getValue();
        if (r19 != null) goto L54;
        r0.r(251999355);
        r0.o();
    L68:
        return r12;
    L54:
        r0.r(251999356);
        boolean r45 = lsf.l(((x5l) r152.getValue()).g, Boolean.FALSE);
        boolean r511 = ((x5l) r152.getValue()).h;
        boolean r65 = r0.J(r22);
        Object r86 = r0.I();
        if (r65 == true) goto L57;
        if (r86 == r7) goto L57;
    L58:
        Function1 r192 = (Function1) ((v1g) r86);
        boolean r66 = r0.J(r22);
        Object r87 = r0.I();
        if (r66 == true) goto L61;
        if (r87 == r7) goto L61;
    L62:
        nod r21 = (nod) r87;
        boolean r67 = r0.J(r22);
        Object r88 = r0.I();
        if (r67 == true) goto L65;
        if (r88 == r7) goto L65;
    L66:
        f6l.d(r19, r45, r511, r192, r32, r21, (nod) r88, r0, 0);
        r0.o();
    L65:
        final byte r68 = 2;
        r88 = new r5l(r22, r132, r68);
        r0.E(r88);
    L61:
        final byte r69 = 1;
        r87 = new r5l(r22, r132, r69);
        r0.E(r87);
    L57:
        r86 = new jkk(1, r22, z5l.class, "onAgreeImprovementChange", "onAgreeImprovementChange(Z)V", 0, 4);
        r0.E(r86);
    L45:
        final byte r89 = false ? 1 : 0;
        r64 = new r5l(r22, r142, r89);
        r0.E(r64);
    L41:
        r63 = new jkk(1, r22, z5l.class, "onAgreeImprovementChange", "onAgreeImprovementChange(Z)V", 0, 3);
        r0.E(r63);
        goto L42
    L50:
        r0.r(251953910);
        r0.o();
    L35:
        r10 = new opj(0, r22, z5l.class, "onConfirm", "onConfirm()V", 0, ek.m);
        r0.E(r10);
    L31:
        r11 = new opj(0, r22, z5l.class, "onRetake", "onRetake()V", 0, ek.l);
        r0.E(r11);
    L27:
        r9 = new jkk(1, r22, z5l.class, "onImageCaptured", "onImageCaptured(Ljava/lang/String;)V", 0, 2);
        r0.E(r9);
    L23:
        r6 = new opj(0, r22, z5l.class, "onClose", "onClose()V", 0, ek.k);
        r0.E(r6);
        goto L24
    L67:
        r0.m();
        goto L68
    L17:
        r5 = false;
        goto L19
    L69:
        ((Integer) r53).getClass();
        o1l.a((yre) r4, (a9j) r2, (mok) r3, (ipd) r15, (ipd) r14, (gpd) r13, (o07) r52, e0j.w(49));
        return r12;
    L71:
        ((Integer) r53).getClass();
        o1l.d((j9t) r4, (a9j) r2, (mok) r3, (ipd) r15, (ipd) r14, (gpd) r13, (o07) r52, e0j.w(49));
        return r12;
    L73:
        ((Integer) r53).getClass();
        x3j.b((u4j) r4, (d3j) r2, (fgq) r3, (Map) r15, (Function1) r14, (a9j) r13, (o07) r52, e0j.w(1));
        return r12;
    L75:
        ((Integer) r53).getClass();
        sqi.u((String) r4, (List) r2, (List) r3, (List) r15, (Function1) r14, (Function2) r13, (o07) r52, e0j.w(1));
        return r12;
    L77:
        ((Integer) r53).getClass();
        ooi.c((String) r4, (String) r2, (String) r3, (a9j) r15, (String) r14, (nod) r13, (o07) r52, e0j.w(1));
        return r12;
    L79:
        ((Integer) r53).getClass();
        wni.f((MessageAuditBasic) r4, (String) r2, (String) r3, (nod) r15, (Function1) r14, (Function2) r13, (o07) r52, e0j.w(1));
        return r12;
    L81:
        ((Integer) r53).getClass();
        mli.c((MessageCommunityComment) r4, (MessageCommunityPost) r2, (List) r3, (nod) r15, (gd2) r14, (a9j) r13, (o07) r52, e0j.w(1));
        return r12;
    L83:
        ((Integer) r53).getClass();
        vte.u((List) r4, (xhe) r2, (fte) r3, (nod) r15, (nod) r14, (a9j) r13, (o07) r52, e0j.w(1));
        return r12;
    L85:
        ((Integer) r53).getClass();
        tme.i((User) r4, (Long) r2, (nod) r3, (Function1) r15, (Function1) r14, (nod) r13, (o07) r52, e0j.w(1));
        return r12;
    L87:
        mje r46 = (mje) r4;
        lle r23 = (lle) r2;
        NavBackStack r33 = (NavBackStack) r3;
        String r153 = (String) r15;
        Function1 r40 = (Function1) r14;
        a9j r452 = (a9j) r13;
        o07 r02 = (o07) r52;
        int r110 = ((Integer) r53).intValue();
        if ((r110 & 3) == 2) goto L91;
        r82 = true;
    L91:
        if (r02.D(r110 & 1, r82) == false) goto L133;
        xke r111 = r46.a;
        wig r810 = r46.b;
        wig r93 = r46.c;
        wig r102 = r46.d;
        Map r113 = r46.e;
        Map r133 = r46.f;
        Map r143 = r46.g;
        Map r47 = r46.h;
        boolean r162 = r02.J(r23);
        Object r610 = r02.I();
        if (r162 == true) goto L95;
        if (r610 == r7) goto L95;
    L96:
        Function1 r34 = (Function1) ((v1g) r610);
        boolean r611 = r02.J(r33);
        Object r512 = r02.I();
        if (r611 == true) goto L99;
        if (r512 == r7) goto L99;
    L100:
        nod r35 = (nod) r512;
        boolean r513 = r02.J(r33);
        Object r612 = r02.I();
        if (r513 == true) goto L103;
        if (r612 == r7) goto L103;
    L104:
        nod r36 = (nod) r612;
        boolean r514 = r02.J(r33);
        Object r613 = r02.I();
        if (r514 == true) goto L107;
        if (r613 == r7) goto L107;
    L108:
        Function1 r37 = (Function1) r613;
        boolean r515 = r02.J(r23);
        Object r614 = r02.I();
        if (r515 == true) goto L111;
        if (r614 == r7) goto L111;
    L112:
        Function2 r38 = (Function2) ((v1g) r614);
        boolean r516 = r02.J(r33) | r02.q(r153);
        Object r615 = r02.I();
        if (r516 == true) goto L115;
        if (r615 == r7) goto L115;
    L116:
        Function1 r39 = (Function1) r615;
        boolean r517 = r02.J(r33);
        Object r616 = r02.I();
        if (r517 == true) goto L119;
        if (r616 == r7) goto L119;
    L120:
        nod r41 = (nod) r616;
        boolean r518 = r02.J(r23) | r02.J(r33);
        Object r617 = r02.I();
        if (r518 == true) goto L123;
        if (r617 == r7) goto L123;
    L124:
        ipd r422 = (ipd) r617;
        boolean r24 = r02.J(r33) | r02.q(r153);
        Object r519 = r02.I();
        if (r24 == true) goto L127;
        if (r519 == r7) goto L127;
    L128:
        nod r432 = (nod) r519;
        boolean r27 = r02.J(r33) | r02.q(r153);
        Object r520 = r02.I();
        if (r27 == true) goto L131;
        if (r520 == r7) goto L131;
    L132:
        vke.j(r111, r810, r93, r102, r113, r133, r143, r47, r34, r35, r36, r37, r38, r39, r40, r41, r422, r432, (nod) r520, r452, r02, 0, 0, 0);
    L134:
        return r12;
    L131:
        r520 = new woa(r33, r153, 9);
        r02.E(r520);
    L127:
        r519 = new woa(r33, r153, 8);
        r02.E(r519);
    L123:
        r617 = new qke(r23, r33, null);
        r02.E(r617);
    L119:
        r616 = new gla(r33, (byte) 19);
        r02.E(r616);
    L115:
        r615 = new oc7(r33, r153, (byte) 1);
        r02.E(r615);
    L111:
        r614 = new ep9(2, r23, lle.class, "allowCommunityLike", "allowCommunityLike(ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", 0, 24);
        r02.E(r614);
    L107:
        r613 = new ge7(r33, 28);
        r02.E(r613);
    L103:
        r612 = new gla(r33, (byte) 21);
        r02.E(r612);
    L99:
        r512 = new gla(r33, (byte) 20);
        r02.E(r512);
    L95:
        r610 = new ebc(1, r23, lle.class, "onAction", "onAction(Lcom/bambulab/bambulab/feature/home/presentation/community/HomeCommunityAction;)V", 0, ek.m);
        r02.E(r610);
        goto L96
    L133:
        r02.m();
        goto L134
    L135:
        alj r48 = (alj) r4;
        alj r28 = (alj) r2;
        alj r310 = (alj) r3;
        nod r332 = (nod) r15;
        ljj r144 = (ljj) r14;
        alj r134 = (alj) r13;
        o07 r03 = (o07) r52;
        int r114 = ((Integer) r53).intValue();
        if ((r114 & 3) == 2) goto L139;
        r83 = true;
    L139:
        if (r03.D(r114 & 1, r83) == false) goto L162;
        k1e r193 = new k1e(r144.a(), ((Boolean) r134.getValue()).booleanValue(), ((Boolean) r48.getValue()).booleanValue(), ((Boolean) r28.getValue()).booleanValue(), ((Boolean) r310.getValue()).booleanValue());
        Object r115 = r03.I();
        if (r115 != r7) goto L143;
        r115 = new of(r144, (byte) 29);
        r03.E(r115);
    L143:
        Function1 r272 = (Function1) r115;
        boolean r116 = r03.q(r48);
        Object r618 = r03.I();
        if (r116 == true) goto L146;
        if (r618 == r7) goto L146;
    L147:
        Function1 r282 = (Function1) r618;
        boolean r117 = r03.q(r28);
        Object r49 = r03.I();
        if (r117 == true) goto L150;
        if (r49 == r7) goto L150;
    L151:
        Function1 r29 = (Function1) r49;
        boolean r118 = r03.q(r310);
        Object r210 = r03.I();
        if (r118 == true) goto L154;
        if (r210 == r7) goto L154;
    L155:
        Function1 r30 = (Function1) r210;
        Object r119 = r03.I();
        if (r119 != r7) goto L158;
        r119 = new bec(r134, (byte) 28);
        r03.E(r119);
    L158:
        nod r31 = (nod) r119;
        Object r120 = r03.I();
        if (r120 != r7) goto L161;
        r120 = new bec(r134, (byte) 27);
        r03.E(r120);
    L161:
        j1e.a(r193, r272, r282, r29, r30, r31, (nod) r120, r332, null, r03, 1769520);
    L163:
        return r12;
    L154:
        r210 = new coa(r310, (byte) 29);
        r03.E(r210);
    L150:
        r49 = new coa(r28, (byte) 28);
        r03.E(r49);
    L146:
        r618 = new coa(r48, (byte) 27);
        r03.E(r618);
        goto L147
    L162:
        r03.m();
        goto L163
    L164:
        ((Integer) r53).getClass();
        pic.g((xfc) r4, (Long) r2, (l7l) r3, (Function1) r15, (Function1) r14, (Function2) r13, (o07) r52, e0j.w(1));
        return r12;
    L166:
        final ucc r410 = (ucc) r4;
        nod r292 = (nod) r2;
        Function1 r302 = (Function1) r3;
        nod r312 = (nod) r15;
        Function1 r382 = (Function1) r14;
        a9j r04 = (a9j) r13;
        o07 r121 = (o07) r52;
        int r211 = ((Integer) r53).intValue();
        if ((r211 & 3) == 2) goto L170;
        boolean r311 = true;
    L172:
        if (r121.D(r211 & 1, r311) == false) goto L228;
        alj r145 = mi6.j(r410.i, r121, 0);
        Object r212 = r121.I();
        if (r212 != r7) goto L176;
        Object r273 = null;
        r212 = f.f(null);
        r121.E(r212);
    L177:
        alj r213 = (alj) r212;
        Object r313 = r121.I();
        if (r313 != r7) goto L180;
        r313 = f.f(r273);
        r121.E(r313);
    L180:
        final alj r314 = (alj) r313;
        Object r521 = r121.I();
        if (r521 != r7) goto L183;
        r521 = f.f(Boolean.FALSE);
        r121.E(r521);
    L183:
        alj r522 = (alj) r521;
        Object r619 = r121.I();
        if (r619 != r7) goto L186;
        r619 = f.f(Boolean.FALSE);
        r121.E(r619);
    L186:
        alj r620 = (alj) r619;
        Object r94 = r121.I();
        if (r94 != r7) goto L189;
        r94 = new lcd();
        r121.E(r94);
    L189:
        lcd r95 = (lcd) r94;
        Object r103 = r121.I();
        if (r103 != r7) goto L192;
        r103 = new kt4();
        r121.E(r103);
    L192:
        ht4 r104 = (ht4) r103;
        Object r1110 = r121.I();
        if (r1110 != r7) goto L195;
        r1110 = new apa(r620, (byte) 24);
        r121.E(r1110);
    L195:
        nod r322 = (nod) r1110;
        Object r1111 = r121.I();
        if (r1111 != r7) goto L198;
        r1111 = new coa(r213, ek.m);
        r121.E(r1111);
    L198:
        Function1 r333 = (Function1) r1111;
        Object r1112 = r121.I();
        if (r1112 != r7) goto L201;
        r1112 = new coa(r314, ek.n);
        r121.E(r1112);
    L201:
        Function1 r342 = (Function1) r1112;
        Object r1113 = r121.I();
        if (r1113 != r7) goto L204;
        r1113 = new apa(r522, (byte) 25);
        r121.E(r1113);
    L204:
        zbc.o(r410, new ibc(r292, r302, r312, r322, r333, r342, (nod) r1113), r95, r104, r121, 392);
        if (((ncc) r145.getValue()).b == false) goto L208;
        String r411 = "DevicePageAMSInternalInfo";
    L209:
        lsf.c(r411, null, r121, 0, 2);
        e40 r323 = (e40) r213.getValue();
        gt5 r334 = (gt5) r314.getValue();
        boolean r343 = ((Boolean) r522.getValue()).booleanValue();
        Object r412 = r121.I();
        if (r412 != r7) goto L212;
        r412 = new apa(r213, (byte) 26);
        r121.E(r412);
    L212:
        nod r352 = (nod) r412;
        boolean r214 = r121.J(r410);
        Object r413 = r121.I();
        if (r214 == true) goto L215;
        if (r413 == r7) goto L215;
    L216:
        nod r362 = (nod) r413;
        boolean r215 = r121.J(r410);
        Object r414 = r121.I();
        if (r215 == true) goto L219;
        if (r414 == r7) goto L219;
    L220:
        nod r372 = (nod) r414;
        Object r216 = r121.I();
        if (r216 != r7) goto L223;
        r216 = new apa(r522, (byte) 27);
        r121.E(r216);
    L223:
        zbc.d(r323, r334, r343, r352, r362, r372, r382, (nod) r216, r121, 12585984);
        boolean r217 = r121.J(r410);
        Object r315 = r121.I();
        if (r217 == true) goto L226;
        if (r315 == r7) goto L226;
    L227:
        hp2.a(r04, new xo2(f67.h(2, 16.0f, 0.0f), 12.0f, 0, 1, null, (nod) ((v1g) r315), 44), false, mi6.v(1871517311, new hg(r145, r410, r292, r95, r104, r620), r121), r121, 3072, 4);
    L229:
        return r12;
    L226:
        r315 = new o3c(0, r410, ucc.class, "dismissNameGuide", "dismissNameGuide()V", 0, 10);
        r121.E(r315);
    L219:
        final byte r218 = 1;
        r414 = new ybc(r410, r314, r218);
        r121.E(r414);
    L215:
        final byte r811 = false ? 1 : 0;
        r413 = new ybc(r410, r314, r811);
        r121.E(r413);
        goto L216
    L208:
        r411 = "DevicePageAMSInternalEdit";
        goto L209
    L176:
        r273 = null;
        goto L177
    L228:
        r121.m();
        goto L229
    L170:
        r311 = false;
        goto L172
    L230:
        ((Integer) r53).getClass();
        fbc.h((bac) r4, (List) r2, (List) r3, (ebc) r15, (a9j) r14, (List) r13, (o07) r52, e0j.w(1));
        return r12;
    L232:
        ((Integer) r53).getClass();
        k5c.h((d6c) r4, (nod) r2, (nod) r3, (nod) r15, (nod) r14, (a9j) r13, (o07) r52, e0j.w(1));
        return r12;
    L234:
        ((Integer) r53).getClass();
        rzb.a((yzb) r4, (prk) r2, (nod) r3, (Function1) r15, (v0c) r14, (lte) r13, (o07) r52, e0j.w(32769));
        return r12;
    L236:
        hcb r415 = (hcb) r4;
        mcb r219 = (mcb) r2;
        lcd r416 = (lcd) r3;
        ht4 r423 = (ht4) r15;
        String r146 = (String) r14;
        String r135 = (String) r13;
        o07 r05 = (o07) r52;
        int r122 = ((Integer) r53).intValue();
        byte r621 = 2;
        if ((r122 & 3) == 2) goto L240;
        boolean r316 = true;
    L242:
        if (r05.D(r122 & 1, r316) == false) goto L256;
        utu.a(new qp2("editFilamentName", 1), new pp2(null, mi6.v(100093653, new yh1(r146, r135, r621), r05), 1), new tp2(null, new m0b(12.0f), 5), null, mi6.v(1139104952, new tva(r415, r219, 3), r05), r05, 25014, 8);
        bbc.c(null, r05, 0, 1);
        String r123 = r415.n;
        String r317 = r415.m;
        boolean r523 = r05.J(r219);
        Object r622 = r05.I();
        if (r523 == true) goto L246;
        if (r622 == r7) goto L246;
    L247:
        Function1 r303 = (Function1) r622;
        boolean r524 = r05.J(r219);
        Object r623 = r05.I();
        if (r524 == true) goto L250;
        if (r623 == r7) goto L250;
    L251:
        Function1 r318 = (Function1) r623;
        boolean r525 = r415.w;
        boolean r624 = r05.J(r219);
        Object r812 = r05.I();
        if (r624 == true) goto L254;
        if (r812 == r7) goto L254;
    L255:
        boolean r220 = r415.b;
        hmc.d(r123, r317, r303, r318, r525, (Function1) r812, null, r220, false, r220, false, 0, !r220, r416, r423, r05, 0, 3392);
    L257:
        return r12;
    L254:
        r812 = new zbb(r219, 4);
        r05.E(r812);
    L250:
        r623 = new zbb(r219, 3);
        r05.E(r623);
    L246:
        r622 = new zbb(r219, 2);
        r05.E(r622);
        goto L247
    L256:
        r05.m();
        goto L257
    L240:
        r316 = false;
        goto L242
    L258:
        ((Integer) r53).getClass();
        f7b.a((i7b) r4, (Function1) r2, (nod) r3, (nod) r15, (nod) r14, (a9j) r13, (o07) r52, e0j.w(196609));
        return r12;
    L260:
        lm7 r417 = (lm7) r4;
        p63 r221 = (p63) r2;
        String r319 = (String) r3;
        String r154 = (String) r15;
        alj r172 = (alj) r14;
        alj r183 = (alj) r13;
        o07 r06 = (o07) r52;
        int r124 = ((Integer) r53).intValue();
        if ((r124 & 3) == 2) goto L264;
        r84 = true;
    L264:
        if (r06.D(r124 & 1, r84) == false) goto L270;
        boolean r125 = ((r06.J(r417) | r06.J(r221)) | r06.q(r319)) | r06.q(r154);
        Object r526 = r06.I();
        if (r125 == true) goto L268;
        if (r526 == r7) goto L268;
    L269:
        s86.d((nod) r526, null, false, null, null, null, gtu.a, r06, 1572864, 62);
    L271:
        return r12;
    L268:
        sn2 r136 = new sn2(r417, r221, r319, r172, r183, r154);
        r06.E(r136);
        r526 = r136;
        goto L269
    L270:
        r06.m();
        goto L271
    L272:
        HmsDebugSnapshot r418 = (HmsDebugSnapshot) r4;
        String r173 = (String) r2;
        String r184 = (String) r3;
        Function1 r194 = (Function1) r15;
        Function1 r202 = (Function1) r14;
        nod r2110 = (nod) r13;
        o07 r07 = (o07) r52;
        int r126 = ((Integer) r53).intValue();
        if ((r126 & 3) == 2) goto L276;
        r85 = true;
    L276:
        if (r07.D(r126 & 1, r85) == false) goto L283;
        if (r418 == null) goto L279;
        List<String> r625 = r418.getDevices();
    L280:
        if (r625 != null) goto L282;
        r625 = egb.a;
    L282:
        o2a.m(r625, r173, r184, r194, r202, r2110, r07, 0);
    L284:
        return r12;
    L279:
        r625 = null;
        goto L280
    L283:
        r07.m();
        goto L284
    L285:
        ((Integer) r53).getClass();
        o2a.m((List) r4, (String) r2, (String) r3, (Function1) r15, (Function1) r14, (nod) r13, (o07) r52, e0j.w(1));
        return r12;
    L287:
        ArrayList r419 = (ArrayList) r4;
        Set r163 = (Set) r2;
        b1q r174 = (b1q) r3;
        HomeAppRoute.DesignSkipObjects r155 = (HomeAppRoute.DesignSkipObjects) r15;
        fwj r147 = (fwj) r14;
        NavBackStack r08 = (NavBackStack) r13;
        o07 r127 = (o07) r52;
        int r222 = ((Integer) r53).intValue();
        if ((r222 & 3) == 2) goto L291;
        r8 = true;
    L291:
        if (r127.D(r222 & 1, r8) == false) goto L297;
        FillElement r223 = b.c;
        String r185 = r155.getDeviceModelName();
        boolean r320 = (r127.J(r147) | r127.J(r155)) | r127.J(r08);
        Object r527 = r127.I();
        if (r320 == true) goto L295;
        if (r527 == r7) goto L295;
    L296:
        yz2.c(new a03(c53.b, r419, r163, r174, r185, (Function1) r527), r223, mi6.v(-902423680, new kh(r08, ek.l), r127), r127, 392, 0);
    L298:
        return r12;
    L295:
        r527 = new qa7(r147, r155, r08, 17);
        r127.E(r527);
        goto L296
    L297:
        r127.m();
        goto L298
    L299:
        qo9 r09 = (qo9) r2;
        hp9 r420 = (hp9) r4;
        up9 r195 = (up9) r3;
        io9 r137 = (io9) r13;
        sp9 r203 = (sp9) r15;
        fo9 r148 = (fo9) r14;
        o07 r72 = (o07) r52;
        int r128 = ((Integer) r53).intValue();
        if ((r128 & 3) == 2) goto L303;
        boolean r224 = true;
    L305:
        if (r72.D(r128 & 1, r224) == false) goto L326;
        ub6 r129 = sb6.a(new m61(16.0f, true, new vc0()), ox.m, r72, 6);
        int r225 = Long.hashCode(r72.e());
        a4l r321 = r72.g();
        a9j r528 = m07.c(r72, z8j.b);
        e07.o0.getClass();
        if (r72.A() == null) goto L324;
        r72.k();
        if (r72.y() == false) goto L311;
        r72.K(LayoutNode.T);
    L312:
        txr.k(r72, r129, l6j.g);
        txr.k(r72, r321, l6j.f);
        txr.k(r72, Integer.valueOf(r225), l6j.h);
        txr.i(r72);
        txr.k(r72, r528, l6j.e);
        int r130 = r09.ordinal();
        if (r130 != 0) goto L315;
        r72.r(675891222);
        fp9.w(r09, so9.a, r420.c.a, r195, r137, r420.i, r420.f, r72, 48);
        r72.o();
    L323:
        r72.i();
    L327:
        return r12;
    L315:
        if (r130 != 1) goto L317;
        r72.r(675906918);
        fp9.r(r420, r195, r203, r137, r72, 0);
        r72.o();
        goto L323
    L317:
        if (r130 != 2) goto L320;
        r72.r(675917033);
        fp9.b(r420, r148, r137, r72, 0);
        r72.o();
        goto L323
    L320:
        throw dgh.c(r72, 675889178);
    L311:
        r72.h();
        goto L312
    L324:
        zm6.q();
        throw null;
    L326:
        r72.m();
        goto L327
    L303:
        r224 = false;
        goto L305
    L328:
        ((Integer) r53).getClass();
        fp9.j((hp9) r4, (ho9) r2, (up9) r3, (sp9) r15, (fo9) r14, (io9) r13, (o07) r52, e0j.w(1));
        return r12;
    L7:
        return f(r52, r53);
    L9:
        return d(r52, r53);
    L11:
        return b(r52, r53);
    L13:
        return a(r52, r53);
    }
}
