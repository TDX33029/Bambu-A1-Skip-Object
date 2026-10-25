package defpackage;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import com.bambulab.printer.model.generated.BblpPrintState;
import com.brentvatne.exoplayer.ReactExoplayerView;
import com.umeng.analytics.pro.ek;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes4.dex */
public abstract class b1v {
    public static final rv6 a = null;
    public static final rv6 b = null;
    public static final rv6 c = null;

    static {
        a = new rv6(new hy6(12), false, 521090071);
        b = new rv6(new hy6(ek.n), false, 133035962);
        c = new rv6(new hy6(17), false, 511588468);
        new rv6(new hy6(18), false, 1713995571);
        new rv6(new hy6(ek.l), false, 1475735403);
    }

    public static final int a(int r2) {
        int r0 = (r2 >> 16) & 255;
        int r1 = (r2 >> 8) & 255;
        int r22 = (r2 & 255) << 16;
        return r22 | (r0 | (r1 << 8));
    }

    public static final s9s b(long r9, long r11, ca7 r13, m44 r14, boolean r15) {
        if (fav.c(r9) == false) goto L5;
    L9:
        s9s r92 = s9s.f;
        return s9s.f;
    L5:
        if (fav.c(r11) == true) goto L9;
        return (s9s) ((j9r) new fv1(r9, r11, r13, r14, !r15).n).getValue();
    }

    public static final fwn c(long r9, long r11, ca7 r13, rx r14, boolean r15) {
        r13.getClass();
        r14.getClass();
        if (fav.c(r9) == true) goto L10;
        if (fav.c(r11) == true) goto L10;
        return (fwn) ((j9r) new fv1(r9, r11, r13, r14, !r15).m).getValue();
    L10:
        return fwn.e;
    }

    public static final fwn d(long r15, long r17, ca7 r19, m44 r20, boolean r21, float r22, long r23) {
        if (fav.c(r15) == true) goto L20;
        if (fav.c(r17) == true) goto L20;
        long r0 = isu.b(pak.b(r23) * (-1.0f), pak.c(r23) * (-1.0f));
        long r2 = fav.j(r15);
        float r4 = pak.b(r0);
        float r5 = pak.c(r0);
        float r6 = pak.b(r0);
        float r7 = h0q.b(r2) + r6;
        float r02 = pak.c(r0);
        float r42 = r4 / r22;
        float r52 = r5 / r22;
        float r72 = r7 / r22;
        float r1 = (h0q.a(r2) + r02) / r22;
        long r10 = fav.h(0, r17);
        fwn r03 = c(r15, r10, r19, r20, r21);
        r03.getClass();
        float r62 = r03.a;
        if (r72 <= r62) goto L20;
        float r8 = r03.c;
        if (r8 <= r42) goto L20;
        float r9 = r03.b;
        if (r1 <= r9) goto L20;
        float r04 = r03.d;
        if (r04 <= r52) goto L20;
        fwn r05 = k8v.c(new fwn(r42 - r62, r52 - r9, r72 - r62, r1 - r9), fdv.c(r8 - r62, r04 - r9));
        long r43 = r19.a(fav.j(r10), fav.j(r15));
        fwn r12 = new fwn(r05.a / jxo.b(r43), r05.b / jxo.c(r43), r05.c / jxo.b(r43), r05.d / jxo.c(r43));
        fav.j(r17);
        return k8v.c(r12, fav.j(r17));
    L20:
        return fwn.e;
    }

    public static final long e(float r14, float r15, long r16, long r18, long r20) {
        long r3 = pak.e(pak.f(-1.0f, pak.a(r14, r16)), pak.a(r14, r18));
        long r0 = pak.f(-1.0f, pak.f(r15, pak.d(isu.b((float) ((Math.cos(ReactExoplayerView.DEFAULT_MIN_BUFFER_MEMORY_RESERVE) * pak.b(r3)) - (Math.sin(ReactExoplayerView.DEFAULT_MIN_BUFFER_MEMORY_RESERVE) * pak.c(r3))), (float) ((Math.cos(ReactExoplayerView.DEFAULT_MIN_BUFFER_MEMORY_RESERVE) * pak.c(r3)) + (Math.sin(ReactExoplayerView.DEFAULT_MIN_BUFFER_MEMORY_RESERVE) * pak.b(r3)))), pak.e(pak.a(r15, r18), pak.a(r14, r20)))));
        AtomicReference r142 = ol7.a;
        if (pak.b(r0) == (-0.0f)) goto L8;
        if (pak.c(r0) == (-0.0f)) goto L8;
        return r0;
    L8:
        return isu.b(ol7.b(pak.b(r0)), ol7.b(pak.c(r0)));
    }

    public static final fwn f(long r7, long r9, ca7 r11, m44 r12, boolean r13, float r14, q87 r15) {
        if (fav.c(r7) == true) goto L55;
        if (fav.c(r9) == true) goto L55;
        rx r5 = lev.i(r12, Boolean.valueOf(r13));
        fwn r72 = c(r7, fav.h(0, r9), r11, r5, false);
        int r8 = jof.c;
        int r82 = (int) (r7 >> 32);
        int r92 = (int) (4294967295L & r7);
        r72.getClass();
        float r10 = r72.a * r14;
        float r112 = r72.b * r14;
        float r122 = r72.c * r14;
        float r73 = r72.d * r14;
        float r132 = r122 - r10;
        float r142 = r73 - r112;
        float r2 = 0.0f;
        if (wzh.D(r132) < r82) goto L14;
        float r123 = (r122 - r82) * (-1.0f);
        float r102 = r10 * (-1.0f);
        if (r123 <= r102) goto L12;
        r123 = r102;
    L12:
        d36 r152 = new d36(r123, r102);
    L21:
        if (wzh.D(r142) < r92) goto L27;
        float r74 = (r73 - r92) * (-1.0f);
        float r113 = r112 * (-1.0f);
        if (r74 <= r113) goto L25;
        r74 = r113;
    L25:
        d36 r103 = new d36(r74, r113);
    L33:
        float r75 = ol7.b(r152.a);
        float r114 = ol7.b(r103.a);
        float r124 = ol7.b(r152.b);
        float r104 = ol7.b(r103.b);
        float r83 = r82 - r132;
        if (r83 >= 0.0f) goto L36;
        r83 = 0.0f;
    L36:
        float r84 = r83 / 2.0f;
        float r93 = r92 - r142;
        if (r93 >= 0.0f) goto L39;
        r93 = 0.0f;
    L39:
        float r94 = r93 / 2.0f;
        float r85 = 0.0f - r84;
        if (r85 >= 0.0f) goto L42;
        float r143 = 0.0f;
    L43:
        float r95 = 0.0f - r94;
        if (r95 >= 0.0f) goto L46;
        float r0 = 0.0f;
    L47:
        if (r85 >= 0.0f) goto L49;
        r85 = 0.0f;
    L49:
        if (r95 < 0.0f) goto L53;
        r2 = r95;
    L53:
        return new fwn(ol7.b(r75 - r143), ol7.b(r114 - r0), ol7.b(r124 + r85), ol7.b(r104 + r2));
    L46:
        r0 = r95;
        goto L47
    L42:
        r143 = r85;
        goto L43
    L27:
        if (lev.h(r5) == false) goto L30;
        r103 = new d36(0.0f, 0.0f);
        goto L33
    L30:
        if (lev.e(r5) == false) goto L32;
        float r76 = (r73 - r92) * (-1.0f);
        r103 = new d36(r76, r76);
        goto L33
    L32:
        float r115 = (r112 - ((r92 - r142) / 2.0f)) * (-1.0f);
        r103 = new d36(r115, r115);
        goto L33
    L14:
        if (lev.g(r5) == false) goto L17;
        r152 = new d36(0.0f, 0.0f);
        goto L21
    L17:
        if (lev.f(r5) == false) goto L19;
        float r125 = (r122 - r82) * (-1.0f);
        r152 = new d36(r125, r125);
        goto L21
    L19:
        float r105 = (r10 - ((r82 - r132) / 2.0f)) * (-1.0f);
        r152 = new d36(r105, r105);
    L55:
        return fwn.e;
    }

    public static final long g(long r12, long r14, ca7 r16, rx r17, boolean r18, int r19, float r20, long r21, long r23) {
        r16.getClass();
        r17.getClass();
        if (fav.c(r12) == true) goto L28;
        if (fav.c(r14) == true) goto L28;
        int r1 = r19 % 90;
        if (r1 == 0) goto L10;
        vc0.k("rotation must be multiple of 90");
        return 0;
    L10:
        if (fav.c(r12) == false) goto L12;
    L18:
        long r0 = pak.b;
    L20:
        if (fav.c(r12) == false) goto L24;
        return pak.b;
    L24:
        return pak.e(pak.f(r20, r0), r21);
    L12:
        if (fav.c(r14) == true) goto L18;
        if (r1 != 0) goto L16;
        long r7 = fav.h(r19, r14);
        long r02 = isu.e(isu.d(r19, r23, fav.j(r14)), r16.a(fav.j(r7), fav.j(r12)));
        fwn r2 = c(r12, r7, r16, r17, r18);
        r0 = pak.e(r02, isu.b(r2.a, r2.b));
        goto L20
    L16:
        vc0.k("rotation must be multiple of 90");
        return 0;
    L28:
        return pak.b;
    }

    public static final boolean h(int r0, int r1) {
        if (r0 != r1) goto L5;
        return true;
    L5:
        return false;
    }

    public static final int i(int r3) {
        int r0 = r3 & 255;
        int r1 = (r3 >> 8) & 255;
        return ((r3 >> 16) & 255) | (((r0 << 16) | (-16777216)) | (r1 << 8));
    }

    public static final omm j(BblpPrintState r47, Integer r48, Integer r49, boolean r50, boolean r51, String r52, List r53, boolean r54) {
        r47.getClass();
        if (r47 != BblpPrintState.PREPARE) goto L5;
    L8:
        boolean r0 = true;
    L9:
        int r1 = r48.intValue();
        Integer r3 = null;
        if (r1 >= 0) goto L12;
    L14:
        Integer r12 = null;
    L15:
        int r4 = -1;
        if (r12 == null) goto L18;
        int r13 = r12.intValue();
    L19:
        if (r0 == true) goto L27;
        if (r49 == null) goto L27;
        if (r49.intValue() < 0) goto L25;
        r3 = r49;
    L25:
        if (r3 == null) goto L27;
        r4 = r3.intValue();
    L27:
        gnm r28 = gnm.d;
        egb r15 = egb.a;
        return new omm(r52, r47, r13, r4, null, null, null, null, null, null, null, null, null, 0, r15, null, null, null, null, null, r54, null, null, null, null, null, null, r28, pmm.b, true, null, null, r50, r51, r15, r53, null, r15, r15, null, null, null, r15, null, null, r15);
    L18:
        r13 = -1;
        goto L19
    L12:
        if (r1 >= 101) goto L14;
        r12 = r48;
        goto L15
    L5:
        if (r47 == BblpPrintState.SLICING) goto L8;
        r0 = false;
        goto L9
    }

    public static int k(int r1, Context r2) {
        TypedArray r12 = r2.obtainStyledAttributes(R.style.Animation.Activity, new int[]{r1});
        int r22 = r12.getResourceId(0, -1);
        r12.recycle();
        return r22;
    }
}
