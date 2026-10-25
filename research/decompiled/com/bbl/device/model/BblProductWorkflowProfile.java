package com.bbl.device.model;

import com.tutk.IOTC.AVIOCTRLDEFs;
import defpackage.b0r;
import defpackage.cn2;
import defpackage.dgh;
import io.sentry.protocol.Request;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b$\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u0000 +2\u00020\u0001:\u0001+Bk\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\f\u001a\u00020\u0003¢\u0006\u0004\b\r\u0010\u000eJ\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\t\u0010!\u001a\u00020\u0003HÆ\u0003J\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\t\u0010#\u001a\u00020\u0003HÆ\u0003Jm\u0010$\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u0003HÆ\u0001J\u0014\u0010%\u001a\u00020\u00032\b\u0010&\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010'\u001a\u00020(HÖ\u0081\u0004J\n\u0010)\u001a\u00020*HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0010R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0010R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0010R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0010R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0010R\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0010R\u0011\u0010\f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0010¨\u0006,"}, d2 = {"Lcom/bbl/device/model/BblProductWorkflowProfile;", "", "virtualSlotFeedWithInfoLevel", "", "amsChangeFilamentByCommand", "amsFilamentSettingOptionalClear", "printUseAms", "skipObjectsOnPrinterScreen", "flowCaliStartPrint", "extruderCali", "nozzleOffsetCali", "airPrintDetectNoXcam", "mode2DSupported", "<init>", "(ZZZZZZZZZZ)V", "getVirtualSlotFeedWithInfoLevel", "()Z", "getAmsChangeFilamentByCommand", "getAmsFilamentSettingOptionalClear", "getPrintUseAms", "getSkipObjectsOnPrinterScreen", "getFlowCaliStartPrint", "getExtruderCali", "getNozzleOffsetCali", "getAirPrintDetectNoXcam", "getMode2DSupported", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "copy", "equals", Request.JsonKeys.OTHER, "hashCode", "", "toString", "", "Companion", "device-biz"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class BblProductWorkflowProfile {
    public static final Companion Companion = null;
    private static final BblProductWorkflowProfile DEFAULT = null;
    private final boolean airPrintDetectNoXcam;
    private final boolean amsChangeFilamentByCommand;
    private final boolean amsFilamentSettingOptionalClear;
    private final boolean extruderCali;
    private final boolean flowCaliStartPrint;
    private final boolean mode2DSupported;
    private final boolean nozzleOffsetCali;
    private final boolean printUseAms;
    private final boolean skipObjectsOnPrinterScreen;
    private final boolean virtualSlotFeedWithInfoLevel;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/bbl/device/model/BblProductWorkflowProfile$Companion;", "", "<init>", "()V", "DEFAULT", "Lcom/bbl/device/model/BblProductWorkflowProfile;", "getDEFAULT", "()Lcom/bbl/device/model/BblProductWorkflowProfile;", "device-biz"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        public final BblProductWorkflowProfile getDEFAULT() {
            return BblProductWorkflowProfile.access$getDEFAULT$cp();
        }
    }

    static {
        Companion = new Companion(null);
        boolean r3 = false;
        boolean r4 = false;
        boolean r5 = false;
        boolean r6 = false;
        boolean r7 = false;
        boolean r8 = false;
        boolean r9 = false;
        boolean r10 = false;
        boolean r11 = false;
        boolean r12 = false;
        DEFAULT = new BblProductWorkflowProfile(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, AVIOCTRLDEFs.IOTYPE_USER_IPCAM_START_CLIENT, null);
    }

    public BblProductWorkflowProfile() {
        boolean r1 = false;
        boolean r2 = false;
        boolean r3 = false;
        boolean r4 = false;
        boolean r5 = false;
        boolean r6 = false;
        boolean r7 = false;
        boolean r8 = false;
        boolean r9 = false;
        boolean r10 = false;
        this(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, AVIOCTRLDEFs.IOTYPE_USER_IPCAM_START_CLIENT, null);
    }

    public BblProductWorkflowProfile(boolean r1, boolean r2, boolean r3, boolean r4, boolean r5, boolean r6, boolean r7, boolean r8, boolean r9, boolean r10) {
        this.virtualSlotFeedWithInfoLevel = r1;
        this.amsChangeFilamentByCommand = r2;
        this.amsFilamentSettingOptionalClear = r3;
        this.printUseAms = r4;
        this.skipObjectsOnPrinterScreen = r5;
        this.flowCaliStartPrint = r6;
        this.extruderCali = r7;
        this.nozzleOffsetCali = r8;
        this.airPrintDetectNoXcam = r9;
        this.mode2DSupported = r10;
    }

    public /* synthetic */ BblProductWorkflowProfile(boolean r3, boolean r4, boolean r5, boolean r6, boolean r7, boolean r8, boolean r9, boolean r10, boolean r11, boolean r12, int r13, DefaultConstructorMarker r14) {
        if ((r13 & 1) == 0) goto L6;
        r3 = false;
    L6:
        if ((r13 & 2) == 0) goto L9;
        r4 = false;
    L9:
        if ((r13 & 4) == 0) goto L12;
        r5 = false;
    L12:
        if ((r13 & 8) == 0) goto L15;
        r6 = true;
    L15:
        if ((r13 & 16) == 0) goto L18;
        r7 = true;
    L18:
        if ((r13 & 32) == 0) goto L21;
        r8 = true;
    L21:
        if ((r13 & 64) == 0) goto L24;
        r9 = false;
    L24:
        if ((r13 & 128) == 0) goto L27;
        r10 = false;
    L27:
        if ((r13 & 256) == 0) goto L30;
        r11 = false;
    L30:
        if ((r13 & 512) == 0) goto L32;
        r12 = false;
    L32:
        this(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12);
    }

    public static final /* synthetic */ BblProductWorkflowProfile access$getDEFAULT$cp() {
        return DEFAULT;
    }

    public static /* synthetic */ BblProductWorkflowProfile copy$default(BblProductWorkflowProfile r0, boolean r1, boolean r2, boolean r3, boolean r4, boolean r5, boolean r6, boolean r7, boolean r8, boolean r9, boolean r10, int r11, Object r12) {
        if ((r11 & 1) == 0) goto L6;
        r1 = r0.virtualSlotFeedWithInfoLevel;
    L6:
        if ((r11 & 2) == 0) goto L9;
        r2 = r0.amsChangeFilamentByCommand;
    L9:
        if ((r11 & 4) == 0) goto L12;
        r3 = r0.amsFilamentSettingOptionalClear;
    L12:
        if ((r11 & 8) == 0) goto L15;
        r4 = r0.printUseAms;
    L15:
        if ((r11 & 16) == 0) goto L18;
        r5 = r0.skipObjectsOnPrinterScreen;
    L18:
        if ((r11 & 32) == 0) goto L21;
        r6 = r0.flowCaliStartPrint;
    L21:
        if ((r11 & 64) == 0) goto L24;
        r7 = r0.extruderCali;
    L24:
        if ((r11 & 128) == 0) goto L27;
        r8 = r0.nozzleOffsetCali;
    L27:
        if ((r11 & 256) == 0) goto L30;
        r9 = r0.airPrintDetectNoXcam;
    L30:
        if ((r11 & 512) == 0) goto L32;
        r10 = r0.mode2DSupported;
    L32:
        boolean r112 = r9;
        boolean r122 = r10;
        boolean r92 = r7;
        boolean r102 = r8;
        boolean r72 = r5;
        boolean r82 = r6;
        boolean r52 = r3;
        boolean r62 = r4;
        return r0.copy(r1, r2, r52, r62, r72, r82, r92, r102, r112, r122);
    }

    public final boolean component1() {
        return this.virtualSlotFeedWithInfoLevel;
    }

    public final boolean component10() {
        return this.mode2DSupported;
    }

    public final boolean component2() {
        return this.amsChangeFilamentByCommand;
    }

    public final boolean component3() {
        return this.amsFilamentSettingOptionalClear;
    }

    public final boolean component4() {
        return this.printUseAms;
    }

    public final boolean component5() {
        return this.skipObjectsOnPrinterScreen;
    }

    public final boolean component6() {
        return this.flowCaliStartPrint;
    }

    public final boolean component7() {
        return this.extruderCali;
    }

    public final boolean component8() {
        return this.nozzleOffsetCali;
    }

    public final boolean component9() {
        return this.airPrintDetectNoXcam;
    }

    public final BblProductWorkflowProfile copy(boolean r1, boolean r2, boolean r3, boolean r4, boolean r5, boolean r6, boolean r7, boolean r8, boolean r9, boolean r10) {
        return new BblProductWorkflowProfile(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof BblProductWorkflowProfile) == true) goto L8;
        return false;
    L8:
        BblProductWorkflowProfile r52 = (BblProductWorkflowProfile) r5;
        if (this.virtualSlotFeedWithInfoLevel == r52.virtualSlotFeedWithInfoLevel) goto L12;
        return false;
    L12:
        if (this.amsChangeFilamentByCommand == r52.amsChangeFilamentByCommand) goto L15;
        return false;
    L15:
        if (this.amsFilamentSettingOptionalClear == r52.amsFilamentSettingOptionalClear) goto L18;
        return false;
    L18:
        if (this.printUseAms == r52.printUseAms) goto L21;
        return false;
    L21:
        if (this.skipObjectsOnPrinterScreen == r52.skipObjectsOnPrinterScreen) goto L24;
        return false;
    L24:
        if (this.flowCaliStartPrint == r52.flowCaliStartPrint) goto L27;
        return false;
    L27:
        if (this.extruderCali == r52.extruderCali) goto L30;
        return false;
    L30:
        if (this.nozzleOffsetCali == r52.nozzleOffsetCali) goto L33;
        return false;
    L33:
        if (this.airPrintDetectNoXcam == r52.airPrintDetectNoXcam) goto L36;
        return false;
    L36:
        if (this.mode2DSupported == r52.mode2DSupported) goto L38;
        return false;
    L38:
        return true;
    }

    public final boolean getAirPrintDetectNoXcam() {
        return this.airPrintDetectNoXcam;
    }

    public final boolean getAmsChangeFilamentByCommand() {
        return this.amsChangeFilamentByCommand;
    }

    public final boolean getAmsFilamentSettingOptionalClear() {
        return this.amsFilamentSettingOptionalClear;
    }

    public final boolean getExtruderCali() {
        return this.extruderCali;
    }

    public final boolean getFlowCaliStartPrint() {
        return this.flowCaliStartPrint;
    }

    public final boolean getMode2DSupported() {
        return this.mode2DSupported;
    }

    public final boolean getNozzleOffsetCali() {
        return this.nozzleOffsetCali;
    }

    public final boolean getPrintUseAms() {
        return this.printUseAms;
    }

    public final boolean getSkipObjectsOnPrinterScreen() {
        return this.skipObjectsOnPrinterScreen;
    }

    public final boolean getVirtualSlotFeedWithInfoLevel() {
        return this.virtualSlotFeedWithInfoLevel;
    }

    public int hashCode() {
        int r0 = b0r.c(b0r.c(b0r.c(b0r.c(b0r.c(b0r.c(b0r.c(b0r.c(Boolean.hashCode(this.virtualSlotFeedWithInfoLevel) * 31, 31, this.amsChangeFilamentByCommand), 31, this.amsFilamentSettingOptionalClear), 31, this.printUseAms), 31, this.skipObjectsOnPrinterScreen), 31, this.flowCaliStartPrint), 31, this.extruderCali), 31, this.nozzleOffsetCali), 31, this.airPrintDetectNoXcam);
        return Boolean.hashCode(this.mode2DSupported) + r0;
    }

    public String toString() {
        boolean r0 = this.virtualSlotFeedWithInfoLevel;
        boolean r1 = this.amsChangeFilamentByCommand;
        boolean r2 = this.amsFilamentSettingOptionalClear;
        boolean r3 = this.printUseAms;
        boolean r4 = this.skipObjectsOnPrinterScreen;
        boolean r5 = this.flowCaliStartPrint;
        boolean r6 = this.extruderCali;
        boolean r7 = this.nozzleOffsetCali;
        boolean r8 = this.airPrintDetectNoXcam;
        boolean r12 = this.mode2DSupported;
        StringBuilder r02 = dgh.r(r0, "BblProductWorkflowProfile(virtualSlotFeedWithInfoLevel=", ", amsChangeFilamentByCommand=", ", amsFilamentSettingOptionalClear=", r1);
        dgh.A(", printUseAms=", ", skipObjectsOnPrinterScreen=", r02, r2, r3);
        dgh.A(", flowCaliStartPrint=", ", extruderCali=", r02, r4, r5);
        dgh.A(", nozzleOffsetCali=", ", airPrintDetectNoXcam=", r02, r6, r7);
        return cn2.g(", mode2DSupported=", ")", r02, r8, r12);
    }
}
