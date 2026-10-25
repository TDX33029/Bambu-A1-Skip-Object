package defpackage;

import java.util.List;
import java.util.concurrent.CancellationException;

/* loaded from: classes.dex */
public final class pam {
    public final tw9 a;

    public pam(tw9 r1) {
        r1.getClass();
        this.a = r1;
    }

    public final Object a(String r5, tf7 r6) {
        if ((r6 instanceof jam) == false) goto L7;
        jam r0 = (jam) r6;
        int r1 = r0.d;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.d = r1 - Integer.MIN_VALUE;
    L8:
        Object r62 = r0.b;
        Object r12 = nsf.getCOROUTINE_SUSPENDED();
        int r2 = r0.d;
        if (r2 == 0) goto L15;
        if (r2 != 1) goto L13;
        String r4 = (String) r0.a;
        gti.r(r62);
        return ((pfo) r62).a;
    L13:
        jfn.u("call to 'resume' before 'invoke' with coroutine");
        return null;
    L15:
        gti.r(r62);
        r0.a = ibq.nullOutSpilledVariable(r5);
        r0.d = 1;
        Object r42 = c(r5, ba2.a, r0);
        if (r42 != r12) goto L18;
        return r12;
    L18:
        return r42;
    L7:
        r0 = new jam(this, r6);
        goto L8
    }

    public final Object b(String r5, tf7 r6) {
        if ((r6 instanceof kam) == false) goto L7;
        kam r0 = (kam) r6;
        int r1 = r0.d;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.d = r1 - Integer.MIN_VALUE;
    L8:
        Object r62 = r0.b;
        Object r12 = nsf.getCOROUTINE_SUSPENDED();
        int r2 = r0.d;
        if (r2 == 0) goto L15;
        if (r2 != 1) goto L13;
        String r4 = (String) r0.a;
        gti.r(r62);
        return ((pfo) r62).a;
    L13:
        jfn.u("call to 'resume' before 'invoke' with coroutine");
        return null;
    L15:
        gti.r(r62);
        r0.a = ibq.nullOutSpilledVariable(r5);
        r0.d = 1;
        Object r42 = c(r5, ga2.a, r0);
        if (r42 != r12) goto L18;
        return r12;
    L18:
        return r42;
    L7:
        r0 = new kam(this, r6);
        goto L8
    }

    public final Object c(String r5, ob2 r6, tf7 r7) {
        if ((r7 instanceof lam) == false) goto L7;
        lam r0 = (lam) r7;
        int r1 = r0.f;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.f = r1 - Integer.MIN_VALUE;
    L8:
        Object r72 = r0.d;
        Object r12 = nsf.getCOROUTINE_SUSPENDED();
        int r2 = r0.f;
        if (r2 == 0) goto L16;
        if (r2 != 1) goto L14;
        pam r4 = (pam) r0.c;
        ob2 r42 = (ob2) r0.b;
        String r43 = (String) r0.a;
        gti.r(r72);     // Catch: Throwable -> L22
    L20:
        Object r44 = trs.a;     // Catch: Throwable -> L22
    L24:
        Throwable r52 = pfo.a(r44);
        if (r52 != null) goto L27;
    L30:
        return r44;
    L27:
        if ((r52 instanceof CancellationException) == false) goto L30;
        throw r52;
    L14:
        jfn.u("call to 'resume' before 'invoke' with coroutine");
        return null;
    L16:
        gti.r(r72);
        tw9 r73 = this.a;     // Catch: Throwable -> L22
        r0.a = ibq.nullOutSpilledVariable(r5);     // Catch: Throwable -> L22
        r0.b = ibq.nullOutSpilledVariable(r6);     // Catch: Throwable -> L22
        r0.c = ibq.nullOutSpilledVariable(this);     // Catch: Throwable -> L22
        r0.f = 1;     // Catch: Throwable -> L22
        if (r73.a(r5, r6, r0) != r12) goto L20;
        return r12;
    L22:
        th = move-exception;
        r44 = new ofo(th);
    L7:
        r0 = new lam(this, r7);
        goto L8
    }

    public final Object d(String r5, List r6, tf7 r7) {
        if ((r7 instanceof mam) == false) goto L7;
        mam r0 = (mam) r7;
        int r1 = r0.e;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.e = r1 - Integer.MIN_VALUE;
    L8:
        Object r72 = r0.c;
        Object r12 = nsf.getCOROUTINE_SUSPENDED();
        int r2 = r0.e;
        if (r2 == 0) goto L15;
        if (r2 != 1) goto L13;
        List r4 = (List) r0.b;
        String r42 = (String) r0.a;
        gti.r(r72);
        return ((pfo) r72).a;
    L13:
        jfn.u("call to 'resume' before 'invoke' with coroutine");
        return null;
    L15:
        gti.r(r72);
        ob2 r73 = new ab2(r6);
        r0.a = ibq.nullOutSpilledVariable(r5);
        r0.b = ibq.nullOutSpilledVariable(r6);
        r0.e = 1;
        Object r43 = c(r5, r73, r0);
        if (r43 != r12) goto L18;
        return r12;
    L18:
        return r43;
    L7:
        r0 = new mam(this, r7);
        goto L8
    }

    public final Object e(String r5, tf7 r6) {
        if ((r6 instanceof nam) == false) goto L7;
        nam r0 = (nam) r6;
        int r1 = r0.d;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.d = r1 - Integer.MIN_VALUE;
    L8:
        Object r62 = r0.b;
        Object r12 = nsf.getCOROUTINE_SUSPENDED();
        int r2 = r0.d;
        if (r2 == 0) goto L15;
        if (r2 != 1) goto L13;
        String r4 = (String) r0.a;
        gti.r(r62);
        return ((pfo) r62).a;
    L13:
        jfn.u("call to 'resume' before 'invoke' with coroutine");
        return null;
    L15:
        gti.r(r62);
        r0.a = ibq.nullOutSpilledVariable(r5);
        r0.d = 1;
        Object r42 = c(r5, db2.a, r0);
        if (r42 != r12) goto L18;
        return r12;
    L18:
        return r42;
    L7:
        r0 = new nam(this, r6);
        goto L8
    }

    public final Object f(int r15, tf7 r16, String r17) {
        if ((r16 instanceof oam) == false) goto L7;
        oam r1 = (oam) r16;
        int r2 = r1.d;
        if ((r2 & Integer.MIN_VALUE) == 0) goto L7;
        r1.d = r2 - Integer.MIN_VALUE;
    L8:
        Object r0 = r1.b;
        Object r22 = nsf.getCOROUTINE_SUSPENDED();
        int r3 = r1.d;
        if (r3 == 0) goto L15;
        if (r3 != 1) goto L13;
        String r14 = (String) r1.a;
        gti.r(r0);
        return ((pfo) r0).a;
    L13:
        jfn.u("call to 'resume' before 'invoke' with coroutine");
        return null;
    L15:
        gti.r(r0);
        int r11 = 448;
        int r7 = 0;
        int r8 = 0;
        int r9 = 0;
        int r10 = 0;
        String r12 = "";
        ob2 r5 = new c82(r15, r7, r8, r9, r10, r11, r12, false);
        r1.a = ibq.nullOutSpilledVariable(r17);
        r1.d = 1;
        Object r142 = c(r17, r5, r1);
        if (r142 != r22) goto L18;
        return r22;
    L18:
        return r142;
    L7:
        r1 = new oam(this, r16);
        goto L8
    }
}
