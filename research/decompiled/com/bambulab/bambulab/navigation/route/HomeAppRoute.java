package com.bambulab.bambulab.navigation.route;

import com.bambulab.bambulab.model.AmsDetailMapping;
import com.bambulab.bambulab.model.AmsDetailMapping$$serializer;
import com.bambulab.bambulab.model.DesignAttachment;
import com.bambulab.bambulab.model.DesignAttachment$$serializer;
import com.bambulab.bambulab.model.DesignModel;
import com.bambulab.bambulab.model.IotPlateObjectId;
import com.bambulab.bambulab.model.IotPlateObjectId$$serializer;
import com.bambulab.bambulab.model.MultiTaskProjectPlateModel;
import com.bambulab.bambulab.model.MultiTaskProjectPlateModel$$serializer;
import com.bambulab.bambulab.model.PrintHistoryModel;
import com.bambulab.bambulab.model.PrintNozzleInfo;
import com.bambulab.bambulab.model.PrintNozzleInfo$$serializer;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import defpackage.a7m;
import defpackage.acd;
import defpackage.b0r;
import defpackage.bb6;
import defpackage.bsa;
import defpackage.dgh;
import defpackage.egb;
import defpackage.fgb;
import defpackage.i3e;
import defpackage.kn2;
import defpackage.lkg;
import defpackage.lsf;
import defpackage.o0g;
import defpackage.por;
import defpackage.r77;
import defpackage.rie;
import defpackage.t4m;
import defpackage.ul7;
import defpackage.x5m;
import defpackage.z86;
import io.agora.rtc2.Constants;
import io.agora.rtc2.internal.AudioRoutingController;
import io.sentry.protocol.Request;
import java.lang.annotation.Annotation;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.Transient;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.BooleanSerializer;
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.LinkedHashMapSerializer;
import kotlinx.serialization.internal.LongSerializer;
import kotlinx.serialization.internal.ObjectSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bw\u0018\u0000 \u00022\u00020\u0001:\u001d\u0003\u0004\u0005\u0006\u0007\b\t\n\u000b\f\r\u000e\u000f\u0010\u0011\u0012\u0013\u0014\u0015\u0016\u0017\u0018\u0019\u001a\u001b\u001c\u001d\u001e\u001f\u0082\u0001\u001c !\"#$%&'()*+,-./0123456789:;¨\u0006<À\u0006\u0003"}, d2 = {"Lcom/bambulab/bambulab/navigation/route/HomeAppRoute;", "Lcom/bambulab/bambulab/navigation/route/AppRoute;", "Companion", "ModelCollection", "AllModel", "DesignDetail", "DesignDetailPlates", "DesignDetail2dPlates", "ProfileRatingList", "DesignDetailComment", "DesignDetailRemixed", "DesignAttachmentList", "DesignPrint", "AddToQueue", "HowPrintDesign", "HowUsePreset", "Preview3D", "DesignSkipObjects", "ContestToggle", "ContestDetail", "ContestPreDetail", "ContestMyEntries", "Community", "PostDetail", "PostCommentDetail", "PostCommunityGraph", "PostCommunity", "ChooseAitUser", "ChooseTopic", "CommunitySearch", "VideoPlayer", "com/bambulab/bambulab/navigation/route/x5", "Lcom/bambulab/bambulab/navigation/route/HomeAppRoute$AddToQueue;", "Lcom/bambulab/bambulab/navigation/route/HomeAppRoute$AllModel;", "Lcom/bambulab/bambulab/navigation/route/HomeAppRoute$ChooseAitUser;", "Lcom/bambulab/bambulab/navigation/route/HomeAppRoute$ChooseTopic;", "Lcom/bambulab/bambulab/navigation/route/HomeAppRoute$Community;", "Lcom/bambulab/bambulab/navigation/route/HomeAppRoute$CommunitySearch;", "Lcom/bambulab/bambulab/navigation/route/HomeAppRoute$ContestDetail;", "Lcom/bambulab/bambulab/navigation/route/HomeAppRoute$ContestMyEntries;", "Lcom/bambulab/bambulab/navigation/route/HomeAppRoute$ContestPreDetail;", "Lcom/bambulab/bambulab/navigation/route/HomeAppRoute$ContestToggle;", "Lcom/bambulab/bambulab/navigation/route/HomeAppRoute$DesignAttachmentList;", "Lcom/bambulab/bambulab/navigation/route/HomeAppRoute$DesignDetail;", "Lcom/bambulab/bambulab/navigation/route/HomeAppRoute$DesignDetail2dPlates;", "Lcom/bambulab/bambulab/navigation/route/HomeAppRoute$DesignDetailComment;", "Lcom/bambulab/bambulab/navigation/route/HomeAppRoute$DesignDetailPlates;", "Lcom/bambulab/bambulab/navigation/route/HomeAppRoute$DesignDetailRemixed;", "Lcom/bambulab/bambulab/navigation/route/HomeAppRoute$DesignPrint;", "Lcom/bambulab/bambulab/navigation/route/HomeAppRoute$DesignSkipObjects;", "Lcom/bambulab/bambulab/navigation/route/HomeAppRoute$HowPrintDesign;", "Lcom/bambulab/bambulab/navigation/route/HomeAppRoute$HowUsePreset;", "Lcom/bambulab/bambulab/navigation/route/HomeAppRoute$ModelCollection;", "Lcom/bambulab/bambulab/navigation/route/HomeAppRoute$PostCommentDetail;", "Lcom/bambulab/bambulab/navigation/route/HomeAppRoute$PostCommunity;", "Lcom/bambulab/bambulab/navigation/route/HomeAppRoute$PostCommunityGraph;", "Lcom/bambulab/bambulab/navigation/route/HomeAppRoute$PostDetail;", "Lcom/bambulab/bambulab/navigation/route/HomeAppRoute$Preview3D;", "Lcom/bambulab/bambulab/navigation/route/HomeAppRoute$ProfileRatingList;", "Lcom/bambulab/bambulab/navigation/route/HomeAppRoute$VideoPlayer;", "navigation"}, k = 1, mv = {2, 4, 0}, xi = 48)
@Serializable
/* loaded from: classes.dex */
public interface HomeAppRoute extends AppRoute {
    public static final x5 Companion = null;

    @Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0018\b\u0087\b\u0018\u0000 O2\u00020\u0001:\u0002PQB©\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0005\u0012\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00050\u000e\u0012\u000e\b\u0002\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00050\u000e\u0012\u000e\b\u0002\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u000e¢\u0006\u0004\b\u0013\u0010\u0014B\u00ad\u0001\b\u0010\u0012\u0006\u0010\u0016\u001a\u00020\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0005\u0012\u000e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u000e\u0012\u000e\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u000e\u0012\u000e\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u000e\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017¢\u0006\u0004\b\u0013\u0010\u0019J\u0010\u0010\u001a\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u001a\u0010\u001bJ\u0012\u0010\u001c\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u001e\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u001e\u0010\u001fJ\u0012\u0010 \u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b \u0010\u001fJ\u0012\u0010!\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b!\u0010\u001fJ\u0012\u0010\"\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\"\u0010\u001fJ\u0012\u0010#\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b#\u0010\u001fJ\u0012\u0010$\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b$\u0010\u001fJ\u0012\u0010%\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b%\u0010\u001fJ\u0012\u0010&\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b&\u0010\u001fJ\u0016\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00050\u000eHÆ\u0003¢\u0006\u0004\b'\u0010(J\u0016\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00050\u000eHÆ\u0003¢\u0006\u0004\b)\u0010(J\u0016\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00110\u000eHÆ\u0003¢\u0006\u0004\b*\u0010(J´\u0001\u0010+\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00052\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00050\u000e2\u000e\b\u0002\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00050\u000e2\u000e\b\u0002\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u000eHÆ\u0001¢\u0006\u0004\b+\u0010,J\u0010\u0010-\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b-\u0010\u001fJ\u0010\u0010.\u001a\u00020\u0015HÖ\u0001¢\u0006\u0004\b.\u0010/J\u001a\u00103\u001a\u0002022\b\u00101\u001a\u0004\u0018\u000100HÖ\u0003¢\u0006\u0004\b3\u00104J'\u0010=\u001a\u00020:2\u0006\u00105\u001a\u00020\u00002\u0006\u00107\u001a\u0002062\u0006\u00109\u001a\u000208H\u0001¢\u0006\u0004\b;\u0010<R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010>\u001a\u0004\b?\u0010\u001bR\u0019\u0010\u0004\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010@\u001a\u0004\bA\u0010\u001dR\u0017\u0010\u0006\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010B\u001a\u0004\bC\u0010\u001fR\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00058\u0006¢\u0006\f\n\u0004\b\u0007\u0010B\u001a\u0004\bD\u0010\u001fR\u0019\u0010\b\u001a\u0004\u0018\u00010\u00058\u0006¢\u0006\f\n\u0004\b\b\u0010B\u001a\u0004\bE\u0010\u001fR\u0019\u0010\t\u001a\u0004\u0018\u00010\u00058\u0006¢\u0006\f\n\u0004\b\t\u0010B\u001a\u0004\bF\u0010\u001fR\u0019\u0010\n\u001a\u0004\u0018\u00010\u00058\u0006¢\u0006\f\n\u0004\b\n\u0010B\u001a\u0004\bG\u0010\u001fR\u0019\u0010\u000b\u001a\u0004\u0018\u00010\u00058\u0006¢\u0006\f\n\u0004\b\u000b\u0010B\u001a\u0004\bH\u0010\u001fR\u0019\u0010\f\u001a\u0004\u0018\u00010\u00058\u0006¢\u0006\f\n\u0004\b\f\u0010B\u001a\u0004\bI\u0010\u001fR\u0019\u0010\r\u001a\u0004\u0018\u00010\u00058\u0006¢\u0006\f\n\u0004\b\r\u0010B\u001a\u0004\bJ\u0010\u001fR\u001d\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00050\u000e8\u0006¢\u0006\f\n\u0004\b\u000f\u0010K\u001a\u0004\bL\u0010(R\u001d\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00050\u000e8\u0006¢\u0006\f\n\u0004\b\u0010\u0010K\u001a\u0004\bM\u0010(R\u001d\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u000e8\u0006¢\u0006\f\n\u0004\b\u0012\u0010K\u001a\u0004\bN\u0010(¨\u0006R"}, d2 = {"Lcom/bambulab/bambulab/navigation/route/HomeAppRoute$AddToQueue;", "Lcom/bambulab/bambulab/navigation/route/HomeAppRoute;", "", "profileId", "designId", "", "mode", "designTitle", "profileCover", "profileName", "sourceFrom", "bizType", "bizKey", "initialDeviceId", "", "deviceIds", "compatibleModelNames", "Lcom/bambulab/bambulab/model/MultiTaskProjectPlateModel;", "plates", "<init>", "(JLjava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/util/List;)V", "", "seen0", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "serializationConstructorMarker", "(IJLjava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/util/List;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "component1", "()J", "component2", "()Ljava/lang/Long;", "component3", "()Ljava/lang/String;", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "()Ljava/util/List;", "component12", "component13", "copy", "(JLjava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/util/List;)Lcom/bambulab/bambulab/navigation/route/HomeAppRoute$AddToQueue;", "toString", "hashCode", "()I", "", Request.JsonKeys.OTHER, "", "equals", "(Ljava/lang/Object;)Z", "self", "Lkotlinx/serialization/encoding/CompositeEncoder;", "output", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "serialDesc", "Ltrs;", "write$Self$navigation", "(Lcom/bambulab/bambulab/navigation/route/HomeAppRoute$AddToQueue;Lkotlinx/serialization/encoding/CompositeEncoder;Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "write$Self", "J", "getProfileId", "Ljava/lang/Long;", "getDesignId", "Ljava/lang/String;", "getMode", "getDesignTitle", "getProfileCover", "getProfileName", "getSourceFrom", "getBizType", "getBizKey", "getInitialDeviceId", "Ljava/util/List;", "getDeviceIds", "getCompatibleModelNames", "getPlates", "Companion", "com/bambulab/bambulab/navigation/route/p5", "com/bambulab/bambulab/navigation/route/q5", "navigation"}, k = 1, mv = {2, 4, 0}, xi = 48)
    @Serializable
    public static final class AddToQueue implements HomeAppRoute {
        private static final Lazy<KSerializer<Object>>[] $childSerializers = null;
        public static final int $stable = 0;
        public static final q5 Companion = null;
        private final String bizKey;
        private final String bizType;
        private final List<String> compatibleModelNames;
        private final Long designId;
        private final String designTitle;
        private final List<String> deviceIds;
        private final String initialDeviceId;
        private final String mode;
        private final List<MultiTaskProjectPlateModel> plates;
        private final String profileCover;
        private final long profileId;
        private final String profileName;
        private final String sourceFrom;

        static {
            Companion = new q5();
            acd r0 = new acd(21);
            lkg r1 = lkg.b;
            $childSerializers = new Lazy[]{null, null, null, null, null, null, null, null, null, null, z86.y(r1, r0), z86.y(r1, new acd(22)), z86.y(r1, new acd(23))};
        }

        public /* synthetic */ AddToQueue(int r3, long r4, Long r6, String r7, String r8, String r9, String r10, String r11, String r12, String r13, String r14, List r15, List r16, List r17, SerializationConstructorMarker r18) {
            if (1 == (r3 & 1)) goto L5;
            PluginExceptionsKt.throwMissingFieldException(r3, 1, p5.a.getDescriptor());
        L5:
            this.profileId = r4;
            if ((r3 & 2) != 0) goto L8;
            this.designId = null;
        L10:
            if ((r3 & 4) != 0) goto L12;
            this.mode = PrintHistoryModel.MODE_CLOUD_SLICE;
        L14:
            if ((r3 & 8) != 0) goto L16;
            this.designTitle = null;
        L18:
            if ((r3 & 16) != 0) goto L20;
            this.profileCover = null;
        L22:
            if ((r3 & 32) != 0) goto L24;
            this.profileName = null;
        L26:
            if ((r3 & 64) != 0) goto L28;
            this.sourceFrom = null;
        L30:
            if ((r3 & 128) != 0) goto L32;
            this.bizType = null;
        L34:
            if ((r3 & 256) != 0) goto L36;
            this.bizKey = null;
        L38:
            if ((r3 & 512) != 0) goto L40;
            this.initialDeviceId = null;
        L41:
            int r42 = r3 & 1024;
            egb r5 = egb.a;
            if (r42 != 0) goto L44;
            this.deviceIds = r5;
        L46:
            if ((r3 & 2048) != 0) goto L48;
            this.compatibleModelNames = r5;
        L50:
            if ((r3 & 4096) != 0) goto L53;
            this.plates = r5;
            return;
        L53:
            this.plates = r17;
            return;
        L48:
            this.compatibleModelNames = r16;
            goto L50
        L44:
            this.deviceIds = r15;
            goto L46
        L40:
            this.initialDeviceId = r14;
            goto L41
        L36:
            this.bizKey = r13;
            goto L38
        L32:
            this.bizType = r12;
            goto L34
        L28:
            this.sourceFrom = r11;
            goto L30
        L24:
            this.profileName = r10;
            goto L26
        L20:
            this.profileCover = r9;
            goto L22
        L16:
            this.designTitle = r8;
            goto L18
        L12:
            this.mode = r7;
            goto L14
        L8:
            this.designId = r6;
            goto L10
        }

        public AddToQueue(long r1, Long r3, String r4, String r5, String r6, String r7, String r8, String r9, String r10, String r11, List<String> r12, List<String> r13, List<MultiTaskProjectPlateModel> r14) {
            r4.getClass();
            r12.getClass();
            r13.getClass();
            r14.getClass();
            this.profileId = r1;
            this.designId = r3;
            this.mode = r4;
            this.designTitle = r5;
            this.profileCover = r6;
            this.profileName = r7;
            this.sourceFrom = r8;
            this.bizType = r9;
            this.bizKey = r10;
            this.initialDeviceId = r11;
            this.deviceIds = r12;
            this.compatibleModelNames = r13;
            this.plates = r14;
        }

        public /* synthetic */ AddToQueue(long r19, Long r21, String r22, String r23, String r24, String r25, String r26, String r27, String r28, String r29, List r30, List r31, List r32, int r33, DefaultConstructorMarker r34) {
            if ((r33 & 2) == 0) goto L5;
            Long r6 = null;
        L7:
            if ((r33 & 4) == 0) goto L9;
            String r7 = PrintHistoryModel.MODE_CLOUD_SLICE;
        L11:
            if ((r33 & 8) == 0) goto L13;
            String r8 = null;
        L15:
            if ((r33 & 16) == 0) goto L17;
            String r9 = null;
        L19:
            if ((r33 & 32) == 0) goto L21;
            String r10 = null;
        L23:
            if ((r33 & 64) == 0) goto L25;
            String r11 = null;
        L27:
            if ((r33 & 128) == 0) goto L29;
            String r12 = null;
        L31:
            if ((r33 & 256) == 0) goto L33;
            String r13 = null;
        L35:
            if ((r33 & 512) == 0) goto L37;
            String r14 = null;
        L38:
            int r1 = r33 & 1024;
            egb r2 = egb.a;
            if (r1 == 0) goto L41;
            List r15 = r2;
        L43:
            if ((r33 & 2048) == 0) goto L45;
            List r16 = r2;
        L47:
            if ((r33 & 4096) == 0) goto L50;
            List r17 = r2;
        L51:
            this(r19, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17);
            return;
        L50:
            r17 = r32;
            goto L51
        L45:
            r16 = r31;
            goto L47
        L41:
            r15 = r30;
            goto L43
        L37:
            r14 = r29;
            goto L38
        L33:
            r13 = r28;
            goto L35
        L29:
            r12 = r27;
            goto L31
        L25:
            r11 = r26;
            goto L27
        L21:
            r10 = r25;
            goto L23
        L17:
            r9 = r24;
            goto L19
        L13:
            r8 = r23;
            goto L15
        L9:
            r7 = r22;
            goto L11
        L5:
            r6 = r21;
            goto L7
        }

        private static final /* synthetic */ KSerializer _childSerializers$_anonymous_() {
            return new ArrayListSerializer(StringSerializer.INSTANCE);
        }

        private static final /* synthetic */ KSerializer _childSerializers$_anonymous_$0() {
            return new ArrayListSerializer(StringSerializer.INSTANCE);
        }

        private static final /* synthetic */ KSerializer _childSerializers$_anonymous_$1() {
            return new ArrayListSerializer(MultiTaskProjectPlateModel$$serializer.INSTANCE);
        }

        public static /* synthetic */ KSerializer a() {
            return _childSerializers$_anonymous_$0();
        }

        public static final /* synthetic */ Lazy[] access$get$childSerializers$cp() {
            return $childSerializers;
        }

        public static /* synthetic */ KSerializer b() {
            return _childSerializers$_anonymous_$1();
        }

        public static /* synthetic */ KSerializer c() {
            return _childSerializers$_anonymous_();
        }

        public static /* synthetic */ AddToQueue copy$default(AddToQueue r14, long r15, Long r17, String r18, String r19, String r20, String r21, String r22, String r23, String r24, String r25, List r26, List r27, List r28, int r29, Object r30) {
            if ((r29 & 1) == 0) goto L5;
            long r1 = r14.profileId;
        L7:
            if ((r29 & 2) == 0) goto L9;
            Long r3 = r14.designId;
        L11:
            if ((r29 & 4) == 0) goto L13;
            String r4 = r14.mode;
        L15:
            if ((r29 & 8) == 0) goto L17;
            String r5 = r14.designTitle;
        L19:
            if ((r29 & 16) == 0) goto L21;
            String r6 = r14.profileCover;
        L23:
            if ((r29 & 32) == 0) goto L25;
            String r7 = r14.profileName;
        L27:
            if ((r29 & 64) == 0) goto L29;
            String r8 = r14.sourceFrom;
        L31:
            if ((r29 & 128) == 0) goto L33;
            String r9 = r14.bizType;
        L35:
            if ((r29 & 256) == 0) goto L37;
            String r10 = r14.bizKey;
        L39:
            if ((r29 & 512) == 0) goto L41;
            String r11 = r14.initialDeviceId;
        L43:
            if ((r29 & 1024) == 0) goto L45;
            List r12 = r14.deviceIds;
        L47:
            if ((r29 & 2048) == 0) goto L49;
            List r13 = r14.compatibleModelNames;
        L51:
            if ((r29 & 4096) == 0) goto L54;
            List r292 = r14.plates;
        L56:
            return r14.copy(r1, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r292);
        L54:
            r292 = r28;
            goto L56
        L49:
            r13 = r27;
            goto L51
        L45:
            r12 = r26;
            goto L47
        L41:
            r11 = r25;
            goto L43
        L37:
            r10 = r24;
            goto L39
        L33:
            r9 = r23;
            goto L35
        L29:
            r8 = r22;
            goto L31
        L25:
            r7 = r21;
            goto L27
        L21:
            r6 = r20;
            goto L23
        L17:
            r5 = r19;
            goto L19
        L13:
            r4 = r18;
            goto L15
        L9:
            r3 = r17;
            goto L11
        L5:
            r1 = r15;
            goto L7
        }

        @o0g
        public static final /* synthetic */ void write$Self$navigation(AddToQueue r5, CompositeEncoder r6, SerialDescriptor r7) {
            Lazy<KSerializer<Object>>[] r0 = $childSerializers;
            r6.encodeLongElement(r7, 0, r5.profileId);
            if (r6.shouldEncodeElementDefault(r7, 1) == false) goto L6;
        L7:
            r6.encodeNullableSerializableElement(r7, 1, LongSerializer.INSTANCE, r5.designId);
        L9:
            if (r6.shouldEncodeElementDefault(r7, 2) == false) goto L12;
        L13:
            r6.encodeStringElement(r7, 2, r5.mode);
        L15:
            if (r6.shouldEncodeElementDefault(r7, 3) == false) goto L18;
        L19:
            r6.encodeNullableSerializableElement(r7, 3, StringSerializer.INSTANCE, r5.designTitle);
        L21:
            if (r6.shouldEncodeElementDefault(r7, 4) == false) goto L24;
        L25:
            r6.encodeNullableSerializableElement(r7, 4, StringSerializer.INSTANCE, r5.profileCover);
        L27:
            if (r6.shouldEncodeElementDefault(r7, 5) == false) goto L30;
        L31:
            r6.encodeNullableSerializableElement(r7, 5, StringSerializer.INSTANCE, r5.profileName);
        L33:
            if (r6.shouldEncodeElementDefault(r7, 6) == false) goto L36;
        L37:
            r6.encodeNullableSerializableElement(r7, 6, StringSerializer.INSTANCE, r5.sourceFrom);
        L39:
            if (r6.shouldEncodeElementDefault(r7, 7) == false) goto L42;
        L43:
            r6.encodeNullableSerializableElement(r7, 7, StringSerializer.INSTANCE, r5.bizType);
        L45:
            if (r6.shouldEncodeElementDefault(r7, 8) == false) goto L48;
        L49:
            r6.encodeNullableSerializableElement(r7, 8, StringSerializer.INSTANCE, r5.bizKey);
        L51:
            if (r6.shouldEncodeElementDefault(r7, 9) == false) goto L54;
        L55:
            r6.encodeNullableSerializableElement(r7, 9, StringSerializer.INSTANCE, r5.initialDeviceId);
        L56:
            boolean r2 = r6.shouldEncodeElementDefault(r7, 10);
            egb r3 = egb.a;
            if (r2 == false) goto L60;
        L61:
            r6.encodeSerializableElement(r7, 10, (SerializationStrategy) r0[10].getValue(), r5.deviceIds);
        L63:
            if (r6.shouldEncodeElementDefault(r7, 11) == false) goto L66;
        L67:
            r6.encodeSerializableElement(r7, 11, (SerializationStrategy) r0[11].getValue(), r5.compatibleModelNames);
        L69:
            if (r6.shouldEncodeElementDefault(r7, 12) == false) goto L72;
        L73:
            r6.encodeSerializableElement(r7, 12, (SerializationStrategy) r0[12].getValue(), r5.plates);
            return;
        L72:
            if (lsf.l(r5.plates, r3) == false) goto L73;
            return;
        L66:
            if (lsf.l(r5.compatibleModelNames, r3) == true) goto L69;
        L60:
            if (lsf.l(r5.deviceIds, r3) == true) goto L63;
        L54:
            if (r5.initialDeviceId == null) goto L56;
        L48:
            if (r5.bizKey == null) goto L51;
        L42:
            if (r5.bizType == null) goto L45;
        L36:
            if (r5.sourceFrom == null) goto L39;
        L30:
            if (r5.profileName == null) goto L33;
        L24:
            if (r5.profileCover == null) goto L27;
        L18:
            if (r5.designTitle == null) goto L21;
        L12:
            if (lsf.l(r5.mode, PrintHistoryModel.MODE_CLOUD_SLICE) == true) goto L15;
        L6:
            if (r5.designId == null) goto L9;
            goto L7
        }

        public final long component1() {
            return this.profileId;
        }

        public final String component10() {
            return this.initialDeviceId;
        }

        public final List<String> component11() {
            return this.deviceIds;
        }

        public final List<String> component12() {
            return this.compatibleModelNames;
        }

        public final List<MultiTaskProjectPlateModel> component13() {
            return this.plates;
        }

        public final Long component2() {
            return this.designId;
        }

        public final String component3() {
            return this.mode;
        }

        public final String component4() {
            return this.designTitle;
        }

        public final String component5() {
            return this.profileCover;
        }

        public final String component6() {
            return this.profileName;
        }

        public final String component7() {
            return this.sourceFrom;
        }

        public final String component8() {
            return this.bizType;
        }

        public final String component9() {
            return this.bizKey;
        }

        public final AddToQueue copy(long r1, Long r3, String r4, String r5, String r6, String r7, String r8, String r9, String r10, String r11, List<String> r12, List<String> r13, List<MultiTaskProjectPlateModel> r14) {
            r4.getClass();
            r12.getClass();
            r13.getClass();
            r14.getClass();
            return new AddToQueue(r1, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14);
        }

        public boolean equals(Object r8) {
            if (this != r8) goto L6;
            return true;
        L6:
            if ((r8 instanceof AddToQueue) == true) goto L8;
            return false;
        L8:
            AddToQueue r82 = (AddToQueue) r8;
            if (this.profileId == r82.profileId) goto L12;
            return false;
        L12:
            if (lsf.l(this.designId, r82.designId) == true) goto L15;
            return false;
        L15:
            if (lsf.l(this.mode, r82.mode) == true) goto L18;
            return false;
        L18:
            if (lsf.l(this.designTitle, r82.designTitle) == true) goto L21;
            return false;
        L21:
            if (lsf.l(this.profileCover, r82.profileCover) == true) goto L24;
            return false;
        L24:
            if (lsf.l(this.profileName, r82.profileName) == true) goto L27;
            return false;
        L27:
            if (lsf.l(this.sourceFrom, r82.sourceFrom) == true) goto L30;
            return false;
        L30:
            if (lsf.l(this.bizType, r82.bizType) == true) goto L33;
            return false;
        L33:
            if (lsf.l(this.bizKey, r82.bizKey) == true) goto L36;
            return false;
        L36:
            if (lsf.l(this.initialDeviceId, r82.initialDeviceId) == true) goto L39;
            return false;
        L39:
            if (lsf.l(this.deviceIds, r82.deviceIds) == true) goto L42;
            return false;
        L42:
            if (lsf.l(this.compatibleModelNames, r82.compatibleModelNames) == true) goto L45;
            return false;
        L45:
            if (lsf.l(this.plates, r82.plates) == true) goto L47;
            return false;
        L47:
            return true;
        }

        public final String getBizKey() {
            return this.bizKey;
        }

        public final String getBizType() {
            return this.bizType;
        }

        public final List<String> getCompatibleModelNames() {
            return this.compatibleModelNames;
        }

        public final Long getDesignId() {
            return this.designId;
        }

        public final String getDesignTitle() {
            return this.designTitle;
        }

        public final List<String> getDeviceIds() {
            return this.deviceIds;
        }

        public final String getInitialDeviceId() {
            return this.initialDeviceId;
        }

        public final String getMode() {
            return this.mode;
        }

        public final List<MultiTaskProjectPlateModel> getPlates() {
            return this.plates;
        }

        public final String getProfileCover() {
            return this.profileCover;
        }

        public final long getProfileId() {
            return this.profileId;
        }

        public final String getProfileName() {
            return this.profileName;
        }

        public final String getSourceFrom() {
            return this.sourceFrom;
        }

        public int hashCode() {
            int r0 = Long.hashCode(this.profileId) * 31;
            Long r2 = this.designId;
            int r3 = 0;
            if (r2 != null) goto L5;
            int r22 = 0;
        L6:
            int r02 = b0r.b((r0 + r22) * 31, 31, this.mode);
            String r23 = this.designTitle;
            if (r23 != null) goto L9;
            int r24 = 0;
        L10:
            int r03 = (r02 + r24) * 31;
            String r25 = this.profileCover;
            if (r25 != null) goto L13;
            int r26 = 0;
        L14:
            int r04 = (r03 + r26) * 31;
            String r27 = this.profileName;
            if (r27 != null) goto L17;
            int r28 = 0;
        L18:
            int r05 = (r04 + r28) * 31;
            String r29 = this.sourceFrom;
            if (r29 != null) goto L21;
            int r210 = 0;
        L22:
            int r06 = (r05 + r210) * 31;
            String r211 = this.bizType;
            if (r211 != null) goto L25;
            int r212 = 0;
        L26:
            int r07 = (r06 + r212) * 31;
            String r213 = this.bizKey;
            if (r213 != null) goto L29;
            int r214 = 0;
        L30:
            int r08 = (r07 + r214) * 31;
            String r215 = this.initialDeviceId;
            if (r215 == null) goto L35;
            r3 = r215.hashCode();
        L35:
            return this.plates.hashCode() + kn2.b(kn2.b((r08 + r3) * 31, 31, this.deviceIds), 31, this.compatibleModelNames);
        L29:
            r214 = r213.hashCode();
            goto L30
        L25:
            r212 = r211.hashCode();
            goto L26
        L21:
            r210 = r29.hashCode();
            goto L22
        L17:
            r28 = r27.hashCode();
            goto L18
        L13:
            r26 = r25.hashCode();
            goto L14
        L9:
            r24 = r23.hashCode();
            goto L10
        L5:
            r22 = r2.hashCode();
            goto L6
        }

        public String toString() {
            long r0 = this.profileId;
            Long r2 = this.designId;
            String r3 = this.mode;
            String r4 = this.designTitle;
            String r5 = this.profileCover;
            String r6 = this.profileName;
            String r7 = this.sourceFrom;
            String r8 = this.bizType;
            String r9 = this.bizKey;
            String r10 = this.initialDeviceId;
            List<String> r11 = this.deviceIds;
            List<String> r12 = this.compatibleModelNames;
            List<MultiTaskProjectPlateModel> r15 = this.plates;
            StringBuilder r13 = new StringBuilder("AddToQueue(profileId=");
            r13.append(r0);
            r13.append(", designId=");
            r13.append(r2);
            r77.C(r13, ", mode=", r3, ", designTitle=", r4);
            r77.C(r13, ", profileCover=", r5, ", profileName=", r6);
            r77.C(r13, ", sourceFrom=", r7, ", bizType=", r8);
            r77.C(r13, ", bizKey=", r9, ", initialDeviceId=", r10);
            r13.append(", deviceIds=");
            r13.append(r11);
            r13.append(", compatibleModelNames=");
            r13.append(r12);
            r13.append(", plates=");
            r13.append(r15);
            r13.append(")");
            return r13.toString();
        }
    }

    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\b\b\u0087\b\u0018\u0000 \"2\u00020\u0001:\u0002#$B\u0011\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005B#\b\u0010\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u0004\u0010\nJ'\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u000b\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000eH\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0014\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0014\u0010\u0015J\u001a\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0019\u001a\u00020\u0018HÖ\u0001¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u001b\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u001b\u0010\u001cJ\u001a\u0010\u001f\u001a\u00020\u00022\b\u0010\u001e\u001a\u0004\u0018\u00010\u001dHÖ\u0003¢\u0006\u0004\b\u001f\u0010 R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010!\u001a\u0004\b\u0003\u0010\u0015¨\u0006%"}, d2 = {"Lcom/bambulab/bambulab/navigation/route/HomeAppRoute$AllModel;", "Lcom/bambulab/bambulab/navigation/route/HomeAppRoute;", "", "is2DModel", "<init>", "(Z)V", "", "seen0", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "serializationConstructorMarker", "(IZLkotlinx/serialization/internal/SerializationConstructorMarker;)V", "self", "Lkotlinx/serialization/encoding/CompositeEncoder;", "output", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "serialDesc", "Ltrs;", "write$Self$navigation", "(Lcom/bambulab/bambulab/navigation/route/HomeAppRoute$AllModel;Lkotlinx/serialization/encoding/CompositeEncoder;Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "write$Self", "component1", "()Z", "copy", "(Z)Lcom/bambulab/bambulab/navigation/route/HomeAppRoute$AllModel;", "", "toString", "()Ljava/lang/String;", "hashCode", "()I", "", Request.JsonKeys.OTHER, "equals", "(Ljava/lang/Object;)Z", "Z", "Companion", "com/bambulab/bambulab/navigation/route/r5", "com/bambulab/bambulab/navigation/route/s5", "navigation"}, k = 1, mv = {2, 4, 0}, xi = 48)
    @Serializable
    public static final class AllModel implements HomeAppRoute {
        public static final int $stable = 0;
        public static final s5 Companion = null;
        private final boolean is2DModel;

        static {
            Companion = new s5();
        }

        public AllModel() {
            boolean r2 = false;
            this(r2, 1, null);
        }

        public /* synthetic */ AllModel(int r1, boolean r2, SerializationConstructorMarker r3) {
            if ((r1 & 1) != 0) goto L6;
            this.is2DModel = false;
            return;
        L6:
            this.is2DModel = r2;
        }

        public AllModel(boolean r1) {
            this.is2DModel = r1;
        }

        public /* synthetic */ AllModel(boolean r1, int r2, DefaultConstructorMarker r3) {
            if ((r2 & 1) == 0) goto L5;
            r1 = false;
        L5:
            this(r1);
        }

        public static /* synthetic */ AllModel copy$default(AllModel r0, boolean r1, int r2, Object r3) {
            if ((r2 & 1) == 0) goto L6;
            r1 = r0.is2DModel;
        L6:
            return r0.copy(r1);
        }

        @o0g
        public static final /* synthetic */ void write$Self$navigation(AllModel r2, CompositeEncoder r3, SerialDescriptor r4) {
            if (r3.shouldEncodeElementDefault(r4, 0) == false) goto L6;
        L7:
            r3.encodeBooleanElement(r4, 0, r2.is2DModel);
            return;
        L6:
            if (r2.is2DModel == true) goto L7;
        }

        public final boolean component1() {
            return this.is2DModel;
        }

        public final AllModel copy(boolean r1) {
            return new AllModel(r1);
        }

        public boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof AllModel) == true) goto L9;
            return false;
        L9:
            if (this.is2DModel == ((AllModel) r4).is2DModel) goto L11;
            return false;
        L11:
            return true;
        }

        public int hashCode() {
            return Boolean.hashCode(this.is2DModel);
        }

        public final boolean is2DModel() {
            return this.is2DModel;
        }

        public String toString() {
            return t4m.k("AllModel(is2DModel=", ")", this.is2DModel);
        }
    }

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0083\u0004J\n\u0010\b\u001a\u00020\tHÖ\u0081\u0004J\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00000\u000bJ\n\u0010\f\u001a\u00020\rHÖ\u0081\u0004Ê\u0001\u0002\b\u000fÊ\u0001\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\u0003\u0010\u0002¨\u0006\u000e"}, d2 = {"Lcom/bambulab/bambulab/navigation/route/HomeAppRoute$ChooseAitUser;", "Lcom/bambulab/bambulab/navigation/route/HomeAppRoute;", "<init>", "()V", "equals", "", Request.JsonKeys.OTHER, "", "hashCode", "", "serializer", "Lkotlinx/serialization/KSerializer;", "toString", "", "navigation", "Lkotlinx/serialization/Serializable;", "Landroidx/compose/runtime/internal/StabilityInferred;", PushConstants.PARAMS}, k = 1, mv = {2, 4, 0}, xi = 48)
    @Serializable
    public static final class ChooseAitUser implements HomeAppRoute {
        private static final /* synthetic */ Lazy<KSerializer<Object>> $cachedSerializer$delegate = null;
        public static final int $stable = 0;
        public static final ChooseAitUser INSTANCE = null;

        static {
            INSTANCE = new ChooseAitUser();
            acd r0 = new acd(24);
            $cachedSerializer$delegate = z86.y(lkg.b, r0);
        }

        private ChooseAitUser() {
        }

        private static final /* synthetic */ KSerializer _init_$_anonymous_() {
            return new ObjectSerializer("com.bambulab.bambulab.navigation.route.HomeAppRoute.ChooseAitUser", INSTANCE, new Annotation[0]);
        }

        public static /* synthetic */ KSerializer a() {
            return _init_$_anonymous_();
        }

        private final /* synthetic */ KSerializer get$cachedSerializer() {
            return (KSerializer) $cachedSerializer$delegate.getValue();
        }

        public boolean equals(Object r2) {
            if (this != r2) goto L6;
            return true;
        L6:
            if ((r2 instanceof ChooseAitUser) == true) goto L9;
            return false;
        L9:
            return true;
        }

        public int hashCode() {
            return 420316043;
        }

        public final KSerializer<ChooseAitUser> serializer() {
            return get$cachedSerializer();
        }

        public String toString() {
            return "ChooseAitUser";
        }
    }

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0083\u0004J\n\u0010\b\u001a\u00020\tHÖ\u0081\u0004J\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00000\u000bJ\n\u0010\f\u001a\u00020\rHÖ\u0081\u0004Ê\u0001\u0002\b\u000fÊ\u0001\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\u0003\u0010\u0002¨\u0006\u000e"}, d2 = {"Lcom/bambulab/bambulab/navigation/route/HomeAppRoute$ChooseTopic;", "Lcom/bambulab/bambulab/navigation/route/HomeAppRoute;", "<init>", "()V", "equals", "", Request.JsonKeys.OTHER, "", "hashCode", "", "serializer", "Lkotlinx/serialization/KSerializer;", "toString", "", "navigation", "Lkotlinx/serialization/Serializable;", "Landroidx/compose/runtime/internal/StabilityInferred;", PushConstants.PARAMS}, k = 1, mv = {2, 4, 0}, xi = 48)
    @Serializable
    public static final class ChooseTopic implements HomeAppRoute {
        private static final /* synthetic */ Lazy<KSerializer<Object>> $cachedSerializer$delegate = null;
        public static final int $stable = 0;
        public static final ChooseTopic INSTANCE = null;

        static {
            INSTANCE = new ChooseTopic();
            acd r0 = new acd(25);
            $cachedSerializer$delegate = z86.y(lkg.b, r0);
        }

        private ChooseTopic() {
        }

        private static final /* synthetic */ KSerializer _init_$_anonymous_() {
            return new ObjectSerializer("com.bambulab.bambulab.navigation.route.HomeAppRoute.ChooseTopic", INSTANCE, new Annotation[0]);
        }

        public static /* synthetic */ KSerializer a() {
            return _init_$_anonymous_();
        }

        private final /* synthetic */ KSerializer get$cachedSerializer() {
            return (KSerializer) $cachedSerializer$delegate.getValue();
        }

        public boolean equals(Object r2) {
            if (this != r2) goto L6;
            return true;
        L6:
            if ((r2 instanceof ChooseTopic) == true) goto L9;
            return false;
        L9:
            return true;
        }

        public int hashCode() {
            return -98041213;
        }

        public final KSerializer<ChooseTopic> serializer() {
            return get$cachedSerializer();
        }

        public String toString() {
            return "ChooseTopic";
        }
    }

    @Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\b\u0087\b\u0018\u0000 $2\u00020\u0001:\u0002%&B\u0011\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005B#\b\u0010\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u0004\u0010\nJ'\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u000b\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000eH\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0014\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0014\u0010\u0015J\u001a\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0019\u001a\u00020\u0018HÖ\u0001¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u001b\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u001b\u0010\u001cJ\u001a\u0010 \u001a\u00020\u001f2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001dHÖ\u0003¢\u0006\u0004\b \u0010!R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\"\u001a\u0004\b#\u0010\u0015¨\u0006'"}, d2 = {"Lcom/bambulab/bambulab/navigation/route/HomeAppRoute$Community;", "Lcom/bambulab/bambulab/navigation/route/HomeAppRoute;", "", "entryNonce", "<init>", "(J)V", "", "seen0", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "serializationConstructorMarker", "(IJLkotlinx/serialization/internal/SerializationConstructorMarker;)V", "self", "Lkotlinx/serialization/encoding/CompositeEncoder;", "output", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "serialDesc", "Ltrs;", "write$Self$navigation", "(Lcom/bambulab/bambulab/navigation/route/HomeAppRoute$Community;Lkotlinx/serialization/encoding/CompositeEncoder;Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "write$Self", "component1", "()J", "copy", "(J)Lcom/bambulab/bambulab/navigation/route/HomeAppRoute$Community;", "", "toString", "()Ljava/lang/String;", "hashCode", "()I", "", Request.JsonKeys.OTHER, "", "equals", "(Ljava/lang/Object;)Z", "J", "getEntryNonce", "Companion", "com/bambulab/bambulab/navigation/route/t5", "com/bambulab/bambulab/navigation/route/u5", "navigation"}, k = 1, mv = {2, 4, 0}, xi = 48)
    @Serializable
    public static final class Community implements HomeAppRoute {
        public static final int $stable = 0;
        public static final u5 Companion = null;
        private final long entryNonce;

        static {
            Companion = new u5();
        }

        public Community() {
            long r2 = 0;
            this(r2, 1, null);
        }

        public /* synthetic */ Community(int r1, long r2, SerializationConstructorMarker r4) {
            if ((r1 & 1) != 0) goto L6;
            this.entryNonce = 0;
            return;
        L6:
            this.entryNonce = r2;
        }

        public Community(long r1) {
            this.entryNonce = r1;
        }

        public /* synthetic */ Community(long r1, int r3, DefaultConstructorMarker r4) {
            if ((r3 & 1) == 0) goto L5;
            r1 = 0;
        L5:
            this(r1);
        }

        public static /* synthetic */ Community copy$default(Community r0, long r1, int r3, Object r4) {
            if ((r3 & 1) == 0) goto L6;
            r1 = r0.entryNonce;
        L6:
            return r0.copy(r1);
        }

        @o0g
        public static final /* synthetic */ void write$Self$navigation(Community r5, CompositeEncoder r6, SerialDescriptor r7) {
            if (r6.shouldEncodeElementDefault(r7, 0) == false) goto L6;
        L7:
            r6.encodeLongElement(r7, 0, r5.entryNonce);
            return;
        L6:
            if (r5.entryNonce != 0) goto L7;
        }

        public final long component1() {
            return this.entryNonce;
        }

        public final Community copy(long r1) {
            return new Community(r1);
        }

        public boolean equals(Object r6) {
            if (this != r6) goto L6;
            return true;
        L6:
            if ((r6 instanceof Community) == true) goto L9;
            return false;
        L9:
            if (this.entryNonce == ((Community) r6).entryNonce) goto L11;
            return false;
        L11:
            return true;
        }

        public final long getEntryNonce() {
            return this.entryNonce;
        }

        public int hashCode() {
            return Long.hashCode(this.entryNonce);
        }

        public String toString() {
            return r77.l(this.entryNonce, "Community(entryNonce=", ")");
        }
    }

    @Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0087\b\u0018\u0000 +2\u00020\u0001:\u0002,-B'\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bB7\b\u0010\u0012\u0006\u0010\n\u001a\u00020\t\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\u0007\u0010\rJ'\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u000e\u001a\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0011H\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u0012\u0010\u0017\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0019\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0019\u0010\u0018J\u0010\u0010\u001a\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u001a\u0010\u001bJ0\u0010\u001c\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u001e\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u001e\u0010\u0018J\u0010\u0010\u001f\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\u001f\u0010 J\u001a\u0010$\u001a\u00020#2\b\u0010\"\u001a\u0004\u0018\u00010!HÖ\u0003¢\u0006\u0004\b$\u0010%R\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010&\u001a\u0004\b'\u0010\u0018R\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010&\u001a\u0004\b(\u0010\u0018R\u0017\u0010\u0006\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010)\u001a\u0004\b*\u0010\u001b¨\u0006."}, d2 = {"Lcom/bambulab/bambulab/navigation/route/HomeAppRoute$CommunitySearch;", "Lcom/bambulab/bambulab/navigation/route/HomeAppRoute;", "", "tagName", "searchResult", "", "entryNonce", "<init>", "(Ljava/lang/String;Ljava/lang/String;J)V", "", "seen0", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "serializationConstructorMarker", "(ILjava/lang/String;Ljava/lang/String;JLkotlinx/serialization/internal/SerializationConstructorMarker;)V", "self", "Lkotlinx/serialization/encoding/CompositeEncoder;", "output", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "serialDesc", "Ltrs;", "write$Self$navigation", "(Lcom/bambulab/bambulab/navigation/route/HomeAppRoute$CommunitySearch;Lkotlinx/serialization/encoding/CompositeEncoder;Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "write$Self", "component1", "()Ljava/lang/String;", "component2", "component3", "()J", "copy", "(Ljava/lang/String;Ljava/lang/String;J)Lcom/bambulab/bambulab/navigation/route/HomeAppRoute$CommunitySearch;", "toString", "hashCode", "()I", "", Request.JsonKeys.OTHER, "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getTagName", "getSearchResult", "J", "getEntryNonce", "Companion", "com/bambulab/bambulab/navigation/route/v5", "com/bambulab/bambulab/navigation/route/w5", "navigation"}, k = 1, mv = {2, 4, 0}, xi = 48)
    @Serializable
    public static final class CommunitySearch implements HomeAppRoute {
        public static final int $stable = 0;
        public static final w5 Companion = null;
        private final long entryNonce;
        private final String searchResult;
        private final String tagName;

        static {
            Companion = new w5();
        }

        public CommunitySearch() {
            String r1 = null;
            String r2 = null;
            long r3 = 0;
            this(r1, r2, r3, 7, null);
        }

        public /* synthetic */ CommunitySearch(int r1, String r2, String r3, long r4, SerializationConstructorMarker r6) {
            if ((r1 & 1) != 0) goto L5;
            r2 = null;
        L5:
            this.tagName = r2;
            if ((r1 & 2) != 0) goto L8;
            this.searchResult = "";
        L10:
            if ((r1 & 4) != 0) goto L13;
            this.entryNonce = 0;
            return;
        L13:
            this.entryNonce = r4;
            return;
        L8:
            this.searchResult = r3;
            goto L10
        }

        public CommunitySearch(String r1, String r2, long r3) {
            r2.getClass();
            this.tagName = r1;
            this.searchResult = r2;
            this.entryNonce = r3;
        }

        public /* synthetic */ CommunitySearch(String r1, String r2, long r3, int r5, DefaultConstructorMarker r6) {
            if ((r5 & 1) == 0) goto L6;
            r1 = null;
        L6:
            if ((r5 & 2) == 0) goto L9;
            r2 = "";
        L9:
            if ((r5 & 4) == 0) goto L11;
            r3 = 0;
        L11:
            this(r1, r2, r3);
        }

        public static /* synthetic */ CommunitySearch copy$default(CommunitySearch r0, String r1, String r2, long r3, int r5, Object r6) {
            if ((r5 & 1) == 0) goto L6;
            r1 = r0.tagName;
        L6:
            if ((r5 & 2) == 0) goto L9;
            r2 = r0.searchResult;
        L9:
            if ((r5 & 4) == 0) goto L12;
            r3 = r0.entryNonce;
        L12:
            return r0.copy(r1, r2, r3);
        }

        @o0g
        public static final /* synthetic */ void write$Self$navigation(CommunitySearch r5, CompositeEncoder r6, SerialDescriptor r7) {
            if (r6.shouldEncodeElementDefault(r7, 0) == false) goto L6;
        L7:
            r6.encodeNullableSerializableElement(r7, 0, StringSerializer.INSTANCE, r5.tagName);
        L9:
            if (r6.shouldEncodeElementDefault(r7, 1) == false) goto L12;
        L13:
            r6.encodeStringElement(r7, 1, r5.searchResult);
        L15:
            if (r6.shouldEncodeElementDefault(r7, 2) == false) goto L18;
        L19:
            r6.encodeLongElement(r7, 2, r5.entryNonce);
            return;
        L18:
            if (r5.entryNonce != 0) goto L19;
            return;
        L12:
            if (lsf.l(r5.searchResult, "") == true) goto L15;
        L6:
            if (r5.tagName == null) goto L9;
            goto L7
        }

        public final String component1() {
            return this.tagName;
        }

        public final String component2() {
            return this.searchResult;
        }

        public final long component3() {
            return this.entryNonce;
        }

        public final CommunitySearch copy(String r1, String r2, long r3) {
            r2.getClass();
            return new CommunitySearch(r1, r2, r3);
        }

        public boolean equals(Object r6) {
            if (this != r6) goto L6;
            return true;
        L6:
            if ((r6 instanceof CommunitySearch) == true) goto L8;
            return false;
        L8:
            CommunitySearch r62 = (CommunitySearch) r6;
            if (lsf.l(this.tagName, r62.tagName) == true) goto L12;
            return false;
        L12:
            if (lsf.l(this.searchResult, r62.searchResult) == true) goto L15;
            return false;
        L15:
            if (this.entryNonce == r62.entryNonce) goto L17;
            return false;
        L17:
            return true;
        }

        public final long getEntryNonce() {
            return this.entryNonce;
        }

        public final String getSearchResult() {
            return this.searchResult;
        }

        public final String getTagName() {
            return this.tagName;
        }

        public int hashCode() {
            String r0 = this.tagName;
            if (r0 != null) goto L5;
            int r02 = 0;
        L6:
            int r03 = b0r.b(r02 * 31, 31, this.searchResult);
            return Long.hashCode(this.entryNonce) + r03;
        L5:
            r02 = r0.hashCode();
            goto L6
        }

        public String toString() {
            String r0 = this.tagName;
            String r1 = this.searchResult;
            return dgh.h(this.entryNonce, ")", kn2.v("CommunitySearch(tagName=", r0, ", searchResult=", r1, ", entryNonce="));
        }
    }

    @Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\b\u0087\b\u0018\u0000 (2\u00020\u0001:\u0002)*B\u001b\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007B-\b\u0010\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u0006\u0010\fJ'\u0010\u0015\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0010H\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0016\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0016\u0010\u0017J\u0012\u0010\u0018\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0004\b\u0018\u0010\u0019J&\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004HÆ\u0001¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u001c\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\u001c\u0010\u0019J\u0010\u0010\u001d\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\u001d\u0010\u001eJ\u001a\u0010\"\u001a\u00020!2\b\u0010 \u001a\u0004\u0018\u00010\u001fHÖ\u0003¢\u0006\u0004\b\"\u0010#R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010$\u001a\u0004\b%\u0010\u0017R\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010&\u001a\u0004\b'\u0010\u0019¨\u0006+"}, d2 = {"Lcom/bambulab/bambulab/navigation/route/HomeAppRoute$ContestDetail;", "Lcom/bambulab/bambulab/navigation/route/HomeAppRoute;", "", "contestId", "", "trafficSource", "<init>", "(JLjava/lang/String;)V", "", "seen0", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "serializationConstructorMarker", "(IJLjava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "self", "Lkotlinx/serialization/encoding/CompositeEncoder;", "output", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "serialDesc", "Ltrs;", "write$Self$navigation", "(Lcom/bambulab/bambulab/navigation/route/HomeAppRoute$ContestDetail;Lkotlinx/serialization/encoding/CompositeEncoder;Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "write$Self", "component1", "()J", "component2", "()Ljava/lang/String;", "copy", "(JLjava/lang/String;)Lcom/bambulab/bambulab/navigation/route/HomeAppRoute$ContestDetail;", "toString", "hashCode", "()I", "", Request.JsonKeys.OTHER, "", "equals", "(Ljava/lang/Object;)Z", "J", "getContestId", "Ljava/lang/String;", "getTrafficSource", "Companion", "com/bambulab/bambulab/navigation/route/y5", "com/bambulab/bambulab/navigation/route/z5", "navigation"}, k = 1, mv = {2, 4, 0}, xi = 48)
    @Serializable
    public static final class ContestDetail implements HomeAppRoute {
        public static final int $stable = 0;
        public static final z5 Companion = null;
        private final long contestId;
        private final String trafficSource;

        static {
            Companion = new z5();
        }

        public /* synthetic */ ContestDetail(int r2, long r3, String r5, SerializationConstructorMarker r6) {
            if (1 == (r2 & 1)) goto L5;
            PluginExceptionsKt.throwMissingFieldException(r2, 1, y5.a.getDescriptor());
        L5:
            this.contestId = r3;
            if ((r2 & 2) != 0) goto L9;
            this.trafficSource = null;
            return;
        L9:
            this.trafficSource = r5;
        }

        public ContestDetail(long r1, String r3) {
            this.contestId = r1;
            this.trafficSource = r3;
        }

        public /* synthetic */ ContestDetail(long r1, String r3, int r4, DefaultConstructorMarker r5) {
            if ((r4 & 2) == 0) goto L5;
            r3 = null;
        L5:
            this(r1, r3);
        }

        public static /* synthetic */ ContestDetail copy$default(ContestDetail r0, long r1, String r3, int r4, Object r5) {
            if ((r4 & 1) == 0) goto L6;
            r1 = r0.contestId;
        L6:
            if ((r4 & 2) == 0) goto L9;
            r3 = r0.trafficSource;
        L9:
            return r0.copy(r1, r3);
        }

        @o0g
        public static final /* synthetic */ void write$Self$navigation(ContestDetail r3, CompositeEncoder r4, SerialDescriptor r5) {
            r4.encodeLongElement(r5, 0, r3.contestId);
            if (r4.shouldEncodeElementDefault(r5, 1) == false) goto L6;
        L7:
            r4.encodeNullableSerializableElement(r5, 1, StringSerializer.INSTANCE, r3.trafficSource);
            return;
        L6:
            if (r3.trafficSource != null) goto L7;
        }

        public final long component1() {
            return this.contestId;
        }

        public final String component2() {
            return this.trafficSource;
        }

        public final ContestDetail copy(long r1, String r3) {
            return new ContestDetail(r1, r3);
        }

        public boolean equals(Object r8) {
            if (this != r8) goto L6;
            return true;
        L6:
            if ((r8 instanceof ContestDetail) == true) goto L8;
            return false;
        L8:
            ContestDetail r82 = (ContestDetail) r8;
            if (this.contestId == r82.contestId) goto L12;
            return false;
        L12:
            if (lsf.l(this.trafficSource, r82.trafficSource) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final long getContestId() {
            return this.contestId;
        }

        public final String getTrafficSource() {
            return this.trafficSource;
        }

        public int hashCode() {
            int r0 = Long.hashCode(this.contestId) * 31;
            String r2 = this.trafficSource;
            if (r2 != null) goto L5;
            int r22 = 0;
        L7:
            return r0 + r22;
        L5:
            r22 = r2.hashCode();
            goto L7
        }

        public String toString() {
            StringBuilder r4 = i3e.j(this.contestId, "ContestDetail(contestId=", ", trafficSource=", this.trafficSource);
            r4.append(")");
            return r4.toString();
        }
    }

    @Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\b\u0087\b\u0018\u0000 $2\u00020\u0001:\u0002%&B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005B#\b\u0010\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u0004\u0010\nJ'\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u000b\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000eH\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0014\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0014\u0010\u0015J\u001a\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0019\u001a\u00020\u0018HÖ\u0001¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u001b\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u001b\u0010\u001cJ\u001a\u0010 \u001a\u00020\u001f2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001dHÖ\u0003¢\u0006\u0004\b \u0010!R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\"\u001a\u0004\b#\u0010\u0015¨\u0006'"}, d2 = {"Lcom/bambulab/bambulab/navigation/route/HomeAppRoute$ContestMyEntries;", "Lcom/bambulab/bambulab/navigation/route/HomeAppRoute;", "", "contestId", "<init>", "(J)V", "", "seen0", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "serializationConstructorMarker", "(IJLkotlinx/serialization/internal/SerializationConstructorMarker;)V", "self", "Lkotlinx/serialization/encoding/CompositeEncoder;", "output", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "serialDesc", "Ltrs;", "write$Self$navigation", "(Lcom/bambulab/bambulab/navigation/route/HomeAppRoute$ContestMyEntries;Lkotlinx/serialization/encoding/CompositeEncoder;Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "write$Self", "component1", "()J", "copy", "(J)Lcom/bambulab/bambulab/navigation/route/HomeAppRoute$ContestMyEntries;", "", "toString", "()Ljava/lang/String;", "hashCode", "()I", "", Request.JsonKeys.OTHER, "", "equals", "(Ljava/lang/Object;)Z", "J", "getContestId", "Companion", "com/bambulab/bambulab/navigation/route/a6", "com/bambulab/bambulab/navigation/route/b6", "navigation"}, k = 1, mv = {2, 4, 0}, xi = 48)
    @Serializable
    public static final class ContestMyEntries implements HomeAppRoute {
        public static final int $stable = 0;
        public static final b6 Companion = null;
        private final long contestId;

        static {
            Companion = new b6();
        }

        public /* synthetic */ ContestMyEntries(int r2, long r3, SerializationConstructorMarker r5) {
            if (1 == (r2 & 1)) goto L5;
            PluginExceptionsKt.throwMissingFieldException(r2, 1, a6.a.getDescriptor());
        L5:
            this.contestId = r3;
        }

        public ContestMyEntries(long r1) {
            this.contestId = r1;
        }

        public static /* synthetic */ ContestMyEntries copy$default(ContestMyEntries r0, long r1, int r3, Object r4) {
            if ((r3 & 1) == 0) goto L6;
            r1 = r0.contestId;
        L6:
            return r0.copy(r1);
        }

        @o0g
        public static final /* synthetic */ void write$Self$navigation(ContestMyEntries r3, CompositeEncoder r4, SerialDescriptor r5) {
            r4.encodeLongElement(r5, 0, r3.contestId);
        }

        public final long component1() {
            return this.contestId;
        }

        public final ContestMyEntries copy(long r1) {
            return new ContestMyEntries(r1);
        }

        public boolean equals(Object r6) {
            if (this != r6) goto L6;
            return true;
        L6:
            if ((r6 instanceof ContestMyEntries) == true) goto L9;
            return false;
        L9:
            if (this.contestId == ((ContestMyEntries) r6).contestId) goto L11;
            return false;
        L11:
            return true;
        }

        public final long getContestId() {
            return this.contestId;
        }

        public int hashCode() {
            return Long.hashCode(this.contestId);
        }

        public String toString() {
            return r77.l(this.contestId, "ContestMyEntries(contestId=", ")");
        }
    }

    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\b\u0087\b\u0018\u0000 %2\u00020\u0001:\u0002&'B\u001b\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006B/\b\u0010\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\n\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u0005\u0010\u000bJ'\u0010\u0014\u001a\u00020\u00112\u0006\u0010\f\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000fH\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0015\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0017\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0017\u0010\u0016J$\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u001a\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u001a\u0010\u0016J\u0010\u0010\u001b\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b\u001b\u0010\u001cJ\u001a\u0010 \u001a\u00020\u001f2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001dHÖ\u0003¢\u0006\u0004\b \u0010!R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\"\u001a\u0004\b#\u0010\u0016R\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\"\u001a\u0004\b$\u0010\u0016¨\u0006("}, d2 = {"Lcom/bambulab/bambulab/navigation/route/HomeAppRoute$ContestPreDetail;", "Lcom/bambulab/bambulab/navigation/route/HomeAppRoute;", "", "themeDesc", "rewardDesc", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "", "seen0", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "serializationConstructorMarker", "(ILjava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "self", "Lkotlinx/serialization/encoding/CompositeEncoder;", "output", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "serialDesc", "Ltrs;", "write$Self$navigation", "(Lcom/bambulab/bambulab/navigation/route/HomeAppRoute$ContestPreDetail;Lkotlinx/serialization/encoding/CompositeEncoder;Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "write$Self", "component1", "()Ljava/lang/String;", "component2", "copy", "(Ljava/lang/String;Ljava/lang/String;)Lcom/bambulab/bambulab/navigation/route/HomeAppRoute$ContestPreDetail;", "toString", "hashCode", "()I", "", Request.JsonKeys.OTHER, "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getThemeDesc", "getRewardDesc", "Companion", "com/bambulab/bambulab/navigation/route/c6", "com/bambulab/bambulab/navigation/route/d6", "navigation"}, k = 1, mv = {2, 4, 0}, xi = 48)
    @Serializable
    public static final class ContestPreDetail implements HomeAppRoute {
        public static final int $stable = 0;
        public static final d6 Companion = null;
        private final String rewardDesc;
        private final String themeDesc;

        static {
            Companion = new d6();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public ContestPreDetail() {
            Object[] r0 = 0 == true ? 1 : 0;
            this(null, r0, 3, 0 == true ? 1 : 0);
        }

        public /* synthetic */ ContestPreDetail(int r2, String r3, String r4, SerializationConstructorMarker r5) {
            if ((r2 & 1) != 0) goto L5;
            this.themeDesc = "";
        L7:
            if ((r2 & 2) != 0) goto L10;
            this.rewardDesc = "";
            return;
        L10:
            this.rewardDesc = r4;
            return;
        L5:
            this.themeDesc = r3;
            goto L7
        }

        public ContestPreDetail(String r1, String r2) {
            r1.getClass();
            r2.getClass();
            this.themeDesc = r1;
            this.rewardDesc = r2;
        }

        public /* synthetic */ ContestPreDetail(String r2, String r3, int r4, DefaultConstructorMarker r5) {
            if ((r4 & 1) == 0) goto L6;
            r2 = "";
        L6:
            if ((r4 & 2) == 0) goto L8;
            r3 = "";
        L8:
            this(r2, r3);
        }

        public static /* synthetic */ ContestPreDetail copy$default(ContestPreDetail r0, String r1, String r2, int r3, Object r4) {
            if ((r3 & 1) == 0) goto L6;
            r1 = r0.themeDesc;
        L6:
            if ((r3 & 2) == 0) goto L9;
            r2 = r0.rewardDesc;
        L9:
            return r0.copy(r1, r2);
        }

        @o0g
        public static final /* synthetic */ void write$Self$navigation(ContestPreDetail r3, CompositeEncoder r4, SerialDescriptor r5) {
            if (r4.shouldEncodeElementDefault(r5, 0) == false) goto L6;
        L7:
            r4.encodeStringElement(r5, 0, r3.themeDesc);
        L9:
            if (r4.shouldEncodeElementDefault(r5, 1) == false) goto L12;
        L13:
            r4.encodeStringElement(r5, 1, r3.rewardDesc);
            return;
        L12:
            if (lsf.l(r3.rewardDesc, "") == false) goto L13;
            return;
        L6:
            if (lsf.l(r3.themeDesc, "") == true) goto L9;
            goto L7
        }

        public final String component1() {
            return this.themeDesc;
        }

        public final String component2() {
            return this.rewardDesc;
        }

        public final ContestPreDetail copy(String r1, String r2) {
            r1.getClass();
            r2.getClass();
            return new ContestPreDetail(r1, r2);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof ContestPreDetail) == true) goto L8;
            return false;
        L8:
            ContestPreDetail r52 = (ContestPreDetail) r5;
            if (lsf.l(this.themeDesc, r52.themeDesc) == true) goto L12;
            return false;
        L12:
            if (lsf.l(this.rewardDesc, r52.rewardDesc) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final String getRewardDesc() {
            return this.rewardDesc;
        }

        public final String getThemeDesc() {
            return this.themeDesc;
        }

        public int hashCode() {
            int r0 = this.themeDesc.hashCode() * 31;
            return this.rewardDesc.hashCode() + r0;
        }

        public String toString() {
            return b0r.p("ContestPreDetail(themeDesc=", this.themeDesc, ", rewardDesc=", this.rewardDesc, ")");
        }
    }

    @Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\b\u0087\b\u0018\u0000 $2\u00020\u0001:\u0002%&B\u0011\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005B#\b\u0010\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u0004\u0010\nJ'\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u000b\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000eH\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0014\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0014\u0010\u0015J\u001a\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0019\u001a\u00020\u0018HÖ\u0001¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u001b\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u001b\u0010\u001cJ\u001a\u0010 \u001a\u00020\u001f2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001dHÖ\u0003¢\u0006\u0004\b \u0010!R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\"\u001a\u0004\b#\u0010\u0015¨\u0006'"}, d2 = {"Lcom/bambulab/bambulab/navigation/route/HomeAppRoute$ContestToggle;", "Lcom/bambulab/bambulab/navigation/route/HomeAppRoute;", "", "entryNonce", "<init>", "(J)V", "", "seen0", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "serializationConstructorMarker", "(IJLkotlinx/serialization/internal/SerializationConstructorMarker;)V", "self", "Lkotlinx/serialization/encoding/CompositeEncoder;", "output", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "serialDesc", "Ltrs;", "write$Self$navigation", "(Lcom/bambulab/bambulab/navigation/route/HomeAppRoute$ContestToggle;Lkotlinx/serialization/encoding/CompositeEncoder;Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "write$Self", "component1", "()J", "copy", "(J)Lcom/bambulab/bambulab/navigation/route/HomeAppRoute$ContestToggle;", "", "toString", "()Ljava/lang/String;", "hashCode", "()I", "", Request.JsonKeys.OTHER, "", "equals", "(Ljava/lang/Object;)Z", "J", "getEntryNonce", "Companion", "com/bambulab/bambulab/navigation/route/e6", "com/bambulab/bambulab/navigation/route/f6", "navigation"}, k = 1, mv = {2, 4, 0}, xi = 48)
    @Serializable
    public static final class ContestToggle implements HomeAppRoute {
        public static final int $stable = 0;
        public static final f6 Companion = null;
        private final long entryNonce;

        static {
            Companion = new f6();
        }

        public ContestToggle() {
            long r2 = 0;
            this(r2, 1, null);
        }

        public /* synthetic */ ContestToggle(int r1, long r2, SerializationConstructorMarker r4) {
            if ((r1 & 1) != 0) goto L6;
            this.entryNonce = 0;
            return;
        L6:
            this.entryNonce = r2;
        }

        public ContestToggle(long r1) {
            this.entryNonce = r1;
        }

        public /* synthetic */ ContestToggle(long r1, int r3, DefaultConstructorMarker r4) {
            if ((r3 & 1) == 0) goto L5;
            r1 = 0;
        L5:
            this(r1);
        }

        public static /* synthetic */ ContestToggle copy$default(ContestToggle r0, long r1, int r3, Object r4) {
            if ((r3 & 1) == 0) goto L6;
            r1 = r0.entryNonce;
        L6:
            return r0.copy(r1);
        }

        @o0g
        public static final /* synthetic */ void write$Self$navigation(ContestToggle r5, CompositeEncoder r6, SerialDescriptor r7) {
            if (r6.shouldEncodeElementDefault(r7, 0) == false) goto L6;
        L7:
            r6.encodeLongElement(r7, 0, r5.entryNonce);
            return;
        L6:
            if (r5.entryNonce != 0) goto L7;
        }

        public final long component1() {
            return this.entryNonce;
        }

        public final ContestToggle copy(long r1) {
            return new ContestToggle(r1);
        }

        public boolean equals(Object r6) {
            if (this != r6) goto L6;
            return true;
        L6:
            if ((r6 instanceof ContestToggle) == true) goto L9;
            return false;
        L9:
            if (this.entryNonce == ((ContestToggle) r6).entryNonce) goto L11;
            return false;
        L11:
            return true;
        }

        public final long getEntryNonce() {
            return this.entryNonce;
        }

        public int hashCode() {
            return Long.hashCode(this.entryNonce);
        }

        public String toString() {
            return r77.l(this.entryNonce, "ContestToggle(entryNonce=", ")");
        }
    }

    @Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\b\u0087\b\u0018\u0000 )2\u00020\u0001:\u0002*+B\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0007\u0010\bB5\b\u0010\u0012\u0006\u0010\n\u001a\u00020\t\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\u0007\u0010\rJ'\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u000e\u001a\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0011H\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0017\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0017\u0010\u0018J\u0016\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0003¢\u0006\u0004\b\u0019\u0010\u001aJ*\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u001d\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u001d\u0010\u0018J\u0010\u0010\u001e\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\u001e\u0010\u001fJ\u001a\u0010#\u001a\u00020\"2\b\u0010!\u001a\u0004\u0018\u00010 HÖ\u0003¢\u0006\u0004\b#\u0010$R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010%\u001a\u0004\b&\u0010\u0018R\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006¢\u0006\f\n\u0004\b\u0006\u0010'\u001a\u0004\b(\u0010\u001a¨\u0006,"}, d2 = {"Lcom/bambulab/bambulab/navigation/route/HomeAppRoute$DesignAttachmentList;", "Lcom/bambulab/bambulab/navigation/route/HomeAppRoute;", "", "title", "", "Lcom/bambulab/bambulab/model/DesignAttachment;", "attachments", "<init>", "(Ljava/lang/String;Ljava/util/List;)V", "", "seen0", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "serializationConstructorMarker", "(ILjava/lang/String;Ljava/util/List;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "self", "Lkotlinx/serialization/encoding/CompositeEncoder;", "output", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "serialDesc", "Ltrs;", "write$Self$navigation", "(Lcom/bambulab/bambulab/navigation/route/HomeAppRoute$DesignAttachmentList;Lkotlinx/serialization/encoding/CompositeEncoder;Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "write$Self", "component1", "()Ljava/lang/String;", "component2", "()Ljava/util/List;", "copy", "(Ljava/lang/String;Ljava/util/List;)Lcom/bambulab/bambulab/navigation/route/HomeAppRoute$DesignAttachmentList;", "toString", "hashCode", "()I", "", Request.JsonKeys.OTHER, "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getTitle", "Ljava/util/List;", "getAttachments", "Companion", "com/bambulab/bambulab/navigation/route/g6", "com/bambulab/bambulab/navigation/route/h6", "navigation"}, k = 1, mv = {2, 4, 0}, xi = 48)
    @Serializable
    public static final class DesignAttachmentList implements HomeAppRoute {
        private static final Lazy<KSerializer<Object>>[] $childSerializers = null;
        public static final int $stable = 8;
        public static final h6 Companion = null;
        private final List<DesignAttachment> attachments;
        private final String title;

        static {
            Companion = new h6();
            $childSerializers = new Lazy[]{null, z86.y(lkg.b, new acd(26))};
        }

        public /* synthetic */ DesignAttachmentList(int r2, String r3, List r4, SerializationConstructorMarker r5) {
            if (3 == (r2 & 3)) goto L5;
            PluginExceptionsKt.throwMissingFieldException(r2, 3, g6.a.getDescriptor());
        L5:
            this.title = r3;
            this.attachments = r4;
        }

        public DesignAttachmentList(String r1, List<DesignAttachment> r2) {
            r1.getClass();
            r2.getClass();
            this.title = r1;
            this.attachments = r2;
        }

        private static final /* synthetic */ KSerializer _childSerializers$_anonymous_() {
            return new ArrayListSerializer(DesignAttachment$$serializer.INSTANCE);
        }

        public static /* synthetic */ KSerializer a() {
            return _childSerializers$_anonymous_();
        }

        public static final /* synthetic */ Lazy[] access$get$childSerializers$cp() {
            return $childSerializers;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ DesignAttachmentList copy$default(DesignAttachmentList r0, String r1, List r2, int r3, Object r4) {
            if ((r3 & 1) == 0) goto L6;
            r1 = r0.title;
        L6:
            if ((r3 & 2) == 0) goto L9;
            r2 = r0.attachments;
        L9:
            return r0.copy(r1, r2);
        }

        @o0g
        public static final /* synthetic */ void write$Self$navigation(DesignAttachmentList r3, CompositeEncoder r4, SerialDescriptor r5) {
            Lazy<KSerializer<Object>>[] r0 = $childSerializers;
            r4.encodeStringElement(r5, 0, r3.title);
            r4.encodeSerializableElement(r5, 1, (SerializationStrategy) r0[1].getValue(), r3.attachments);
        }

        public final String component1() {
            return this.title;
        }

        public final List<DesignAttachment> component2() {
            return this.attachments;
        }

        public final DesignAttachmentList copy(String r1, List<DesignAttachment> r2) {
            r1.getClass();
            r2.getClass();
            return new DesignAttachmentList(r1, r2);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof DesignAttachmentList) == true) goto L8;
            return false;
        L8:
            DesignAttachmentList r52 = (DesignAttachmentList) r5;
            if (lsf.l(this.title, r52.title) == true) goto L12;
            return false;
        L12:
            if (lsf.l(this.attachments, r52.attachments) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final List<DesignAttachment> getAttachments() {
            return this.attachments;
        }

        public final String getTitle() {
            return this.title;
        }

        public int hashCode() {
            int r0 = this.title.hashCode() * 31;
            return this.attachments.hashCode() + r0;
        }

        public String toString() {
            return bsa.j("DesignAttachmentList(title=", this.title, ", attachments=", ")", this.attachments);
        }
    }

    @Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0016\b\u0087\b\u0018\u0000 E2\u00020\u0001:\u0002FGBs\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0002¢\u0006\u0004\b\u000f\u0010\u0010Bm\b\u0010\u0012\u0006\u0010\u0012\u001a\u00020\u0011\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013¢\u0006\u0004\b\u000f\u0010\u0015J\u0010\u0010\u0016\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0018\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0018\u0010\u0017J\u0010\u0010\u0019\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0019\u0010\u0017J\u0010\u0010\u001a\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u001a\u0010\u001bJ\u0012\u0010\u001c\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0004\b\u001c\u0010\u001dJ\u0012\u0010\u001e\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\b\u001e\u0010\u001bJ\u0012\u0010\u001f\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\b\u001f\u0010\u001bJ\u0012\u0010 \u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\b \u0010\u001bJ\u0012\u0010!\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\b!\u0010\u001bJ\u0010\u0010\"\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\"\u0010\u0017J~\u0010#\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00022\b\b\u0002\u0010\u0007\u001a\u00020\u00062\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u000e\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b#\u0010$J\u0010\u0010%\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b%\u0010\u001bJ\u0010\u0010&\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b&\u0010'J\u001a\u0010+\u001a\u00020*2\b\u0010)\u001a\u0004\u0018\u00010(HÖ\u0003¢\u0006\u0004\b+\u0010,J'\u00105\u001a\u0002022\u0006\u0010-\u001a\u00020\u00002\u0006\u0010/\u001a\u00020.2\u0006\u00101\u001a\u000200H\u0001¢\u0006\u0004\b3\u00104R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u00106\u001a\u0004\b7\u0010\u0017R\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u00106\u001a\u0004\b8\u0010\u0017R\u0017\u0010\u0005\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0005\u00106\u001a\u0004\b9\u0010\u0017R\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010:\u001a\u0004\b;\u0010\u001bR\"\u0010\t\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b\t\u0010<\u0012\u0004\b>\u0010?\u001a\u0004\b=\u0010\u001dR\u0019\u0010\n\u001a\u0004\u0018\u00010\u00068\u0006¢\u0006\f\n\u0004\b\n\u0010:\u001a\u0004\b@\u0010\u001bR\u0019\u0010\u000b\u001a\u0004\u0018\u00010\u00068\u0006¢\u0006\f\n\u0004\b\u000b\u0010:\u001a\u0004\bA\u0010\u001bR\u0019\u0010\f\u001a\u0004\u0018\u00010\u00068\u0006¢\u0006\f\n\u0004\b\f\u0010:\u001a\u0004\bB\u0010\u001bR\u0019\u0010\r\u001a\u0004\u0018\u00010\u00068\u0006¢\u0006\f\n\u0004\b\r\u0010:\u001a\u0004\bC\u0010\u001bR\u0017\u0010\u000e\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u000e\u00106\u001a\u0004\bD\u0010\u0017¨\u0006H"}, d2 = {"Lcom/bambulab/bambulab/navigation/route/HomeAppRoute$DesignDetail;", "Lcom/bambulab/bambulab/navigation/route/HomeAppRoute;", "", "designId", "ratingId", "instanceId", "", "trafficSource", "Lcom/bambulab/bambulab/model/DesignModel;", "preloadData", "pageFrom", "backendLogRef", "refreshId", "collectionFrom", "entryNonce", "<init>", "(JJJLjava/lang/String;Lcom/bambulab/bambulab/model/DesignModel;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;J)V", "", "seen0", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "serializationConstructorMarker", "(IJJJLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLkotlinx/serialization/internal/SerializationConstructorMarker;)V", "component1", "()J", "component2", "component3", "component4", "()Ljava/lang/String;", "component5", "()Lcom/bambulab/bambulab/model/DesignModel;", "component6", "component7", "component8", "component9", "component10", "copy", "(JJJLjava/lang/String;Lcom/bambulab/bambulab/model/DesignModel;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;J)Lcom/bambulab/bambulab/navigation/route/HomeAppRoute$DesignDetail;", "toString", "hashCode", "()I", "", Request.JsonKeys.OTHER, "", "equals", "(Ljava/lang/Object;)Z", "self", "Lkotlinx/serialization/encoding/CompositeEncoder;", "output", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "serialDesc", "Ltrs;", "write$Self$navigation", "(Lcom/bambulab/bambulab/navigation/route/HomeAppRoute$DesignDetail;Lkotlinx/serialization/encoding/CompositeEncoder;Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "write$Self", "J", "getDesignId", "getRatingId", "getInstanceId", "Ljava/lang/String;", "getTrafficSource", "Lcom/bambulab/bambulab/model/DesignModel;", "getPreloadData", "getPreloadData$annotations", "()V", "getPageFrom", "getBackendLogRef", "getRefreshId", "getCollectionFrom", "getEntryNonce", "Companion", "com/bambulab/bambulab/navigation/route/i6", "com/bambulab/bambulab/navigation/route/j6", "navigation"}, k = 1, mv = {2, 4, 0}, xi = 48)
    @Serializable
    public static final class DesignDetail implements HomeAppRoute {
        public static final int $stable = 8;
        public static final j6 Companion = null;
        private final String backendLogRef;
        private final String collectionFrom;
        private final long designId;
        private final long entryNonce;
        private final long instanceId;
        private final String pageFrom;
        private final DesignModel preloadData;
        private final long ratingId;
        private final String refreshId;
        private final String trafficSource;

        static {
            Companion = new j6();
        }

        public /* synthetic */ DesignDetail(int r3, long r4, long r6, long r8, String r10, String r11, String r12, String r13, String r14, long r15, SerializationConstructorMarker r17) {
            if (1 == (r3 & 1)) goto L5;
            PluginExceptionsKt.throwMissingFieldException(r3, 1, i6.a.getDescriptor());
        L5:
            this.designId = r4;
            if ((r3 & 2) != 0) goto L8;
            this.ratingId = -1;
        L10:
            if ((r3 & 4) != 0) goto L12;
            this.instanceId = -1;
        L14:
            if ((r3 & 8) != 0) goto L16;
            this.trafficSource = "";
        L17:
            this.preloadData = null;
            if ((r3 & 16) != 0) goto L20;
            this.pageFrom = null;
        L22:
            if ((r3 & 32) != 0) goto L24;
            this.backendLogRef = null;
        L26:
            if ((r3 & 64) != 0) goto L28;
            this.refreshId = null;
        L30:
            if ((r3 & 128) != 0) goto L32;
            this.collectionFrom = null;
        L34:
            if ((r3 & 256) != 0) goto L38;
            long r32 = System.nanoTime();
        L36:
            this.entryNonce = r32;
            return;
        L38:
            r32 = r15;
            goto L36
        L32:
            this.collectionFrom = r14;
            goto L34
        L28:
            this.refreshId = r13;
            goto L30
        L24:
            this.backendLogRef = r12;
            goto L26
        L20:
            this.pageFrom = r11;
            goto L22
        L16:
            this.trafficSource = r10;
            goto L17
        L12:
            this.instanceId = r8;
            goto L14
        L8:
            this.ratingId = r6;
            goto L10
        }

        public DesignDetail(long r1, long r3, long r5, String r7, DesignModel r8, String r9, String r10, String r11, String r12, long r13) {
            r7.getClass();
            this.designId = r1;
            this.ratingId = r3;
            this.instanceId = r5;
            this.trafficSource = r7;
            this.preloadData = r8;
            this.pageFrom = r9;
            this.backendLogRef = r10;
            this.refreshId = r11;
            this.collectionFrom = r12;
            this.entryNonce = r13;
        }

        public /* synthetic */ DesignDetail(long r20, long r22, long r24, String r26, DesignModel r27, String r28, String r29, String r30, String r31, long r32, int r34, DefaultConstructorMarker r35) {
            if ((r34 & 2) == 0) goto L5;
            long r7 = -1;
        L7:
            if ((r34 & 4) == 0) goto L9;
            long r9 = -1;
        L11:
            if ((r34 & 8) == 0) goto L13;
            String r11 = "";
        L15:
            if ((r34 & 16) == 0) goto L17;
            DesignModel r12 = null;
        L19:
            if ((r34 & 32) == 0) goto L21;
            String r13 = null;
        L23:
            if ((r34 & 64) == 0) goto L25;
            String r14 = null;
        L27:
            if ((r34 & 128) == 0) goto L29;
            String r15 = null;
        L31:
            if ((r34 & 256) == 0) goto L33;
            String r16 = null;
        L35:
            if ((r34 & 512) == 0) goto L38;
            long r17 = System.nanoTime();
        L39:
            this(r20, r7, r9, r11, r12, r13, r14, r15, r16, r17);
            return;
        L38:
            r17 = r32;
            goto L39
        L33:
            r16 = r31;
            goto L35
        L29:
            r15 = r30;
            goto L31
        L25:
            r14 = r29;
            goto L27
        L21:
            r13 = r28;
            goto L23
        L17:
            r12 = r27;
            goto L19
        L13:
            r11 = r26;
            goto L15
        L9:
            r9 = r24;
            goto L11
        L5:
            r7 = r22;
            goto L7
        }

        public static /* synthetic */ DesignDetail copy$default(DesignDetail r16, long r17, long r19, long r21, String r23, DesignModel r24, String r25, String r26, String r27, String r28, long r29, int r31, Object r32) {
            if ((r31 & 1) == 0) goto L5;
            long r2 = r16.designId;
        L7:
            if ((r31 & 2) == 0) goto L9;
            long r4 = r16.ratingId;
        L11:
            if ((r31 & 4) == 0) goto L13;
            long r6 = r16.instanceId;
        L15:
            if ((r31 & 8) == 0) goto L17;
            String r8 = r16.trafficSource;
        L19:
            if ((r31 & 16) == 0) goto L21;
            DesignModel r9 = r16.preloadData;
        L23:
            if ((r31 & 32) == 0) goto L25;
            String r10 = r16.pageFrom;
        L27:
            if ((r31 & 64) == 0) goto L29;
            String r11 = r16.backendLogRef;
        L31:
            if ((r31 & 128) == 0) goto L33;
            String r12 = r16.refreshId;
        L35:
            if ((r31 & 256) == 0) goto L37;
            String r13 = r16.collectionFrom;
        L39:
            if ((r31 & 512) == 0) goto L42;
            long r30 = r16.entryNonce;
        L44:
            return r16.copy(r2, r4, r6, r8, r9, r10, r11, r12, r13, r30);
        L42:
            r30 = r29;
            goto L44
        L37:
            r13 = r28;
            goto L39
        L33:
            r12 = r27;
            goto L35
        L29:
            r11 = r26;
            goto L31
        L25:
            r10 = r25;
            goto L27
        L21:
            r9 = r24;
            goto L23
        L17:
            r8 = r23;
            goto L19
        L13:
            r6 = r21;
            goto L15
        L9:
            r4 = r19;
            goto L11
        L5:
            r2 = r17;
            goto L7
        }

        @Transient
        public static /* synthetic */ void getPreloadData$annotations() {
        }

        @o0g
        public static final /* synthetic */ void write$Self$navigation(DesignDetail r6, CompositeEncoder r7, SerialDescriptor r8) {
            r7.encodeLongElement(r8, 0, r6.designId);
            if (r7.shouldEncodeElementDefault(r8, 1) == false) goto L6;
        L7:
            r7.encodeLongElement(r8, 1, r6.ratingId);
        L9:
            if (r7.shouldEncodeElementDefault(r8, 2) == false) goto L12;
        L13:
            r7.encodeLongElement(r8, 2, r6.instanceId);
        L15:
            if (r7.shouldEncodeElementDefault(r8, 3) == false) goto L18;
        L19:
            r7.encodeStringElement(r8, 3, r6.trafficSource);
        L21:
            if (r7.shouldEncodeElementDefault(r8, 4) == false) goto L24;
        L25:
            r7.encodeNullableSerializableElement(r8, 4, StringSerializer.INSTANCE, r6.pageFrom);
        L27:
            if (r7.shouldEncodeElementDefault(r8, 5) == false) goto L30;
        L31:
            r7.encodeNullableSerializableElement(r8, 5, StringSerializer.INSTANCE, r6.backendLogRef);
        L33:
            if (r7.shouldEncodeElementDefault(r8, 6) == false) goto L36;
        L37:
            r7.encodeNullableSerializableElement(r8, 6, StringSerializer.INSTANCE, r6.refreshId);
        L39:
            if (r7.shouldEncodeElementDefault(r8, 7) == false) goto L42;
        L43:
            r7.encodeNullableSerializableElement(r8, 7, StringSerializer.INSTANCE, r6.collectionFrom);
        L45:
            if (r7.shouldEncodeElementDefault(r8, 8) == false) goto L48;
        L49:
            r7.encodeLongElement(r8, 8, r6.entryNonce);
            return;
        L48:
            if (r6.entryNonce != System.nanoTime()) goto L49;
            return;
        L42:
            if (r6.collectionFrom == null) goto L45;
        L36:
            if (r6.refreshId == null) goto L39;
        L30:
            if (r6.backendLogRef == null) goto L33;
        L24:
            if (r6.pageFrom == null) goto L27;
        L18:
            if (lsf.l(r6.trafficSource, "") == true) goto L21;
        L12:
            if (r6.instanceId == (-1)) goto L15;
        L6:
            if (r6.ratingId == (-1)) goto L9;
            goto L7
        }

        public final long component1() {
            return this.designId;
        }

        public final long component10() {
            return this.entryNonce;
        }

        public final long component2() {
            return this.ratingId;
        }

        public final long component3() {
            return this.instanceId;
        }

        public final String component4() {
            return this.trafficSource;
        }

        public final DesignModel component5() {
            return this.preloadData;
        }

        public final String component6() {
            return this.pageFrom;
        }

        public final String component7() {
            return this.backendLogRef;
        }

        public final String component8() {
            return this.refreshId;
        }

        public final String component9() {
            return this.collectionFrom;
        }

        public final DesignDetail copy(long r1, long r3, long r5, String r7, DesignModel r8, String r9, String r10, String r11, String r12, long r13) {
            r7.getClass();
            return new DesignDetail(r1, r3, r5, r7, r8, r9, r10, r11, r12, r13);
        }

        public boolean equals(Object r8) {
            if (this != r8) goto L6;
            return true;
        L6:
            if ((r8 instanceof DesignDetail) == true) goto L8;
            return false;
        L8:
            DesignDetail r82 = (DesignDetail) r8;
            if (this.designId == r82.designId) goto L12;
            return false;
        L12:
            if (this.ratingId == r82.ratingId) goto L15;
            return false;
        L15:
            if (this.instanceId == r82.instanceId) goto L18;
            return false;
        L18:
            if (lsf.l(this.trafficSource, r82.trafficSource) == true) goto L21;
            return false;
        L21:
            if (lsf.l(this.preloadData, r82.preloadData) == true) goto L24;
            return false;
        L24:
            if (lsf.l(this.pageFrom, r82.pageFrom) == true) goto L27;
            return false;
        L27:
            if (lsf.l(this.backendLogRef, r82.backendLogRef) == true) goto L30;
            return false;
        L30:
            if (lsf.l(this.refreshId, r82.refreshId) == true) goto L33;
            return false;
        L33:
            if (lsf.l(this.collectionFrom, r82.collectionFrom) == true) goto L36;
            return false;
        L36:
            if (this.entryNonce == r82.entryNonce) goto L38;
            return false;
        L38:
            return true;
        }

        public final String getBackendLogRef() {
            return this.backendLogRef;
        }

        public final String getCollectionFrom() {
            return this.collectionFrom;
        }

        public final long getDesignId() {
            return this.designId;
        }

        public final long getEntryNonce() {
            return this.entryNonce;
        }

        public final long getInstanceId() {
            return this.instanceId;
        }

        public final String getPageFrom() {
            return this.pageFrom;
        }

        public final DesignModel getPreloadData() {
            return this.preloadData;
        }

        public final long getRatingId() {
            return this.ratingId;
        }

        public final String getRefreshId() {
            return this.refreshId;
        }

        public final String getTrafficSource() {
            return this.trafficSource;
        }

        public int hashCode() {
            int r0 = b0r.b(ul7.c(ul7.c(Long.hashCode(this.designId) * 31, 31, this.ratingId), 31, this.instanceId), 31, this.trafficSource);
            DesignModel r2 = this.preloadData;
            int r3 = 0;
            if (r2 != null) goto L5;
            int r22 = 0;
        L6:
            int r02 = (r0 + r22) * 31;
            String r23 = this.pageFrom;
            if (r23 != null) goto L9;
            int r24 = 0;
        L10:
            int r03 = (r02 + r24) * 31;
            String r25 = this.backendLogRef;
            if (r25 != null) goto L13;
            int r26 = 0;
        L14:
            int r04 = (r03 + r26) * 31;
            String r27 = this.refreshId;
            if (r27 != null) goto L17;
            int r28 = 0;
        L18:
            int r05 = (r04 + r28) * 31;
            String r29 = this.collectionFrom;
            if (r29 == null) goto L23;
            r3 = r29.hashCode();
        L23:
            return Long.hashCode(this.entryNonce) + ((r05 + r3) * 31);
        L17:
            r28 = r27.hashCode();
            goto L18
        L13:
            r26 = r25.hashCode();
            goto L14
        L9:
            r24 = r23.hashCode();
            goto L10
        L5:
            r22 = r2.hashCode();
            goto L6
        }

        public String toString() {
            long r0 = this.designId;
            long r2 = this.ratingId;
            long r4 = this.instanceId;
            String r6 = this.trafficSource;
            DesignModel r7 = this.preloadData;
            String r8 = this.pageFrom;
            String r9 = this.backendLogRef;
            String r10 = this.refreshId;
            String r11 = this.collectionFrom;
            long r12 = this.entryNonce;
            StringBuilder r15 = dgh.o(r0, "DesignDetail(designId=", ", ratingId=");
            r15.append(r2);
            dgh.v(r4, ", instanceId=", ", trafficSource=", r15);
            r15.append(r6);
            r15.append(", preloadData=");
            r15.append(r7);
            r15.append(", pageFrom=");
            r77.C(r15, r8, ", backendLogRef=", r9, ", refreshId=");
            r77.C(r15, r10, ", collectionFrom=", r11, ", entryNonce=");
            return dgh.h(r12, ")", r15);
        }
    }

    @Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\b\u0087\b\u0018\u0000 '2\u00020\u0001:\u0002()B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006B+\b\u0010\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\b\u0010\n\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u0005\u0010\u000bJ'\u0010\u0014\u001a\u00020\u00112\u0006\u0010\f\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000fH\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0015\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0017\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0017\u0010\u0016J$\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u001b\u001a\u00020\u001aHÖ\u0001¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u001d\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b\u001d\u0010\u001eJ\u001a\u0010\"\u001a\u00020!2\b\u0010 \u001a\u0004\u0018\u00010\u001fHÖ\u0003¢\u0006\u0004\b\"\u0010#R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010$\u001a\u0004\b%\u0010\u0016R\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010$\u001a\u0004\b&\u0010\u0016¨\u0006*"}, d2 = {"Lcom/bambulab/bambulab/navigation/route/HomeAppRoute$DesignDetail2dPlates;", "Lcom/bambulab/bambulab/navigation/route/HomeAppRoute;", "", "designId", "instanceId", "<init>", "(JJ)V", "", "seen0", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "serializationConstructorMarker", "(IJJLkotlinx/serialization/internal/SerializationConstructorMarker;)V", "self", "Lkotlinx/serialization/encoding/CompositeEncoder;", "output", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "serialDesc", "Ltrs;", "write$Self$navigation", "(Lcom/bambulab/bambulab/navigation/route/HomeAppRoute$DesignDetail2dPlates;Lkotlinx/serialization/encoding/CompositeEncoder;Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "write$Self", "component1", "()J", "component2", "copy", "(JJ)Lcom/bambulab/bambulab/navigation/route/HomeAppRoute$DesignDetail2dPlates;", "", "toString", "()Ljava/lang/String;", "hashCode", "()I", "", Request.JsonKeys.OTHER, "", "equals", "(Ljava/lang/Object;)Z", "J", "getDesignId", "getInstanceId", "Companion", "com/bambulab/bambulab/navigation/route/k6", "com/bambulab/bambulab/navigation/route/l6", "navigation"}, k = 1, mv = {2, 4, 0}, xi = 48)
    @Serializable
    public static final class DesignDetail2dPlates implements HomeAppRoute {
        public static final int $stable = 0;
        public static final l6 Companion = null;
        private final long designId;
        private final long instanceId;

        static {
            Companion = new l6();
        }

        public /* synthetic */ DesignDetail2dPlates(int r2, long r3, long r5, SerializationConstructorMarker r7) {
            if (3 == (r2 & 3)) goto L5;
            PluginExceptionsKt.throwMissingFieldException(r2, 3, k6.a.getDescriptor());
        L5:
            this.designId = r3;
            this.instanceId = r5;
        }

        public DesignDetail2dPlates(long r1, long r3) {
            this.designId = r1;
            this.instanceId = r3;
        }

        public static /* synthetic */ DesignDetail2dPlates copy$default(DesignDetail2dPlates r0, long r1, long r3, int r5, Object r6) {
            if ((r5 & 1) == 0) goto L6;
            r1 = r0.designId;
        L6:
            if ((r5 & 2) == 0) goto L9;
            r3 = r0.instanceId;
        L9:
            return r0.copy(r1, r3);
        }

        @o0g
        public static final /* synthetic */ void write$Self$navigation(DesignDetail2dPlates r3, CompositeEncoder r4, SerialDescriptor r5) {
            r4.encodeLongElement(r5, 0, r3.designId);
            r4.encodeLongElement(r5, 1, r3.instanceId);
        }

        public final long component1() {
            return this.designId;
        }

        public final long component2() {
            return this.instanceId;
        }

        public final DesignDetail2dPlates copy(long r1, long r3) {
            return new DesignDetail2dPlates(r1, r3);
        }

        public boolean equals(Object r8) {
            if (this != r8) goto L6;
            return true;
        L6:
            if ((r8 instanceof DesignDetail2dPlates) == true) goto L8;
            return false;
        L8:
            DesignDetail2dPlates r82 = (DesignDetail2dPlates) r8;
            if (this.designId == r82.designId) goto L12;
            return false;
        L12:
            if (this.instanceId == r82.instanceId) goto L14;
            return false;
        L14:
            return true;
        }

        public final long getDesignId() {
            return this.designId;
        }

        public final long getInstanceId() {
            return this.instanceId;
        }

        public int hashCode() {
            int r0 = Long.hashCode(this.designId) * 31;
            return Long.hashCode(this.instanceId) + r0;
        }

        public String toString() {
            long r0 = this.designId;
            return dgh.h(this.instanceId, ")", dgh.o(r0, "DesignDetail2dPlates(designId=", ", instanceId="));
        }
    }

    @Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u0000\n\u0002\b\r\b\u0087\b\u0018\u0000 -2\u00020\u0001:\u0002./B%\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\b\u0010\tB5\b\u0010\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\r\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\b\u0010\u000eJ'\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u000f\u001a\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0012H\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0018\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u001a\u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b\u001a\u0010\u001bJ\u0012\u0010\u001c\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\b\u001c\u0010\u001dJ0\u0010\u001e\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010 \u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b \u0010\u001dJ\u0010\u0010!\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b!\u0010\"J\u001a\u0010%\u001a\u00020\u00042\b\u0010$\u001a\u0004\u0018\u00010#HÖ\u0003¢\u0006\u0004\b%\u0010&R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010'\u001a\u0004\b(\u0010\u0019R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010)\u001a\u0004\b*\u0010\u001bR\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010+\u001a\u0004\b,\u0010\u001d¨\u00060"}, d2 = {"Lcom/bambulab/bambulab/navigation/route/HomeAppRoute$DesignDetailComment;", "Lcom/bambulab/bambulab/navigation/route/HomeAppRoute;", "", "designId", "", "openComposer", "", "modelCreatorJson", "<init>", "(JZLjava/lang/String;)V", "", "seen0", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "serializationConstructorMarker", "(IJZLjava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "self", "Lkotlinx/serialization/encoding/CompositeEncoder;", "output", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "serialDesc", "Ltrs;", "write$Self$navigation", "(Lcom/bambulab/bambulab/navigation/route/HomeAppRoute$DesignDetailComment;Lkotlinx/serialization/encoding/CompositeEncoder;Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "write$Self", "component1", "()J", "component2", "()Z", "component3", "()Ljava/lang/String;", "copy", "(JZLjava/lang/String;)Lcom/bambulab/bambulab/navigation/route/HomeAppRoute$DesignDetailComment;", "toString", "hashCode", "()I", "", Request.JsonKeys.OTHER, "equals", "(Ljava/lang/Object;)Z", "J", "getDesignId", "Z", "getOpenComposer", "Ljava/lang/String;", "getModelCreatorJson", "Companion", "com/bambulab/bambulab/navigation/route/m6", "com/bambulab/bambulab/navigation/route/n6", "navigation"}, k = 1, mv = {2, 4, 0}, xi = 48)
    @Serializable
    public static final class DesignDetailComment implements HomeAppRoute {
        public static final int $stable = 0;
        public static final n6 Companion = null;
        private final long designId;
        private final String modelCreatorJson;
        private final boolean openComposer;

        static {
            Companion = new n6();
        }

        public /* synthetic */ DesignDetailComment(int r2, long r3, boolean r5, String r6, SerializationConstructorMarker r7) {
            if (1 == (r2 & 1)) goto L5;
            PluginExceptionsKt.throwMissingFieldException(r2, 1, m6.a.getDescriptor());
        L5:
            this.designId = r3;
            if ((r2 & 2) != 0) goto L8;
            this.openComposer = false;
        L10:
            if ((r2 & 4) != 0) goto L13;
            this.modelCreatorJson = null;
            return;
        L13:
            this.modelCreatorJson = r6;
            return;
        L8:
            this.openComposer = r5;
            goto L10
        }

        public DesignDetailComment(long r1, boolean r3, String r4) {
            this.designId = r1;
            this.openComposer = r3;
            this.modelCreatorJson = r4;
        }

        public /* synthetic */ DesignDetailComment(long r1, boolean r3, String r4, int r5, DefaultConstructorMarker r6) {
            if ((r5 & 2) == 0) goto L6;
            r3 = false;
        L6:
            if ((r5 & 4) == 0) goto L8;
            r4 = null;
        L8:
            this(r1, r3, r4);
        }

        public static /* synthetic */ DesignDetailComment copy$default(DesignDetailComment r0, long r1, boolean r3, String r4, int r5, Object r6) {
            if ((r5 & 1) == 0) goto L6;
            r1 = r0.designId;
        L6:
            if ((r5 & 2) == 0) goto L9;
            r3 = r0.openComposer;
        L9:
            if ((r5 & 4) == 0) goto L12;
            r4 = r0.modelCreatorJson;
        L12:
            return r0.copy(r1, r3, r4);
        }

        @o0g
        public static final /* synthetic */ void write$Self$navigation(DesignDetailComment r3, CompositeEncoder r4, SerialDescriptor r5) {
            r4.encodeLongElement(r5, 0, r3.designId);
            if (r4.shouldEncodeElementDefault(r5, 1) == false) goto L6;
        L7:
            r4.encodeBooleanElement(r5, 1, r3.openComposer);
        L9:
            if (r4.shouldEncodeElementDefault(r5, 2) == false) goto L12;
        L13:
            r4.encodeNullableSerializableElement(r5, 2, StringSerializer.INSTANCE, r3.modelCreatorJson);
            return;
        L12:
            if (r3.modelCreatorJson != null) goto L13;
            return;
        L6:
            if (r3.openComposer == false) goto L9;
            goto L7
        }

        public final long component1() {
            return this.designId;
        }

        public final boolean component2() {
            return this.openComposer;
        }

        public final String component3() {
            return this.modelCreatorJson;
        }

        public final DesignDetailComment copy(long r1, boolean r3, String r4) {
            return new DesignDetailComment(r1, r3, r4);
        }

        public boolean equals(Object r8) {
            if (this != r8) goto L6;
            return true;
        L6:
            if ((r8 instanceof DesignDetailComment) == true) goto L8;
            return false;
        L8:
            DesignDetailComment r82 = (DesignDetailComment) r8;
            if (this.designId == r82.designId) goto L12;
            return false;
        L12:
            if (this.openComposer == r82.openComposer) goto L15;
            return false;
        L15:
            if (lsf.l(this.modelCreatorJson, r82.modelCreatorJson) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public final long getDesignId() {
            return this.designId;
        }

        public final String getModelCreatorJson() {
            return this.modelCreatorJson;
        }

        public final boolean getOpenComposer() {
            return this.openComposer;
        }

        public int hashCode() {
            int r0 = b0r.c(Long.hashCode(this.designId) * 31, 31, this.openComposer);
            String r3 = this.modelCreatorJson;
            if (r3 != null) goto L5;
            int r32 = 0;
        L7:
            return r0 + r32;
        L5:
            r32 = r3.hashCode();
            goto L7
        }

        public String toString() {
            long r0 = this.designId;
            boolean r2 = this.openComposer;
            String r5 = this.modelCreatorJson;
            StringBuilder r3 = new StringBuilder("DesignDetailComment(designId=");
            r3.append(r0);
            r3.append(", openComposer=");
            r3.append(r2);
            return ul7.m(r3, ", modelCreatorJson=", r5, ")");
        }
    }

    @Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0087\b\u0018\u0000 +2\u00020\u0001:\u0002,-B#\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bB5\b\u0010\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\u0007\u0010\rJ'\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u000e\u001a\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0011H\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0017\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0019\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0019\u0010\u0018J\u0012\u0010\u001a\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u001a\u0010\u001bJ0\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00022\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u001e\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u001e\u0010\u001bJ\u0010\u0010\u001f\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\u001f\u0010 J\u001a\u0010$\u001a\u00020#2\b\u0010\"\u001a\u0004\u0018\u00010!HÖ\u0003¢\u0006\u0004\b$\u0010%R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010&\u001a\u0004\b'\u0010\u0018R\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010&\u001a\u0004\b(\u0010\u0018R\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010)\u001a\u0004\b*\u0010\u001b¨\u0006."}, d2 = {"Lcom/bambulab/bambulab/navigation/route/HomeAppRoute$DesignDetailPlates;", "Lcom/bambulab/bambulab/navigation/route/HomeAppRoute;", "", "designId", "instanceId", "", "devProductName", "<init>", "(JJLjava/lang/String;)V", "", "seen0", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "serializationConstructorMarker", "(IJJLjava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "self", "Lkotlinx/serialization/encoding/CompositeEncoder;", "output", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "serialDesc", "Ltrs;", "write$Self$navigation", "(Lcom/bambulab/bambulab/navigation/route/HomeAppRoute$DesignDetailPlates;Lkotlinx/serialization/encoding/CompositeEncoder;Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "write$Self", "component1", "()J", "component2", "component3", "()Ljava/lang/String;", "copy", "(JJLjava/lang/String;)Lcom/bambulab/bambulab/navigation/route/HomeAppRoute$DesignDetailPlates;", "toString", "hashCode", "()I", "", Request.JsonKeys.OTHER, "", "equals", "(Ljava/lang/Object;)Z", "J", "getDesignId", "getInstanceId", "Ljava/lang/String;", "getDevProductName", "Companion", "com/bambulab/bambulab/navigation/route/o6", "com/bambulab/bambulab/navigation/route/p6", "navigation"}, k = 1, mv = {2, 4, 0}, xi = 48)
    @Serializable
    public static final class DesignDetailPlates implements HomeAppRoute {
        public static final int $stable = 0;
        public static final p6 Companion = null;
        private final long designId;
        private final String devProductName;
        private final long instanceId;

        static {
            Companion = new p6();
        }

        public /* synthetic */ DesignDetailPlates(int r2, long r3, long r5, String r7, SerializationConstructorMarker r8) {
            if (3 == (r2 & 3)) goto L5;
            PluginExceptionsKt.throwMissingFieldException(r2, 3, o6.a.getDescriptor());
        L5:
            this.designId = r3;
            this.instanceId = r5;
            if ((r2 & 4) != 0) goto L9;
            this.devProductName = null;
            return;
        L9:
            this.devProductName = r7;
        }

        public DesignDetailPlates(long r1, long r3, String r5) {
            this.designId = r1;
            this.instanceId = r3;
            this.devProductName = r5;
        }

        public /* synthetic */ DesignDetailPlates(long r7, long r9, String r11, int r12, DefaultConstructorMarker r13) {
            if ((r12 & 4) == 0) goto L5;
            r11 = null;
        L5:
            this(r7, r9, r11);
        }

        public static /* synthetic */ DesignDetailPlates copy$default(DesignDetailPlates r6, long r7, long r9, String r11, int r12, Object r13) {
            if ((r12 & 1) == 0) goto L5;
            r7 = r6.designId;
        L5:
            long r1 = r7;
            if ((r12 & 2) == 0) goto L8;
            r9 = r6.instanceId;
        L8:
            long r3 = r9;
            if ((r12 & 4) == 0) goto L12;
            r11 = r6.devProductName;
        L12:
            return r6.copy(r1, r3, r11);
        }

        @o0g
        public static final /* synthetic */ void write$Self$navigation(DesignDetailPlates r3, CompositeEncoder r4, SerialDescriptor r5) {
            r4.encodeLongElement(r5, 0, r3.designId);
            r4.encodeLongElement(r5, 1, r3.instanceId);
            if (r4.shouldEncodeElementDefault(r5, 2) == false) goto L6;
        L7:
            r4.encodeNullableSerializableElement(r5, 2, StringSerializer.INSTANCE, r3.devProductName);
            return;
        L6:
            if (r3.devProductName != null) goto L7;
        }

        public final long component1() {
            return this.designId;
        }

        public final long component2() {
            return this.instanceId;
        }

        public final String component3() {
            return this.devProductName;
        }

        public final DesignDetailPlates copy(long r1, long r3, String r5) {
            return new DesignDetailPlates(r1, r3, r5);
        }

        public boolean equals(Object r8) {
            if (this != r8) goto L6;
            return true;
        L6:
            if ((r8 instanceof DesignDetailPlates) == true) goto L8;
            return false;
        L8:
            DesignDetailPlates r82 = (DesignDetailPlates) r8;
            if (this.designId == r82.designId) goto L12;
            return false;
        L12:
            if (this.instanceId == r82.instanceId) goto L15;
            return false;
        L15:
            if (lsf.l(this.devProductName, r82.devProductName) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public final long getDesignId() {
            return this.designId;
        }

        public final String getDevProductName() {
            return this.devProductName;
        }

        public final long getInstanceId() {
            return this.instanceId;
        }

        public int hashCode() {
            int r0 = ul7.c(Long.hashCode(this.designId) * 31, 31, this.instanceId);
            String r4 = this.devProductName;
            if (r4 != null) goto L5;
            int r42 = 0;
        L7:
            return r0 + r42;
        L5:
            r42 = r4.hashCode();
            goto L7
        }

        public String toString() {
            long r0 = this.designId;
            long r2 = this.instanceId;
            String r6 = this.devProductName;
            StringBuilder r02 = dgh.o(r0, "DesignDetailPlates(designId=", ", instanceId=");
            t4m.o(r2, ", devProductName=", r6, r02);
            r02.append(")");
            return r02.toString();
        }
    }

    @Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\b\u0087\b\u0018\u0000 $2\u00020\u0001:\u0002%&B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005B#\b\u0010\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u0004\u0010\nJ'\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u000b\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000eH\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0014\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0014\u0010\u0015J\u001a\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0019\u001a\u00020\u0018HÖ\u0001¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u001b\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u001b\u0010\u001cJ\u001a\u0010 \u001a\u00020\u001f2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001dHÖ\u0003¢\u0006\u0004\b \u0010!R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\"\u001a\u0004\b#\u0010\u0015¨\u0006'"}, d2 = {"Lcom/bambulab/bambulab/navigation/route/HomeAppRoute$DesignDetailRemixed;", "Lcom/bambulab/bambulab/navigation/route/HomeAppRoute;", "", "designId", "<init>", "(J)V", "", "seen0", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "serializationConstructorMarker", "(IJLkotlinx/serialization/internal/SerializationConstructorMarker;)V", "self", "Lkotlinx/serialization/encoding/CompositeEncoder;", "output", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "serialDesc", "Ltrs;", "write$Self$navigation", "(Lcom/bambulab/bambulab/navigation/route/HomeAppRoute$DesignDetailRemixed;Lkotlinx/serialization/encoding/CompositeEncoder;Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "write$Self", "component1", "()J", "copy", "(J)Lcom/bambulab/bambulab/navigation/route/HomeAppRoute$DesignDetailRemixed;", "", "toString", "()Ljava/lang/String;", "hashCode", "()I", "", Request.JsonKeys.OTHER, "", "equals", "(Ljava/lang/Object;)Z", "J", "getDesignId", "Companion", "com/bambulab/bambulab/navigation/route/q6", "com/bambulab/bambulab/navigation/route/r6", "navigation"}, k = 1, mv = {2, 4, 0}, xi = 48)
    @Serializable
    public static final class DesignDetailRemixed implements HomeAppRoute {
        public static final int $stable = 0;
        public static final r6 Companion = null;
        private final long designId;

        static {
            Companion = new r6();
        }

        public /* synthetic */ DesignDetailRemixed(int r2, long r3, SerializationConstructorMarker r5) {
            if (1 == (r2 & 1)) goto L5;
            PluginExceptionsKt.throwMissingFieldException(r2, 1, q6.a.getDescriptor());
        L5:
            this.designId = r3;
        }

        public DesignDetailRemixed(long r1) {
            this.designId = r1;
        }

        public static /* synthetic */ DesignDetailRemixed copy$default(DesignDetailRemixed r0, long r1, int r3, Object r4) {
            if ((r3 & 1) == 0) goto L6;
            r1 = r0.designId;
        L6:
            return r0.copy(r1);
        }

        @o0g
        public static final /* synthetic */ void write$Self$navigation(DesignDetailRemixed r3, CompositeEncoder r4, SerialDescriptor r5) {
            r4.encodeLongElement(r5, 0, r3.designId);
        }

        public final long component1() {
            return this.designId;
        }

        public final DesignDetailRemixed copy(long r1) {
            return new DesignDetailRemixed(r1);
        }

        public boolean equals(Object r6) {
            if (this != r6) goto L6;
            return true;
        L6:
            if ((r6 instanceof DesignDetailRemixed) == true) goto L9;
            return false;
        L9:
            if (this.designId == ((DesignDetailRemixed) r6).designId) goto L11;
            return false;
        L11:
            return true;
        }

        public final long getDesignId() {
            return this.designId;
        }

        public int hashCode() {
            return Long.hashCode(this.designId);
        }

        public String toString() {
            return r77.l(this.designId, "DesignDetailRemixed(designId=", ")");
        }
    }

    @Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0017\n\u0002\u0010$\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b2\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b1\b\u0087\b\u0018\u0000 \u009b\u00012\u00020\u0001:\u0004\u009c\u0001\u009d\u0001BÁ\u0003\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010\t\u001a\u00020\b\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\n\u0012\b\b\u0002\u0010\r\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0010\u001a\u00020\b\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0014\u001a\u00020\n\u0012\b\b\u0002\u0010\u0015\u001a\u00020\b\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u001c\u001a\u00020\b\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u0004\u0012\u0014\b\u0002\u0010#\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00020\"\u0012\u000e\b\u0002\u0010&\u001a\b\u0012\u0004\u0012\u00020%0$\u0012\u000e\b\u0002\u0010'\u001a\b\u0012\u0004\u0012\u00020%0$\u0012\u000e\b\u0002\u0010)\u001a\b\u0012\u0004\u0012\u00020(0$\u0012\u001c\b\u0002\u0010*\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040$\u0018\u00010\"\u0012\n\b\u0002\u0010+\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010,\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b-\u0010.B¥\u0003\b\u0010\u0012\u0006\u0010/\u001a\u00020\n\u0012\u0006\u00100\u001a\u00020\n\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\t\u001a\u00020\b\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\b\u0010\f\u001a\u0004\u0018\u00010\n\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0010\u001a\u00020\b\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0014\u001a\u00020\n\u0012\u0006\u0010\u0015\u001a\u00020\b\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u001b\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u001c\u001a\u00020\b\u0012\b\u0010\u001d\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u001e\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u001f\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010 \u001a\u0004\u0018\u00010\u0004\u0012\b\u0010!\u001a\u0004\u0018\u00010\u0004\u0012\u0014\u0010#\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\"\u0012\u000e\u0010&\u001a\n\u0012\u0004\u0012\u00020%\u0018\u00010$\u0012\u000e\u0010'\u001a\n\u0012\u0004\u0012\u00020%\u0018\u00010$\u0012\u000e\u0010)\u001a\n\u0012\u0004\u0012\u00020(\u0018\u00010$\u0012\u001a\u0010*\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040$\u0018\u00010\"\u0012\b\u0010+\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010,\u001a\u0004\u0018\u00010\u0002\u0012\b\u00102\u001a\u0004\u0018\u000101¢\u0006\u0004\b-\u00103J\u0010\u00104\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b4\u00105J\u0012\u00106\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0004\b6\u00107J\u0012\u00108\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b8\u00109J\u0012\u0010:\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b:\u00109J\u0010\u0010;\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b;\u0010<J\u0012\u0010=\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0004\b=\u0010>J\u0012\u0010?\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0004\b?\u0010>J\u0010\u0010@\u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b@\u00107J\u0010\u0010A\u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\bA\u00107J\u0012\u0010B\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0004\bB\u00107J\u0010\u0010C\u001a\u00020\bHÆ\u0003¢\u0006\u0004\bC\u0010<J\u0012\u0010D\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0004\bD\u00107J\u0012\u0010E\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0004\bE\u00107J\u0012\u0010F\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0004\bF\u00107J\u0010\u0010G\u001a\u00020\nHÆ\u0003¢\u0006\u0004\bG\u0010HJ\u0010\u0010I\u001a\u00020\bHÆ\u0003¢\u0006\u0004\bI\u0010<J\u0012\u0010J\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0004\bJ\u00107J\u0012\u0010K\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0004\bK\u00107J\u0012\u0010L\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0004\bL\u00107J\u0012\u0010M\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0004\bM\u00107J\u0012\u0010N\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0004\bN\u00107J\u0012\u0010O\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0004\bO\u00107J\u0010\u0010P\u001a\u00020\bHÆ\u0003¢\u0006\u0004\bP\u0010<J\u0012\u0010Q\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0004\bQ\u0010RJ\u0012\u0010S\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0004\bS\u00107J\u0012\u0010T\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0004\bT\u00107J\u0012\u0010U\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0004\bU\u00107J\u0012\u0010V\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0004\bV\u00107J\u001c\u0010W\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00020\"HÆ\u0003¢\u0006\u0004\bW\u0010XJ\u0016\u0010Y\u001a\b\u0012\u0004\u0012\u00020%0$HÆ\u0003¢\u0006\u0004\bY\u0010ZJ\u0016\u0010[\u001a\b\u0012\u0004\u0012\u00020%0$HÆ\u0003¢\u0006\u0004\b[\u0010ZJ\u0016\u0010\\\u001a\b\u0012\u0004\u0012\u00020(0$HÆ\u0003¢\u0006\u0004\b\\\u0010ZJ$\u0010]\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040$\u0018\u00010\"HÆ\u0003¢\u0006\u0004\b]\u0010XJ\u0012\u0010^\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0004\b^\u00107J\u0012\u0010_\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b_\u00109JÌ\u0003\u0010`\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\t\u001a\u00020\b2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010\r\u001a\u00020\u00042\b\b\u0002\u0010\u000e\u001a\u00020\u00042\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u0010\u001a\u00020\b2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u0014\u001a\u00020\n2\b\b\u0002\u0010\u0015\u001a\u00020\b2\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u001c\u001a\u00020\b2\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u00042\u0014\b\u0002\u0010#\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00020\"2\u000e\b\u0002\u0010&\u001a\b\u0012\u0004\u0012\u00020%0$2\u000e\b\u0002\u0010'\u001a\b\u0012\u0004\u0012\u00020%0$2\u000e\b\u0002\u0010)\u001a\b\u0012\u0004\u0012\u00020(0$2\u001c\b\u0002\u0010*\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040$\u0018\u00010\"2\n\b\u0002\u0010+\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010,\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b`\u0010aJ\u0010\u0010b\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\bb\u00107J\u0010\u0010c\u001a\u00020\nHÖ\u0001¢\u0006\u0004\bc\u0010HJ\u001a\u0010f\u001a\u00020\b2\b\u0010e\u001a\u0004\u0018\u00010dHÖ\u0003¢\u0006\u0004\bf\u0010gJ'\u0010p\u001a\u00020m2\u0006\u0010h\u001a\u00020\u00002\u0006\u0010j\u001a\u00020i2\u0006\u0010l\u001a\u00020kH\u0001¢\u0006\u0004\bn\u0010oR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010q\u001a\u0004\br\u00105R\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010s\u001a\u0004\bt\u00107R\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010u\u001a\u0004\bv\u00109R\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0007\u0010u\u001a\u0004\bw\u00109R\u0017\u0010\t\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b\t\u0010x\u001a\u0004\b\t\u0010<R\u0019\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0006¢\u0006\f\n\u0004\b\u000b\u0010y\u001a\u0004\bz\u0010>R\u0019\u0010\f\u001a\u0004\u0018\u00010\n8\u0006¢\u0006\f\n\u0004\b\f\u0010y\u001a\u0004\b{\u0010>R\u0017\u0010\r\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\r\u0010s\u001a\u0004\b|\u00107R\u0017\u0010\u000e\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u000e\u0010s\u001a\u0004\b}\u00107R\u0019\u0010\u000f\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u000f\u0010s\u001a\u0004\b~\u00107R\u0017\u0010\u0010\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b\u0010\u0010x\u001a\u0004\b\u007f\u0010<R\u001a\u0010\u0011\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\r\n\u0004\b\u0011\u0010s\u001a\u0005\b\u0080\u0001\u00107R\u001a\u0010\u0012\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\r\n\u0004\b\u0012\u0010s\u001a\u0005\b\u0081\u0001\u00107R\u001a\u0010\u0013\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\r\n\u0004\b\u0013\u0010s\u001a\u0005\b\u0082\u0001\u00107R\u0019\u0010\u0014\u001a\u00020\n8\u0006¢\u0006\u000e\n\u0005\b\u0014\u0010\u0083\u0001\u001a\u0005\b\u0084\u0001\u0010HR\u0017\u0010\u0015\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b\u0015\u0010x\u001a\u0004\b\u0015\u0010<R\u001a\u0010\u0016\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\r\n\u0004\b\u0016\u0010s\u001a\u0005\b\u0085\u0001\u00107R\u001a\u0010\u0017\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\r\n\u0004\b\u0017\u0010s\u001a\u0005\b\u0086\u0001\u00107R\u001a\u0010\u0018\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\r\n\u0004\b\u0018\u0010s\u001a\u0005\b\u0087\u0001\u00107R\u001a\u0010\u0019\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\r\n\u0004\b\u0019\u0010s\u001a\u0005\b\u0088\u0001\u00107R\u001a\u0010\u001a\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\r\n\u0004\b\u001a\u0010s\u001a\u0005\b\u0089\u0001\u00107R\u001a\u0010\u001b\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\r\n\u0004\b\u001b\u0010s\u001a\u0005\b\u008a\u0001\u00107R\u0018\u0010\u001c\u001a\u00020\b8\u0006¢\u0006\r\n\u0004\b\u001c\u0010x\u001a\u0005\b\u008b\u0001\u0010<R\u001b\u0010\u001d\u001a\u0004\u0018\u00010\b8\u0006¢\u0006\u000e\n\u0005\b\u001d\u0010\u008c\u0001\u001a\u0005\b\u008d\u0001\u0010RR\u001a\u0010\u001e\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\r\n\u0004\b\u001e\u0010s\u001a\u0005\b\u008e\u0001\u00107R\u001a\u0010\u001f\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\r\n\u0004\b\u001f\u0010s\u001a\u0005\b\u008f\u0001\u00107R\u001a\u0010 \u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\r\n\u0004\b \u0010s\u001a\u0005\b\u0090\u0001\u00107R\u001a\u0010!\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\r\n\u0004\b!\u0010s\u001a\u0005\b\u0091\u0001\u00107R%\u0010#\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00020\"8\u0006¢\u0006\u000e\n\u0005\b#\u0010\u0092\u0001\u001a\u0005\b\u0093\u0001\u0010XR\u001f\u0010&\u001a\b\u0012\u0004\u0012\u00020%0$8\u0006¢\u0006\u000e\n\u0005\b&\u0010\u0094\u0001\u001a\u0005\b\u0095\u0001\u0010ZR\u001f\u0010'\u001a\b\u0012\u0004\u0012\u00020%0$8\u0006¢\u0006\u000e\n\u0005\b'\u0010\u0094\u0001\u001a\u0005\b\u0096\u0001\u0010ZR\u001f\u0010)\u001a\b\u0012\u0004\u0012\u00020(0$8\u0006¢\u0006\u000e\n\u0005\b)\u0010\u0094\u0001\u001a\u0005\b\u0097\u0001\u0010ZR-\u0010*\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040$\u0018\u00010\"8\u0006¢\u0006\u000e\n\u0005\b*\u0010\u0092\u0001\u001a\u0005\b\u0098\u0001\u0010XR\u001a\u0010+\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\r\n\u0004\b+\u0010s\u001a\u0005\b\u0099\u0001\u00107R\u001a\u0010,\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\r\n\u0004\b,\u0010u\u001a\u0005\b\u009a\u0001\u00109¨\u0006\u009e\u0001"}, d2 = {"Lcom/bambulab/bambulab/navigation/route/HomeAppRoute$DesignPrint;", "Lcom/bambulab/bambulab/navigation/route/HomeAppRoute;", "", "profileId", "", "modelId", "designId", "instanceId", "", "isPublicProfile", "", "plateIndex", "choosePlateIndex", "mode", "lastUsedDeviceId", "sourceFrom", "enableAddToQueue", "designTitle", "profileCover", "plateId", "repetitions", "isMultiProfile", "gcodeBedType", "bizType", "bizKey", "unikey", "historyId", "tool", "nextPlate", "useAms", "filamentSettingIds", "matchFilamentMode", "skipObjects", "refreshId", "", "initialFilamentArgbById", "", "Lcom/bambulab/bambulab/model/AmsDetailMapping;", "lastAmsMapping", "lastAmsDetailMapping", "Lcom/bambulab/bambulab/model/PrintNozzleInfo;", "lastNozzleInfos", "lastSliceCfg", "collectionFrom", "syncDesignId", "<init>", "(JLjava/lang/String;Ljava/lang/Long;Ljava/lang/Long;ZLjava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;IZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/Map;Ljava/lang/String;Ljava/lang/Long;)V", "seen0", "seen1", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "serializationConstructorMarker", "(IIJLjava/lang/String;Ljava/lang/Long;Ljava/lang/Long;ZLjava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;IZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/Map;Ljava/lang/String;Ljava/lang/Long;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "component1", "()J", "component2", "()Ljava/lang/String;", "component3", "()Ljava/lang/Long;", "component4", "component5", "()Z", "component6", "()Ljava/lang/Integer;", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "()I", "component16", "component17", "component18", "component19", "component20", "component21", "component22", "component23", "component24", "()Ljava/lang/Boolean;", "component25", "component26", "component27", "component28", "component29", "()Ljava/util/Map;", "component30", "()Ljava/util/List;", "component31", "component32", "component33", "component34", "component35", "copy", "(JLjava/lang/String;Ljava/lang/Long;Ljava/lang/Long;ZLjava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;IZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/Map;Ljava/lang/String;Ljava/lang/Long;)Lcom/bambulab/bambulab/navigation/route/HomeAppRoute$DesignPrint;", "toString", "hashCode", "", Request.JsonKeys.OTHER, "equals", "(Ljava/lang/Object;)Z", "self", "Lkotlinx/serialization/encoding/CompositeEncoder;", "output", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "serialDesc", "Ltrs;", "write$Self$navigation", "(Lcom/bambulab/bambulab/navigation/route/HomeAppRoute$DesignPrint;Lkotlinx/serialization/encoding/CompositeEncoder;Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "write$Self", "J", "getProfileId", "Ljava/lang/String;", "getModelId", "Ljava/lang/Long;", "getDesignId", "getInstanceId", "Z", "Ljava/lang/Integer;", "getPlateIndex", "getChoosePlateIndex", "getMode", "getLastUsedDeviceId", "getSourceFrom", "getEnableAddToQueue", "getDesignTitle", "getProfileCover", "getPlateId", "I", "getRepetitions", "getGcodeBedType", "getBizType", "getBizKey", "getUnikey", "getHistoryId", "getTool", "getNextPlate", "Ljava/lang/Boolean;", "getUseAms", "getFilamentSettingIds", "getMatchFilamentMode", "getSkipObjects", "getRefreshId", "Ljava/util/Map;", "getInitialFilamentArgbById", "Ljava/util/List;", "getLastAmsMapping", "getLastAmsDetailMapping", "getLastNozzleInfos", "getLastSliceCfg", "getCollectionFrom", "getSyncDesignId", "Companion", "com/bambulab/bambulab/navigation/route/s6", "com/bambulab/bambulab/navigation/route/t6", "navigation"}, k = 1, mv = {2, 4, 0}, xi = 48)
    @Serializable
    public static final class DesignPrint implements HomeAppRoute {
        private static final Lazy<KSerializer<Object>>[] $childSerializers = null;
        public static final int $stable = 0;
        public static final t6 Companion = null;
        private final String bizKey;
        private final String bizType;
        private final Integer choosePlateIndex;
        private final String collectionFrom;
        private final Long designId;
        private final String designTitle;
        private final boolean enableAddToQueue;
        private final String filamentSettingIds;
        private final String gcodeBedType;
        private final String historyId;
        private final Map<Integer, Long> initialFilamentArgbById;
        private final Long instanceId;
        private final boolean isMultiProfile;
        private final boolean isPublicProfile;
        private final List<AmsDetailMapping> lastAmsDetailMapping;
        private final List<AmsDetailMapping> lastAmsMapping;
        private final List<PrintNozzleInfo> lastNozzleInfos;
        private final Map<String, List<String>> lastSliceCfg;
        private final String lastUsedDeviceId;
        private final String matchFilamentMode;
        private final String mode;
        private final String modelId;
        private final boolean nextPlate;
        private final String plateId;
        private final Integer plateIndex;
        private final String profileCover;
        private final long profileId;
        private final String refreshId;
        private final int repetitions;
        private final String skipObjects;
        private final String sourceFrom;
        private final Long syncDesignId;
        private final String tool;
        private final String unikey;
        private final Boolean useAms;

        static {
            Companion = new t6();
            acd r0 = new acd(27);
            lkg r2 = lkg.b;
            $childSerializers = new Lazy[]{null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, z86.y(r2, r0), z86.y(r2, new acd(28)), z86.y(r2, new acd(29)), z86.y(r2, new rie(0)), z86.y(r2, new rie(1)), null, null};
        }

        public /* synthetic */ DesignPrint(int r6, int r7, long r8, String r10, Long r11, Long r12, boolean r13, Integer r14, Integer r15, String r16, String r17, String r18, boolean r19, String r20, String r21, String r22, int r23, boolean r24, String r25, String r26, String r27, String r28, String r29, String r30, boolean r31, Boolean r32, String r33, String r34, String r35, String r36, Map r37, List r38, List r39, List r40, Map r41, String r42, Long r43, SerializationConstructorMarker r44) {
            if (1 == (r6 & 1)) goto L5;
            boolean r0 = true;
        L6:
            if (r0 == false) goto L8;
            PluginExceptionsKt.throwArrayMissingFieldException(new int[]{r6, r7}, new int[]{1, 0}, s6.a.getDescriptor());
        L8:
            this.profileId = r8;
            if ((r6 & 2) != 0) goto L11;
            this.modelId = null;
        L13:
            if ((r6 & 4) != 0) goto L15;
            this.designId = null;
        L17:
            if ((r6 & 8) != 0) goto L19;
            this.instanceId = null;
        L21:
            if ((r6 & 16) != 0) goto L23;
            this.isPublicProfile = true;
        L25:
            if ((r6 & 32) != 0) goto L27;
            this.plateIndex = null;
        L29:
            if ((r6 & 64) != 0) goto L31;
            this.choosePlateIndex = null;
        L33:
            if ((r6 & 128) != 0) goto L36;
            String r82 = PrintHistoryModel.MODE_CLOUD_SLICE;
        L35:
            this.mode = r82;
            if ((r6 & 256) != 0) goto L41;
            String r83 = "";
        L40:
            this.lastUsedDeviceId = r83;
            if ((r6 & 512) != 0) goto L45;
            this.sourceFrom = null;
        L47:
            if ((r6 & 1024) != 0) goto L49;
            this.enableAddToQueue = false;
        L51:
            if ((r6 & 2048) != 0) goto L53;
            this.designTitle = null;
        L55:
            if ((r6 & 4096) != 0) goto L57;
            this.profileCover = null;
        L59:
            if ((r6 & 8192) != 0) goto L61;
            this.plateId = null;
        L63:
            if ((r6 & 16384) != 0) goto L65;
            this.repetitions = 1;
        L67:
            if ((32768 & r6) != 0) goto L69;
            this.isMultiProfile = false;
        L71:
            if ((65536 & r6) != 0) goto L73;
            this.gcodeBedType = null;
        L75:
            if ((131072 & r6) != 0) goto L77;
            this.bizType = null;
        L79:
            if ((262144 & r6) != 0) goto L81;
            this.bizKey = null;
        L83:
            if ((524288 & r6) != 0) goto L85;
            this.unikey = null;
        L87:
            if ((1048576 & r6) != 0) goto L89;
            this.historyId = null;
        L91:
            if ((2097152 & r6) != 0) goto L93;
            this.tool = null;
        L95:
            if ((4194304 & r6) != 0) goto L97;
            this.nextPlate = false;
        L99:
            if ((8388608 & r6) != 0) goto L101;
            this.useAms = null;
        L103:
            if ((16777216 & r6) != 0) goto L105;
            this.filamentSettingIds = null;
        L107:
            if ((33554432 & r6) != 0) goto L109;
            this.matchFilamentMode = null;
        L111:
            if ((67108864 & r6) != 0) goto L113;
            this.skipObjects = null;
        L115:
            if ((134217728 & r6) != 0) goto L117;
            this.refreshId = null;
        L119:
            if ((268435456 & r6) != 0) goto L122;
            Map r84 = fgb.a;
        L121:
            this.initialFilamentArgbById = r84;
            int r85 = 536870912 & r6;
            egb r102 = egb.a;
            if (r85 != 0) goto L126;
            this.lastAmsMapping = r102;
        L128:
            if ((1073741824 & r6) != 0) goto L130;
            this.lastAmsDetailMapping = r102;
        L132:
            if ((r6 & Integer.MIN_VALUE) != 0) goto L134;
            this.lastNozzleInfos = r102;
        L136:
            if ((r7 & 1) != 0) goto L138;
            this.lastSliceCfg = null;
        L140:
            if ((r7 & 2) != 0) goto L142;
            this.collectionFrom = null;
        L144:
            if ((r7 & 4) != 0) goto L147;
            this.syncDesignId = null;
            return;
        L147:
            this.syncDesignId = r43;
            return;
        L142:
            this.collectionFrom = r42;
            goto L144
        L138:
            this.lastSliceCfg = r41;
            goto L140
        L134:
            this.lastNozzleInfos = r40;
            goto L136
        L130:
            this.lastAmsDetailMapping = r39;
            goto L132
        L126:
            this.lastAmsMapping = r38;
            goto L128
        L122:
            r84 = r37;
            goto L121
        L117:
            this.refreshId = r36;
            goto L119
        L113:
            this.skipObjects = r35;
            goto L115
        L109:
            this.matchFilamentMode = r34;
            goto L111
        L105:
            this.filamentSettingIds = r33;
            goto L107
        L101:
            this.useAms = r32;
            goto L103
        L97:
            this.nextPlate = r31;
            goto L99
        L93:
            this.tool = r30;
            goto L95
        L89:
            this.historyId = r29;
            goto L91
        L85:
            this.unikey = r28;
            goto L87
        L81:
            this.bizKey = r27;
            goto L83
        L77:
            this.bizType = r26;
            goto L79
        L73:
            this.gcodeBedType = r25;
            goto L75
        L69:
            this.isMultiProfile = r24;
            goto L71
        L65:
            this.repetitions = r23;
            goto L67
        L61:
            this.plateId = r22;
            goto L63
        L57:
            this.profileCover = r21;
            goto L59
        L53:
            this.designTitle = r20;
            goto L55
        L49:
            this.enableAddToQueue = r19;
            goto L51
        L45:
            this.sourceFrom = r18;
            goto L47
        L41:
            r83 = r17;
            goto L40
        L36:
            r82 = r16;
            goto L35
        L31:
            this.choosePlateIndex = r15;
            goto L33
        L27:
            this.plateIndex = r14;
            goto L29
        L23:
            this.isPublicProfile = r13;
            goto L25
        L19:
            this.instanceId = r12;
            goto L21
        L15:
            this.designId = r11;
            goto L17
        L11:
            this.modelId = r10;
            goto L13
        L5:
            r0 = false;
            goto L6
        }

        /* JADX WARN: Multi-variable type inference failed */
        public DesignPrint(long r1, String r3, Long r4, Long r5, boolean r6, Integer r7, Integer r8, String r9, String r10, String r11, boolean r12, String r13, String r14, String r15, int r16, boolean r17, String r18, String r19, String r20, String r21, String r22, String r23, boolean r24, Boolean r25, String r26, String r27, String r28, String r29, Map<Integer, Long> r30, List<AmsDetailMapping> r31, List<AmsDetailMapping> r32, List<PrintNozzleInfo> r33, Map<String, ? extends List<String>> r34, String r35, Long r36) {
            r9.getClass();
            r10.getClass();
            r30.getClass();
            r31.getClass();
            r32.getClass();
            r33.getClass();
            this.profileId = r1;
            this.modelId = r3;
            this.designId = r4;
            this.instanceId = r5;
            this.isPublicProfile = r6;
            this.plateIndex = r7;
            this.choosePlateIndex = r8;
            this.mode = r9;
            this.lastUsedDeviceId = r10;
            this.sourceFrom = r11;
            this.enableAddToQueue = r12;
            this.designTitle = r13;
            this.profileCover = r14;
            this.plateId = r15;
            this.repetitions = r16;
            this.isMultiProfile = r17;
            this.gcodeBedType = r18;
            this.bizType = r19;
            this.bizKey = r20;
            this.unikey = r21;
            this.historyId = r22;
            this.tool = r23;
            this.nextPlate = r24;
            this.useAms = r25;
            this.filamentSettingIds = r26;
            this.matchFilamentMode = r27;
            this.skipObjects = r28;
            this.refreshId = r29;
            this.initialFilamentArgbById = r30;
            this.lastAmsMapping = r31;
            this.lastAmsDetailMapping = r32;
            this.lastNozzleInfos = r33;
            this.lastSliceCfg = r34;
            this.collectionFrom = r35;
            this.syncDesignId = r36;
        }

        public /* synthetic */ DesignPrint(long r35, String r37, Long r38, Long r39, boolean r40, Integer r41, Integer r42, String r43, String r44, String r45, boolean r46, String r47, String r48, String r49, int r50, boolean r51, String r52, String r53, String r54, String r55, String r56, String r57, boolean r58, Boolean r59, String r60, String r61, String r62, String r63, Map r64, List r65, List r66, List r67, Map r68, String r69, Long r70, int r71, int r72, DefaultConstructorMarker r73) {
            if ((r71 & 2) == 0) goto L5;
            String r1 = null;
        L7:
            if ((r71 & 4) == 0) goto L9;
            Long r3 = null;
        L11:
            if ((r71 & 8) == 0) goto L13;
            Long r4 = null;
        L15:
            if ((r71 & 16) == 0) goto L17;
            boolean r5 = true;
        L19:
            if ((r71 & 32) == 0) goto L21;
            Integer r7 = null;
        L23:
            if ((r71 & 64) == 0) goto L25;
            Integer r8 = null;
        L27:
            if ((r71 & 128) == 0) goto L29;
            String r9 = PrintHistoryModel.MODE_CLOUD_SLICE;
        L31:
            if ((r71 & 256) == 0) goto L33;
            String r10 = "";
        L35:
            if ((r71 & 512) == 0) goto L37;
            String r11 = null;
        L38:
            boolean r13 = false;
            if ((r71 & 1024) == 0) goto L41;
            boolean r12 = false;
        L43:
            if ((r71 & 2048) == 0) goto L45;
            String r14 = null;
        L47:
            if ((r71 & 4096) == 0) goto L49;
            String r15 = null;
        L51:
            if ((r71 & 8192) == 0) goto L53;
            String r2 = null;
        L55:
            if ((r71 & 16384) == 0) goto L57;
            int r6 = 1;
        L59:
            if ((r71 & Constants.EAR_MONITORING_FILTER_REUSE_POST_PROCESSING_FILTER) == 0) goto L61;
            boolean r16 = false;
        L63:
            if ((r71 & 65536) == 0) goto L65;
            String r17 = null;
        L67:
            if ((r71 & 131072) == 0) goto L69;
            String r18 = null;
        L71:
            if ((r71 & 262144) == 0) goto L73;
            String r19 = null;
        L75:
            if ((r71 & CommonNetImpl.MAX_SEND_SIZE_IN_KB) == 0) goto L77;
            String r20 = null;
        L79:
            if ((r71 & 1048576) == 0) goto L81;
            String r21 = null;
        L83:
            if ((r71 & 2097152) == 0) goto L85;
            String r22 = null;
        L87:
            if ((r71 & 4194304) != 0) goto L91;
            r13 = r58;
        L91:
            if ((r71 & AudioRoutingController.DEVICE_OUTPUT_OUT_IP) == 0) goto L93;
            Boolean r23 = null;
        L95:
            if ((r71 & CommonNetImpl.FLAG_SHARE_EDIT) == 0) goto L97;
            String r24 = null;
        L99:
            if ((r71 & CommonNetImpl.FLAG_SHARE_JUMP) == 0) goto L101;
            String r25 = null;
        L103:
            if ((r71 & AudioRoutingController.DEVICE_OUT_USB_HEADSET) == 0) goto L105;
            String r26 = null;
        L107:
            if ((r71 & 134217728) == 0) goto L109;
            String r27 = null;
        L111:
            if ((r71 & CommonNetImpl.FLAG_AUTH) == 0) goto L113;
            Map r28 = fgb.a;
        L114:
            int r29 = r71 & CommonNetImpl.FLAG_SHARE;
            List r30 = egb.a;
            if (r29 == 0) goto L117;
            List r292 = r30;
        L119:
            if ((r71 & 1073741824) == 0) goto L121;
            List r31 = r30;
        L123:
            if ((r71 & Integer.MIN_VALUE) != 0) goto L127;
            r30 = r67;
        L127:
            if ((r72 & 1) == 0) goto L129;
            Map r0 = null;
        L131:
            if ((r72 & 2) == 0) goto L133;
            String r32 = null;
        L135:
            if ((r72 & 4) == 0) goto L138;
            Long r732 = null;
        L139:
            this(r35, r1, r3, r4, r5, r7, r8, r9, r10, r11, r12, r14, r15, r2, r6, r16, r17, r18, r19, r20, r21, r22, r13, r23, r24, r25, r26, r27, r28, r292, r31, r30, r0, r32, r732);
            return;
        L138:
            r732 = r70;
            goto L139
        L133:
            r32 = r69;
            goto L135
        L129:
            r0 = r68;
            goto L131
        L121:
            r31 = r66;
            goto L123
        L117:
            r292 = r65;
            goto L119
        L113:
            r28 = r64;
            goto L114
        L109:
            r27 = r63;
            goto L111
        L105:
            r26 = r62;
            goto L107
        L101:
            r25 = r61;
            goto L103
        L97:
            r24 = r60;
            goto L99
        L93:
            r23 = r59;
            goto L95
        L85:
            r22 = r57;
            goto L87
        L81:
            r21 = r56;
            goto L83
        L77:
            r20 = r55;
            goto L79
        L73:
            r19 = r54;
            goto L75
        L69:
            r18 = r53;
            goto L71
        L65:
            r17 = r52;
            goto L67
        L61:
            r16 = r51;
            goto L63
        L57:
            r6 = r50;
            goto L59
        L53:
            r2 = r49;
            goto L55
        L49:
            r15 = r48;
            goto L51
        L45:
            r14 = r47;
            goto L47
        L41:
            r12 = r46;
            goto L43
        L37:
            r11 = r45;
            goto L38
        L33:
            r10 = r44;
            goto L35
        L29:
            r9 = r43;
            goto L31
        L25:
            r8 = r42;
            goto L27
        L21:
            r7 = r41;
            goto L23
        L17:
            r5 = r40;
            goto L19
        L13:
            r4 = r39;
            goto L15
        L9:
            r3 = r38;
            goto L11
        L5:
            r1 = r37;
            goto L7
        }

        private static final /* synthetic */ KSerializer _childSerializers$_anonymous_() {
            return new LinkedHashMapSerializer(IntSerializer.INSTANCE, LongSerializer.INSTANCE);
        }

        private static final /* synthetic */ KSerializer _childSerializers$_anonymous_$0() {
            return new ArrayListSerializer(AmsDetailMapping$$serializer.INSTANCE);
        }

        private static final /* synthetic */ KSerializer _childSerializers$_anonymous_$1() {
            return new ArrayListSerializer(AmsDetailMapping$$serializer.INSTANCE);
        }

        private static final /* synthetic */ KSerializer _childSerializers$_anonymous_$2() {
            return new ArrayListSerializer(PrintNozzleInfo$$serializer.INSTANCE);
        }

        private static final /* synthetic */ KSerializer _childSerializers$_anonymous_$3() {
            StringSerializer r1 = StringSerializer.INSTANCE;
            return new LinkedHashMapSerializer(r1, new ArrayListSerializer(r1));
        }

        public static /* synthetic */ KSerializer a() {
            return _childSerializers$_anonymous_$2();
        }

        public static final /* synthetic */ Lazy[] access$get$childSerializers$cp() {
            return $childSerializers;
        }

        public static /* synthetic */ KSerializer b() {
            return _childSerializers$_anonymous_$3();
        }

        public static /* synthetic */ KSerializer c() {
            return _childSerializers$_anonymous_$0();
        }

        public static /* synthetic */ DesignPrint copy$default(DesignPrint r19, long r20, String r22, Long r23, Long r24, boolean r25, Integer r26, Integer r27, String r28, String r29, String r30, boolean r31, String r32, String r33, String r34, int r35, boolean r36, String r37, String r38, String r39, String r40, String r41, String r42, boolean r43, Boolean r44, String r45, String r46, String r47, String r48, Map r49, List r50, List r51, List r52, Map r53, String r54, Long r55, int r56, int r57, Object r58) {
            if ((r56 & 1) == 0) goto L5;
            long r2 = r19.profileId;
        L7:
            if ((r56 & 2) == 0) goto L9;
            String r4 = r19.modelId;
        L11:
            if ((r56 & 4) == 0) goto L13;
            Long r5 = r19.designId;
        L15:
            if ((r56 & 8) == 0) goto L17;
            Long r6 = r19.instanceId;
        L19:
            if ((r56 & 16) == 0) goto L21;
            boolean r7 = r19.isPublicProfile;
        L23:
            if ((r56 & 32) == 0) goto L25;
            Integer r8 = r19.plateIndex;
        L27:
            if ((r56 & 64) == 0) goto L29;
            Integer r9 = r19.choosePlateIndex;
        L31:
            if ((r56 & 128) == 0) goto L33;
            String r10 = r19.mode;
        L35:
            if ((r56 & 256) == 0) goto L37;
            String r11 = r19.lastUsedDeviceId;
        L39:
            if ((r56 & 512) == 0) goto L41;
            String r12 = r19.sourceFrom;
        L43:
            if ((r56 & 1024) == 0) goto L45;
            boolean r13 = r19.enableAddToQueue;
        L47:
            if ((r56 & 2048) == 0) goto L49;
            String r14 = r19.designTitle;
        L51:
            if ((r56 & 4096) == 0) goto L53;
            String r15 = r19.profileCover;
        L54:
            long r16 = r2;
            if ((r56 & 8192) == 0) goto L57;
            String r210 = r19.plateId;
        L59:
            if ((r56 & 16384) == 0) goto L61;
            int r3 = r19.repetitions;
        L63:
            if ((r56 & Constants.EAR_MONITORING_FILTER_REUSE_POST_PROCESSING_FILTER) == 0) goto L65;
            boolean r1 = r19.isMultiProfile;
        L66:
            boolean r202 = r1;
            if ((r56 & 65536) == 0) goto L69;
            String r17 = r19.gcodeBedType;
        L70:
            String r21 = r17;
            if ((r56 & 131072) == 0) goto L73;
            String r18 = r19.bizType;
        L74:
            String r222 = r18;
            if ((r56 & 262144) == 0) goto L77;
            String r110 = r19.bizKey;
        L78:
            String r232 = r110;
            if ((r56 & CommonNetImpl.MAX_SEND_SIZE_IN_KB) == 0) goto L81;
            String r111 = r19.unikey;
        L82:
            String r242 = r111;
            if ((r56 & 1048576) == 0) goto L85;
            String r112 = r19.historyId;
        L86:
            String r252 = r112;
            if ((r56 & 2097152) == 0) goto L89;
            String r113 = r19.tool;
        L90:
            String r262 = r113;
            if ((r56 & 4194304) == 0) goto L93;
            boolean r114 = r19.nextPlate;
        L94:
            boolean r272 = r114;
            if ((r56 & AudioRoutingController.DEVICE_OUTPUT_OUT_IP) == 0) goto L97;
            Boolean r115 = r19.useAms;
        L98:
            Boolean r282 = r115;
            if ((r56 & CommonNetImpl.FLAG_SHARE_EDIT) == 0) goto L101;
            String r116 = r19.filamentSettingIds;
        L102:
            String r292 = r116;
            if ((r56 & CommonNetImpl.FLAG_SHARE_JUMP) == 0) goto L105;
            String r117 = r19.matchFilamentMode;
        L106:
            String r302 = r117;
            if ((r56 & AudioRoutingController.DEVICE_OUT_USB_HEADSET) == 0) goto L109;
            String r118 = r19.skipObjects;
        L110:
            String r312 = r118;
            if ((r56 & 134217728) == 0) goto L113;
            String r119 = r19.refreshId;
        L114:
            String r322 = r119;
            if ((r56 & CommonNetImpl.FLAG_AUTH) == 0) goto L117;
            Map r120 = r19.initialFilamentArgbById;
        L118:
            Map r332 = r120;
            if ((r56 & CommonNetImpl.FLAG_SHARE) == 0) goto L121;
            List r121 = r19.lastAmsMapping;
        L122:
            List r342 = r121;
            if ((r56 & 1073741824) == 0) goto L125;
            List r122 = r19.lastAmsDetailMapping;
        L126:
            List r352 = r122;
            if ((r56 & Integer.MIN_VALUE) == 0) goto L129;
            List r123 = r19.lastNozzleInfos;
        L130:
            List r362 = r123;
            if ((r57 & 1) == 0) goto L133;
            Map r124 = r19.lastSliceCfg;
        L134:
            Map r372 = r124;
            if ((r57 & 2) == 0) goto L137;
            String r125 = r19.collectionFrom;
        L139:
            if ((r57 & 4) == 0) goto L141;
            String r382 = r125;
            String r552 = r382;
            Long r562 = r19.syncDesignId;
            String r392 = r222;
            String r402 = r232;
            String r412 = r242;
            String r422 = r252;
            String r432 = r262;
            boolean r442 = r272;
            Boolean r452 = r282;
            String r462 = r292;
            String r472 = r302;
            String r482 = r312;
            String r492 = r322;
            Map r502 = r332;
            List r512 = r342;
            List r522 = r352;
            List r532 = r362;
            Map r542 = r372;
            String r353 = r210;
            int r363 = r3;
            String r233 = r4;
            Long r243 = r5;
            Long r253 = r6;
            boolean r263 = r7;
            Integer r273 = r8;
            Integer r283 = r9;
            String r293 = r10;
            String r303 = r11;
            String r313 = r12;
            boolean r323 = r13;
            String r333 = r14;
            String r343 = r15;
            boolean r373 = r202;
            String r383 = r21;
            DesignPrint r203 = r19;
            long r212 = r16;
        L143:
            return r203.copy(r212, r233, r243, r253, r263, r273, r283, r293, r303, r313, r323, r333, r343, r353, r363, r373, r383, r392, r402, r412, r422, r432, r442, r452, r462, r472, r482, r492, r502, r512, r522, r532, r542, r552, r562);
        L141:
            r562 = r55;
            r552 = r125;
            r383 = r21;
            r392 = r222;
            r402 = r232;
            r412 = r242;
            r422 = r252;
            r432 = r262;
            r442 = r272;
            r452 = r282;
            r462 = r292;
            r472 = r302;
            r482 = r312;
            r492 = r322;
            r502 = r332;
            r512 = r342;
            r522 = r352;
            r532 = r362;
            r542 = r372;
            r353 = r210;
            r363 = r3;
            r233 = r4;
            r243 = r5;
            r253 = r6;
            r263 = r7;
            r273 = r8;
            r283 = r9;
            r293 = r10;
            r303 = r11;
            r313 = r12;
            r323 = r13;
            r333 = r14;
            r343 = r15;
            r212 = r16;
            r373 = r202;
            r203 = r19;
            goto L143
        L137:
            r125 = r54;
            goto L139
        L133:
            r124 = r53;
            goto L134
        L129:
            r123 = r52;
            goto L130
        L125:
            r122 = r51;
            goto L126
        L121:
            r121 = r50;
            goto L122
        L117:
            r120 = r49;
            goto L118
        L113:
            r119 = r48;
            goto L114
        L109:
            r118 = r47;
            goto L110
        L105:
            r117 = r46;
            goto L106
        L101:
            r116 = r45;
            goto L102
        L97:
            r115 = r44;
            goto L98
        L93:
            r114 = r43;
            goto L94
        L89:
            r113 = r42;
            goto L90
        L85:
            r112 = r41;
            goto L86
        L81:
            r111 = r40;
            goto L82
        L77:
            r110 = r39;
            goto L78
        L73:
            r18 = r38;
            goto L74
        L69:
            r17 = r37;
            goto L70
        L65:
            r1 = r36;
            goto L66
        L61:
            r3 = r35;
            goto L63
        L57:
            r210 = r34;
            goto L59
        L53:
            r15 = r33;
            goto L54
        L49:
            r14 = r32;
            goto L51
        L45:
            r13 = r31;
            goto L47
        L41:
            r12 = r30;
            goto L43
        L37:
            r11 = r29;
            goto L39
        L33:
            r10 = r28;
            goto L35
        L29:
            r9 = r27;
            goto L31
        L25:
            r8 = r26;
            goto L27
        L21:
            r7 = r25;
            goto L23
        L17:
            r6 = r24;
            goto L19
        L13:
            r5 = r23;
            goto L15
        L9:
            r4 = r22;
            goto L11
        L5:
            r2 = r20;
            goto L7
        }

        public static /* synthetic */ KSerializer d() {
            return _childSerializers$_anonymous_();
        }

        public static /* synthetic */ KSerializer e() {
            return _childSerializers$_anonymous_$1();
        }

        @o0g
        public static final /* synthetic */ void write$Self$navigation(DesignPrint r5, CompositeEncoder r6, SerialDescriptor r7) {
            Lazy<KSerializer<Object>>[] r0 = $childSerializers;
            r6.encodeLongElement(r7, 0, r5.profileId);
            if (r6.shouldEncodeElementDefault(r7, 1) == false) goto L6;
        L7:
            r6.encodeNullableSerializableElement(r7, 1, StringSerializer.INSTANCE, r5.modelId);
        L9:
            if (r6.shouldEncodeElementDefault(r7, 2) == false) goto L12;
        L13:
            r6.encodeNullableSerializableElement(r7, 2, LongSerializer.INSTANCE, r5.designId);
        L15:
            if (r6.shouldEncodeElementDefault(r7, 3) == false) goto L18;
        L19:
            r6.encodeNullableSerializableElement(r7, 3, LongSerializer.INSTANCE, r5.instanceId);
        L21:
            if (r6.shouldEncodeElementDefault(r7, 4) == false) goto L24;
        L25:
            r6.encodeBooleanElement(r7, 4, r5.isPublicProfile);
        L27:
            if (r6.shouldEncodeElementDefault(r7, 5) == false) goto L30;
        L31:
            r6.encodeNullableSerializableElement(r7, 5, IntSerializer.INSTANCE, r5.plateIndex);
        L33:
            if (r6.shouldEncodeElementDefault(r7, 6) == false) goto L36;
        L37:
            r6.encodeNullableSerializableElement(r7, 6, IntSerializer.INSTANCE, r5.choosePlateIndex);
        L39:
            if (r6.shouldEncodeElementDefault(r7, 7) == false) goto L42;
        L43:
            r6.encodeStringElement(r7, 7, r5.mode);
        L45:
            if (r6.shouldEncodeElementDefault(r7, 8) == false) goto L48;
        L49:
            r6.encodeStringElement(r7, 8, r5.lastUsedDeviceId);
        L51:
            if (r6.shouldEncodeElementDefault(r7, 9) == false) goto L54;
        L55:
            r6.encodeNullableSerializableElement(r7, 9, StringSerializer.INSTANCE, r5.sourceFrom);
        L57:
            if (r6.shouldEncodeElementDefault(r7, 10) == false) goto L60;
        L61:
            r6.encodeBooleanElement(r7, 10, r5.enableAddToQueue);
        L63:
            if (r6.shouldEncodeElementDefault(r7, 11) == false) goto L66;
        L67:
            r6.encodeNullableSerializableElement(r7, 11, StringSerializer.INSTANCE, r5.designTitle);
        L69:
            if (r6.shouldEncodeElementDefault(r7, 12) == false) goto L72;
        L73:
            r6.encodeNullableSerializableElement(r7, 12, StringSerializer.INSTANCE, r5.profileCover);
        L75:
            if (r6.shouldEncodeElementDefault(r7, 13) == false) goto L78;
        L79:
            r6.encodeNullableSerializableElement(r7, 13, StringSerializer.INSTANCE, r5.plateId);
        L81:
            if (r6.shouldEncodeElementDefault(r7, 14) == false) goto L84;
        L85:
            r6.encodeIntElement(r7, 14, r5.repetitions);
        L87:
            if (r6.shouldEncodeElementDefault(r7, 15) == false) goto L90;
        L91:
            r6.encodeBooleanElement(r7, 15, r5.isMultiProfile);
        L93:
            if (r6.shouldEncodeElementDefault(r7, 16) == false) goto L96;
        L97:
            r6.encodeNullableSerializableElement(r7, 16, StringSerializer.INSTANCE, r5.gcodeBedType);
        L99:
            if (r6.shouldEncodeElementDefault(r7, 17) == false) goto L102;
        L103:
            r6.encodeNullableSerializableElement(r7, 17, StringSerializer.INSTANCE, r5.bizType);
        L105:
            if (r6.shouldEncodeElementDefault(r7, 18) == false) goto L108;
        L109:
            r6.encodeNullableSerializableElement(r7, 18, StringSerializer.INSTANCE, r5.bizKey);
        L111:
            if (r6.shouldEncodeElementDefault(r7, 19) == false) goto L114;
        L115:
            r6.encodeNullableSerializableElement(r7, 19, StringSerializer.INSTANCE, r5.unikey);
        L117:
            if (r6.shouldEncodeElementDefault(r7, 20) == false) goto L120;
        L121:
            r6.encodeNullableSerializableElement(r7, 20, StringSerializer.INSTANCE, r5.historyId);
        L123:
            if (r6.shouldEncodeElementDefault(r7, 21) == false) goto L126;
        L127:
            r6.encodeNullableSerializableElement(r7, 21, StringSerializer.INSTANCE, r5.tool);
        L129:
            if (r6.shouldEncodeElementDefault(r7, 22) == false) goto L132;
        L133:
            r6.encodeBooleanElement(r7, 22, r5.nextPlate);
        L135:
            if (r6.shouldEncodeElementDefault(r7, 23) == false) goto L138;
        L139:
            r6.encodeNullableSerializableElement(r7, 23, BooleanSerializer.INSTANCE, r5.useAms);
        L141:
            if (r6.shouldEncodeElementDefault(r7, 24) == false) goto L144;
        L145:
            r6.encodeNullableSerializableElement(r7, 24, StringSerializer.INSTANCE, r5.filamentSettingIds);
        L147:
            if (r6.shouldEncodeElementDefault(r7, 25) == false) goto L150;
        L151:
            r6.encodeNullableSerializableElement(r7, 25, StringSerializer.INSTANCE, r5.matchFilamentMode);
        L153:
            if (r6.shouldEncodeElementDefault(r7, 26) == false) goto L156;
        L157:
            r6.encodeNullableSerializableElement(r7, 26, StringSerializer.INSTANCE, r5.skipObjects);
        L159:
            if (r6.shouldEncodeElementDefault(r7, 27) == false) goto L162;
        L163:
            r6.encodeNullableSerializableElement(r7, 27, StringSerializer.INSTANCE, r5.refreshId);
        L165:
            if (r6.shouldEncodeElementDefault(r7, 28) == false) goto L168;
        L169:
            r6.encodeSerializableElement(r7, 28, (SerializationStrategy) r0[28].getValue(), r5.initialFilamentArgbById);
        L170:
            boolean r2 = r6.shouldEncodeElementDefault(r7, 29);
            egb r3 = egb.a;
            if (r2 == false) goto L174;
        L175:
            r6.encodeSerializableElement(r7, 29, (SerializationStrategy) r0[29].getValue(), r5.lastAmsMapping);
        L177:
            if (r6.shouldEncodeElementDefault(r7, 30) == false) goto L180;
        L181:
            r6.encodeSerializableElement(r7, 30, (SerializationStrategy) r0[30].getValue(), r5.lastAmsDetailMapping);
        L183:
            if (r6.shouldEncodeElementDefault(r7, 31) == false) goto L186;
        L187:
            r6.encodeSerializableElement(r7, 31, (SerializationStrategy) r0[31].getValue(), r5.lastNozzleInfos);
        L189:
            if (r6.shouldEncodeElementDefault(r7, 32) == false) goto L192;
        L193:
            r6.encodeNullableSerializableElement(r7, 32, (SerializationStrategy) r0[32].getValue(), r5.lastSliceCfg);
        L195:
            if (r6.shouldEncodeElementDefault(r7, 33) == false) goto L198;
        L199:
            r6.encodeNullableSerializableElement(r7, 33, StringSerializer.INSTANCE, r5.collectionFrom);
        L201:
            if (r6.shouldEncodeElementDefault(r7, 34) == false) goto L204;
        L205:
            r6.encodeNullableSerializableElement(r7, 34, LongSerializer.INSTANCE, r5.syncDesignId);
            return;
        L204:
            if (r5.syncDesignId != null) goto L205;
            return;
        L198:
            if (r5.collectionFrom == null) goto L201;
        L192:
            if (r5.lastSliceCfg == null) goto L195;
        L186:
            if (lsf.l(r5.lastNozzleInfos, r3) == true) goto L189;
        L180:
            if (lsf.l(r5.lastAmsDetailMapping, r3) == true) goto L183;
        L174:
            if (lsf.l(r5.lastAmsMapping, r3) == true) goto L177;
        L168:
            if (lsf.l(r5.initialFilamentArgbById, fgb.a) == true) goto L170;
        L162:
            if (r5.refreshId == null) goto L165;
        L156:
            if (r5.skipObjects == null) goto L159;
        L150:
            if (r5.matchFilamentMode == null) goto L153;
        L144:
            if (r5.filamentSettingIds == null) goto L147;
        L138:
            if (r5.useAms == null) goto L141;
        L132:
            if (r5.nextPlate == false) goto L135;
        L126:
            if (r5.tool == null) goto L129;
        L120:
            if (r5.historyId == null) goto L123;
        L114:
            if (r5.unikey == null) goto L117;
        L108:
            if (r5.bizKey == null) goto L111;
        L102:
            if (r5.bizType == null) goto L105;
        L96:
            if (r5.gcodeBedType == null) goto L99;
        L90:
            if (r5.isMultiProfile == false) goto L93;
        L84:
            if (r5.repetitions == 1) goto L87;
        L78:
            if (r5.plateId == null) goto L81;
        L72:
            if (r5.profileCover == null) goto L75;
        L66:
            if (r5.designTitle == null) goto L69;
        L60:
            if (r5.enableAddToQueue == false) goto L63;
        L54:
            if (r5.sourceFrom == null) goto L57;
        L48:
            if (lsf.l(r5.lastUsedDeviceId, "") == true) goto L51;
        L42:
            if (lsf.l(r5.mode, PrintHistoryModel.MODE_CLOUD_SLICE) == true) goto L45;
        L36:
            if (r5.choosePlateIndex == null) goto L39;
        L30:
            if (r5.plateIndex == null) goto L33;
        L24:
            if (r5.isPublicProfile == true) goto L27;
        L18:
            if (r5.instanceId == null) goto L21;
        L12:
            if (r5.designId == null) goto L15;
        L6:
            if (r5.modelId == null) goto L9;
            goto L7
        }

        public final long component1() {
            return this.profileId;
        }

        public final String component10() {
            return this.sourceFrom;
        }

        public final boolean component11() {
            return this.enableAddToQueue;
        }

        public final String component12() {
            return this.designTitle;
        }

        public final String component13() {
            return this.profileCover;
        }

        public final String component14() {
            return this.plateId;
        }

        public final int component15() {
            return this.repetitions;
        }

        public final boolean component16() {
            return this.isMultiProfile;
        }

        public final String component17() {
            return this.gcodeBedType;
        }

        public final String component18() {
            return this.bizType;
        }

        public final String component19() {
            return this.bizKey;
        }

        public final String component2() {
            return this.modelId;
        }

        public final String component20() {
            return this.unikey;
        }

        public final String component21() {
            return this.historyId;
        }

        public final String component22() {
            return this.tool;
        }

        public final boolean component23() {
            return this.nextPlate;
        }

        public final Boolean component24() {
            return this.useAms;
        }

        public final String component25() {
            return this.filamentSettingIds;
        }

        public final String component26() {
            return this.matchFilamentMode;
        }

        public final String component27() {
            return this.skipObjects;
        }

        public final String component28() {
            return this.refreshId;
        }

        public final Map<Integer, Long> component29() {
            return this.initialFilamentArgbById;
        }

        public final Long component3() {
            return this.designId;
        }

        public final List<AmsDetailMapping> component30() {
            return this.lastAmsMapping;
        }

        public final List<AmsDetailMapping> component31() {
            return this.lastAmsDetailMapping;
        }

        public final List<PrintNozzleInfo> component32() {
            return this.lastNozzleInfos;
        }

        public final Map<String, List<String>> component33() {
            return this.lastSliceCfg;
        }

        public final String component34() {
            return this.collectionFrom;
        }

        public final Long component35() {
            return this.syncDesignId;
        }

        public final Long component4() {
            return this.instanceId;
        }

        public final boolean component5() {
            return this.isPublicProfile;
        }

        public final Integer component6() {
            return this.plateIndex;
        }

        public final Integer component7() {
            return this.choosePlateIndex;
        }

        public final String component8() {
            return this.mode;
        }

        public final String component9() {
            return this.lastUsedDeviceId;
        }

        public final DesignPrint copy(long r38, String r40, Long r41, Long r42, boolean r43, Integer r44, Integer r45, String r46, String r47, String r48, boolean r49, String r50, String r51, String r52, int r53, boolean r54, String r55, String r56, String r57, String r58, String r59, String r60, boolean r61, Boolean r62, String r63, String r64, String r65, String r66, Map<Integer, Long> r67, List<AmsDetailMapping> r68, List<AmsDetailMapping> r69, List<PrintNozzleInfo> r70, Map<String, ? extends List<String>> r71, String r72, Long r73) {
            r46.getClass();
            r47.getClass();
            r67.getClass();
            r68.getClass();
            r69.getClass();
            r70.getClass();
            return new DesignPrint(r38, r40, r41, r42, r43, r44, r45, r46, r47, r48, r49, r50, r51, r52, r53, r54, r55, r56, r57, r58, r59, r60, r61, r62, r63, r64, r65, r66, r67, r68, r69, r70, r71, r72, r73);
        }

        public boolean equals(Object r8) {
            if (this != r8) goto L6;
            return true;
        L6:
            if ((r8 instanceof DesignPrint) == true) goto L8;
            return false;
        L8:
            DesignPrint r82 = (DesignPrint) r8;
            if (this.profileId == r82.profileId) goto L12;
            return false;
        L12:
            if (lsf.l(this.modelId, r82.modelId) == true) goto L15;
            return false;
        L15:
            if (lsf.l(this.designId, r82.designId) == true) goto L18;
            return false;
        L18:
            if (lsf.l(this.instanceId, r82.instanceId) == true) goto L21;
            return false;
        L21:
            if (this.isPublicProfile == r82.isPublicProfile) goto L24;
            return false;
        L24:
            if (lsf.l(this.plateIndex, r82.plateIndex) == true) goto L27;
            return false;
        L27:
            if (lsf.l(this.choosePlateIndex, r82.choosePlateIndex) == true) goto L30;
            return false;
        L30:
            if (lsf.l(this.mode, r82.mode) == true) goto L33;
            return false;
        L33:
            if (lsf.l(this.lastUsedDeviceId, r82.lastUsedDeviceId) == true) goto L36;
            return false;
        L36:
            if (lsf.l(this.sourceFrom, r82.sourceFrom) == true) goto L39;
            return false;
        L39:
            if (this.enableAddToQueue == r82.enableAddToQueue) goto L42;
            return false;
        L42:
            if (lsf.l(this.designTitle, r82.designTitle) == true) goto L45;
            return false;
        L45:
            if (lsf.l(this.profileCover, r82.profileCover) == true) goto L48;
            return false;
        L48:
            if (lsf.l(this.plateId, r82.plateId) == true) goto L51;
            return false;
        L51:
            if (this.repetitions == r82.repetitions) goto L54;
            return false;
        L54:
            if (this.isMultiProfile == r82.isMultiProfile) goto L57;
            return false;
        L57:
            if (lsf.l(this.gcodeBedType, r82.gcodeBedType) == true) goto L60;
            return false;
        L60:
            if (lsf.l(this.bizType, r82.bizType) == true) goto L63;
            return false;
        L63:
            if (lsf.l(this.bizKey, r82.bizKey) == true) goto L66;
            return false;
        L66:
            if (lsf.l(this.unikey, r82.unikey) == true) goto L69;
            return false;
        L69:
            if (lsf.l(this.historyId, r82.historyId) == true) goto L72;
            return false;
        L72:
            if (lsf.l(this.tool, r82.tool) == true) goto L75;
            return false;
        L75:
            if (this.nextPlate == r82.nextPlate) goto L78;
            return false;
        L78:
            if (lsf.l(this.useAms, r82.useAms) == true) goto L81;
            return false;
        L81:
            if (lsf.l(this.filamentSettingIds, r82.filamentSettingIds) == true) goto L84;
            return false;
        L84:
            if (lsf.l(this.matchFilamentMode, r82.matchFilamentMode) == true) goto L87;
            return false;
        L87:
            if (lsf.l(this.skipObjects, r82.skipObjects) == true) goto L90;
            return false;
        L90:
            if (lsf.l(this.refreshId, r82.refreshId) == true) goto L93;
            return false;
        L93:
            if (lsf.l(this.initialFilamentArgbById, r82.initialFilamentArgbById) == true) goto L96;
            return false;
        L96:
            if (lsf.l(this.lastAmsMapping, r82.lastAmsMapping) == true) goto L99;
            return false;
        L99:
            if (lsf.l(this.lastAmsDetailMapping, r82.lastAmsDetailMapping) == true) goto L102;
            return false;
        L102:
            if (lsf.l(this.lastNozzleInfos, r82.lastNozzleInfos) == true) goto L105;
            return false;
        L105:
            if (lsf.l(this.lastSliceCfg, r82.lastSliceCfg) == true) goto L108;
            return false;
        L108:
            if (lsf.l(this.collectionFrom, r82.collectionFrom) == true) goto L111;
            return false;
        L111:
            if (lsf.l(this.syncDesignId, r82.syncDesignId) == true) goto L113;
            return false;
        L113:
            return true;
        }

        public final String getBizKey() {
            return this.bizKey;
        }

        public final String getBizType() {
            return this.bizType;
        }

        public final Integer getChoosePlateIndex() {
            return this.choosePlateIndex;
        }

        public final String getCollectionFrom() {
            return this.collectionFrom;
        }

        public final Long getDesignId() {
            return this.designId;
        }

        public final String getDesignTitle() {
            return this.designTitle;
        }

        public final boolean getEnableAddToQueue() {
            return this.enableAddToQueue;
        }

        public final String getFilamentSettingIds() {
            return this.filamentSettingIds;
        }

        public final String getGcodeBedType() {
            return this.gcodeBedType;
        }

        public final String getHistoryId() {
            return this.historyId;
        }

        public final Map<Integer, Long> getInitialFilamentArgbById() {
            return this.initialFilamentArgbById;
        }

        public final Long getInstanceId() {
            return this.instanceId;
        }

        public final List<AmsDetailMapping> getLastAmsDetailMapping() {
            return this.lastAmsDetailMapping;
        }

        public final List<AmsDetailMapping> getLastAmsMapping() {
            return this.lastAmsMapping;
        }

        public final List<PrintNozzleInfo> getLastNozzleInfos() {
            return this.lastNozzleInfos;
        }

        public final Map<String, List<String>> getLastSliceCfg() {
            return this.lastSliceCfg;
        }

        public final String getLastUsedDeviceId() {
            return this.lastUsedDeviceId;
        }

        public final String getMatchFilamentMode() {
            return this.matchFilamentMode;
        }

        public final String getMode() {
            return this.mode;
        }

        public final String getModelId() {
            return this.modelId;
        }

        public final boolean getNextPlate() {
            return this.nextPlate;
        }

        public final String getPlateId() {
            return this.plateId;
        }

        public final Integer getPlateIndex() {
            return this.plateIndex;
        }

        public final String getProfileCover() {
            return this.profileCover;
        }

        public final long getProfileId() {
            return this.profileId;
        }

        public final String getRefreshId() {
            return this.refreshId;
        }

        public final int getRepetitions() {
            return this.repetitions;
        }

        public final String getSkipObjects() {
            return this.skipObjects;
        }

        public final String getSourceFrom() {
            return this.sourceFrom;
        }

        public final Long getSyncDesignId() {
            return this.syncDesignId;
        }

        public final String getTool() {
            return this.tool;
        }

        public final String getUnikey() {
            return this.unikey;
        }

        public final Boolean getUseAms() {
            return this.useAms;
        }

        public int hashCode() {
            int r0 = Long.hashCode(this.profileId) * 31;
            String r2 = this.modelId;
            int r3 = 0;
            if (r2 != null) goto L5;
            int r22 = 0;
        L6:
            int r02 = (r0 + r22) * 31;
            Long r23 = this.designId;
            if (r23 != null) goto L9;
            int r24 = 0;
        L10:
            int r03 = (r02 + r24) * 31;
            Long r25 = this.instanceId;
            if (r25 != null) goto L13;
            int r26 = 0;
        L14:
            int r04 = b0r.c((r03 + r26) * 31, 31, this.isPublicProfile);
            Integer r27 = this.plateIndex;
            if (r27 != null) goto L17;
            int r28 = 0;
        L18:
            int r05 = (r04 + r28) * 31;
            Integer r29 = this.choosePlateIndex;
            if (r29 != null) goto L21;
            int r210 = 0;
        L22:
            int r06 = b0r.b(b0r.b((r05 + r210) * 31, 31, this.mode), 31, this.lastUsedDeviceId);
            String r211 = this.sourceFrom;
            if (r211 != null) goto L25;
            int r212 = 0;
        L26:
            int r07 = b0r.c((r06 + r212) * 31, 31, this.enableAddToQueue);
            String r213 = this.designTitle;
            if (r213 != null) goto L29;
            int r214 = 0;
        L30:
            int r08 = (r07 + r214) * 31;
            String r215 = this.profileCover;
            if (r215 != null) goto L33;
            int r216 = 0;
        L34:
            int r09 = (r08 + r216) * 31;
            String r217 = this.plateId;
            if (r217 != null) goto L37;
            int r218 = 0;
        L38:
            int r010 = b0r.c(r77.a(this.repetitions, (r09 + r218) * 31, 31), 31, this.isMultiProfile);
            String r219 = this.gcodeBedType;
            if (r219 != null) goto L41;
            int r220 = 0;
        L42:
            int r011 = (r010 + r220) * 31;
            String r221 = this.bizType;
            if (r221 != null) goto L45;
            int r222 = 0;
        L46:
            int r012 = (r011 + r222) * 31;
            String r223 = this.bizKey;
            if (r223 != null) goto L49;
            int r224 = 0;
        L50:
            int r013 = (r012 + r224) * 31;
            String r225 = this.unikey;
            if (r225 != null) goto L53;
            int r226 = 0;
        L54:
            int r014 = (r013 + r226) * 31;
            String r227 = this.historyId;
            if (r227 != null) goto L57;
            int r228 = 0;
        L58:
            int r015 = (r014 + r228) * 31;
            String r229 = this.tool;
            if (r229 != null) goto L61;
            int r230 = 0;
        L62:
            int r016 = b0r.c((r015 + r230) * 31, 31, this.nextPlate);
            Boolean r231 = this.useAms;
            if (r231 != null) goto L65;
            int r232 = 0;
        L66:
            int r017 = (r016 + r232) * 31;
            String r233 = this.filamentSettingIds;
            if (r233 != null) goto L69;
            int r234 = 0;
        L70:
            int r018 = (r017 + r234) * 31;
            String r235 = this.matchFilamentMode;
            if (r235 != null) goto L73;
            int r236 = 0;
        L74:
            int r019 = (r018 + r236) * 31;
            String r237 = this.skipObjects;
            if (r237 != null) goto L77;
            int r238 = 0;
        L78:
            int r020 = (r019 + r238) * 31;
            String r239 = this.refreshId;
            if (r239 != null) goto L81;
            int r240 = 0;
        L82:
            int r021 = kn2.b(kn2.b(kn2.b(por.h((r020 + r240) * 31, 31, this.initialFilamentArgbById), 31, this.lastAmsMapping), 31, this.lastAmsDetailMapping), 31, this.lastNozzleInfos);
            Map<String, List<String>> r241 = this.lastSliceCfg;
            if (r241 != null) goto L85;
            int r242 = 0;
        L86:
            int r022 = (r021 + r242) * 31;
            String r243 = this.collectionFrom;
            if (r243 != null) goto L89;
            int r244 = 0;
        L90:
            int r023 = (r022 + r244) * 31;
            Long r4 = this.syncDesignId;
            if (r4 == null) goto L95;
            r3 = r4.hashCode();
        L95:
            return r023 + r3;
        L89:
            r244 = r243.hashCode();
            goto L90
        L85:
            r242 = r241.hashCode();
            goto L86
        L81:
            r240 = r239.hashCode();
            goto L82
        L77:
            r238 = r237.hashCode();
            goto L78
        L73:
            r236 = r235.hashCode();
            goto L74
        L69:
            r234 = r233.hashCode();
            goto L70
        L65:
            r232 = r231.hashCode();
            goto L66
        L61:
            r230 = r229.hashCode();
            goto L62
        L57:
            r228 = r227.hashCode();
            goto L58
        L53:
            r226 = r225.hashCode();
            goto L54
        L49:
            r224 = r223.hashCode();
            goto L50
        L45:
            r222 = r221.hashCode();
            goto L46
        L41:
            r220 = r219.hashCode();
            goto L42
        L37:
            r218 = r217.hashCode();
            goto L38
        L33:
            r216 = r215.hashCode();
            goto L34
        L29:
            r214 = r213.hashCode();
            goto L30
        L25:
            r212 = r211.hashCode();
            goto L26
        L21:
            r210 = r29.hashCode();
            goto L22
        L17:
            r28 = r27.hashCode();
            goto L18
        L13:
            r26 = r25.hashCode();
            goto L14
        L9:
            r24 = r23.hashCode();
            goto L10
        L5:
            r22 = r2.hashCode();
            goto L6
        }

        public final boolean isMultiProfile() {
            return this.isMultiProfile;
        }

        public final boolean isPublicProfile() {
            return this.isPublicProfile;
        }

        public String toString() {
            long r1 = this.profileId;
            String r3 = this.modelId;
            Long r4 = this.designId;
            Long r5 = this.instanceId;
            boolean r6 = this.isPublicProfile;
            Integer r7 = this.plateIndex;
            Integer r8 = this.choosePlateIndex;
            String r9 = this.mode;
            String r10 = this.lastUsedDeviceId;
            String r11 = this.sourceFrom;
            boolean r12 = this.enableAddToQueue;
            String r13 = this.designTitle;
            String r14 = this.profileCover;
            String r15 = this.plateId;
            int r142 = this.repetitions;
            boolean r143 = this.isMultiProfile;
            String r144 = this.gcodeBedType;
            String r145 = this.bizType;
            String r146 = this.bizKey;
            String r147 = this.unikey;
            String r148 = this.historyId;
            String r149 = this.tool;
            boolean r1410 = this.nextPlate;
            Boolean r1411 = this.useAms;
            String r1412 = this.filamentSettingIds;
            String r1413 = this.matchFilamentMode;
            String r1414 = this.skipObjects;
            String r1415 = this.refreshId;
            Map<Integer, Long> r1416 = this.initialFilamentArgbById;
            List<AmsDetailMapping> r1417 = this.lastAmsMapping;
            List<AmsDetailMapping> r1418 = this.lastAmsDetailMapping;
            List<PrintNozzleInfo> r1419 = this.lastNozzleInfos;
            Map<String, List<String>> r1420 = this.lastSliceCfg;
            String r1421 = this.collectionFrom;
            Long r0 = this.syncDesignId;
            StringBuilder r02 = i3e.j(r1, "DesignPrint(profileId=", ", modelId=", r3);
            r02.append(", designId=");
            r02.append(r4);
            r02.append(", instanceId=");
            r02.append(r5);
            r02.append(", isPublicProfile=");
            r02.append(r6);
            r02.append(", plateIndex=");
            r02.append(r7);
            r02.append(", choosePlateIndex=");
            r02.append(r8);
            r02.append(", mode=");
            r02.append(r9);
            r77.C(r02, ", lastUsedDeviceId=", r10, ", sourceFrom=", r11);
            r02.append(", enableAddToQueue=");
            r02.append(r12);
            r02.append(", designTitle=");
            r02.append(r13);
            r77.C(r02, ", profileCover=", r14, ", plateId=", r15);
            r02.append(", repetitions=");
            r02.append(r142);
            r02.append(", isMultiProfile=");
            r02.append(r143);
            r77.C(r02, ", gcodeBedType=", r144, ", bizType=", r145);
            r77.C(r02, ", bizKey=", r146, ", unikey=", r147);
            r77.C(r02, ", historyId=", r148, ", tool=", r149);
            r02.append(", nextPlate=");
            r02.append(r1410);
            r02.append(", useAms=");
            r02.append(r1411);
            r77.C(r02, ", filamentSettingIds=", r1412, ", matchFilamentMode=", r1413);
            r77.C(r02, ", skipObjects=", r1414, ", refreshId=", r1415);
            r02.append(", initialFilamentArgbById=");
            r02.append(r1416);
            r02.append(", lastAmsMapping=");
            r02.append(r1417);
            r02.append(", lastAmsDetailMapping=");
            r02.append(r1418);
            r02.append(", lastNozzleInfos=");
            r02.append(r1419);
            r02.append(", lastSliceCfg=");
            r02.append(r1420);
            r02.append(", collectionFrom=");
            r02.append(r1421);
            r02.append(", syncDesignId=");
            r02.append(r0);
            r02.append(")");
            return r02.toString();
        }
    }

    @Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u0000\n\u0002\b\u0013\b\u0087\b\u0018\u0000 ?2\u00020\u0001:\u0002@ABm\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u0012\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\u0007\u0012\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\n0\u0007\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0010\u0010\u0011By\b\u0010\u0012\u0006\u0010\u0012\u001a\u00020\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u0012\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007\u0012\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0007\u0012\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0007\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013¢\u0006\u0004\b\u0010\u0010\u0015J'\u0010\u001e\u001a\u00020\u001b2\u0006\u0010\u0016\u001a\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u0019H\u0001¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u001f\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u001f\u0010 J\u0012\u0010!\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0004\b!\u0010\"J\u0012\u0010#\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0004\b#\u0010\"J\u0016\u0010$\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0003¢\u0006\u0004\b$\u0010%J\u0016\u0010&\u001a\b\u0012\u0004\u0012\u00020\n0\u0007HÆ\u0003¢\u0006\u0004\b&\u0010%J\u0016\u0010'\u001a\b\u0012\u0004\u0012\u00020\n0\u0007HÆ\u0003¢\u0006\u0004\b'\u0010%J\u0012\u0010(\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0004\b(\u0010\"J\u0010\u0010)\u001a\u00020\u000eHÆ\u0003¢\u0006\u0004\b)\u0010*Jx\u0010+\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00042\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\u00072\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\n0\u00072\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u000f\u001a\u00020\u000eHÆ\u0001¢\u0006\u0004\b+\u0010,J\u0010\u0010-\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b-\u0010\"J\u0010\u0010.\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b.\u0010 J\u001a\u00101\u001a\u00020\u000e2\b\u00100\u001a\u0004\u0018\u00010/HÖ\u0003¢\u0006\u0004\b1\u00102R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u00103\u001a\u0004\b4\u0010 R\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u00105\u001a\u0004\b6\u0010\"R\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0006\u00105\u001a\u0004\b7\u0010\"R\u001d\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0006¢\u0006\f\n\u0004\b\t\u00108\u001a\u0004\b9\u0010%R\u001d\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\u00078\u0006¢\u0006\f\n\u0004\b\u000b\u00108\u001a\u0004\b:\u0010%R\u001d\u0010\f\u001a\b\u0012\u0004\u0012\u00020\n0\u00078\u0006¢\u0006\f\n\u0004\b\f\u00108\u001a\u0004\b;\u0010%R\u0019\u0010\r\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\r\u00105\u001a\u0004\b<\u0010\"R\u0017\u0010\u000f\u001a\u00020\u000e8\u0006¢\u0006\f\n\u0004\b\u000f\u0010=\u001a\u0004\b>\u0010*¨\u0006B"}, d2 = {"Lcom/bambulab/bambulab/navigation/route/HomeAppRoute$DesignSkipObjects;", "Lcom/bambulab/bambulab/navigation/route/HomeAppRoute;", "", "plateIndex", "", "pickPictureUrl", "topPictureUrl", "", "Lcom/bambulab/bambulab/model/IotPlateObjectId;", "objects", "", "disabledIds", "selectedIds", "deviceModelName", "", "useMemoryPick", "<init>", "(ILjava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/lang/String;Z)V", "seen0", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "serializationConstructorMarker", "(IILjava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/lang/String;ZLkotlinx/serialization/internal/SerializationConstructorMarker;)V", "self", "Lkotlinx/serialization/encoding/CompositeEncoder;", "output", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "serialDesc", "Ltrs;", "write$Self$navigation", "(Lcom/bambulab/bambulab/navigation/route/HomeAppRoute$DesignSkipObjects;Lkotlinx/serialization/encoding/CompositeEncoder;Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "write$Self", "component1", "()I", "component2", "()Ljava/lang/String;", "component3", "component4", "()Ljava/util/List;", "component5", "component6", "component7", "component8", "()Z", "copy", "(ILjava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/lang/String;Z)Lcom/bambulab/bambulab/navigation/route/HomeAppRoute$DesignSkipObjects;", "toString", "hashCode", "", Request.JsonKeys.OTHER, "equals", "(Ljava/lang/Object;)Z", "I", "getPlateIndex", "Ljava/lang/String;", "getPickPictureUrl", "getTopPictureUrl", "Ljava/util/List;", "getObjects", "getDisabledIds", "getSelectedIds", "getDeviceModelName", "Z", "getUseMemoryPick", "Companion", "com/bambulab/bambulab/navigation/route/u6", "com/bambulab/bambulab/navigation/route/v6", "navigation"}, k = 1, mv = {2, 4, 0}, xi = 48)
    @Serializable
    public static final class DesignSkipObjects implements HomeAppRoute {
        private static final Lazy<KSerializer<Object>>[] $childSerializers = null;
        public static final int $stable = 0;
        public static final v6 Companion = null;
        private final String deviceModelName;
        private final List<Long> disabledIds;
        private final List<IotPlateObjectId> objects;
        private final String pickPictureUrl;
        private final int plateIndex;
        private final List<Long> selectedIds;
        private final String topPictureUrl;
        private final boolean useMemoryPick;

        static {
            Companion = new v6();
            rie r0 = new rie(2);
            lkg r2 = lkg.b;
            $childSerializers = new Lazy[]{null, null, null, z86.y(r2, r0), z86.y(r2, new rie(3)), z86.y(r2, new rie(4)), null, null};
        }

        public /* synthetic */ DesignSkipObjects(int r2, int r3, String r4, String r5, List r6, List r7, List r8, String r9, boolean r10, SerializationConstructorMarker r11) {
            if (1 == (r2 & 1)) goto L5;
            PluginExceptionsKt.throwMissingFieldException(r2, 1, u6.a.getDescriptor());
        L5:
            this.plateIndex = r3;
            if ((r2 & 2) != 0) goto L8;
            this.pickPictureUrl = null;
        L10:
            if ((r2 & 4) != 0) goto L12;
            this.topPictureUrl = null;
        L13:
            int r32 = r2 & 8;
            egb r42 = egb.a;
            if (r32 != 0) goto L16;
            this.objects = r42;
        L18:
            if ((r2 & 16) != 0) goto L20;
            this.disabledIds = r42;
        L22:
            if ((r2 & 32) != 0) goto L24;
            this.selectedIds = r42;
        L26:
            if ((r2 & 64) != 0) goto L28;
            this.deviceModelName = null;
        L30:
            if ((r2 & 128) != 0) goto L33;
            this.useMemoryPick = false;
            return;
        L33:
            this.useMemoryPick = r10;
            return;
        L28:
            this.deviceModelName = r9;
            goto L30
        L24:
            this.selectedIds = r8;
            goto L26
        L20:
            this.disabledIds = r7;
            goto L22
        L16:
            this.objects = r6;
            goto L18
        L12:
            this.topPictureUrl = r5;
            goto L13
        L8:
            this.pickPictureUrl = r4;
            goto L10
        }

        public DesignSkipObjects(int r1, String r2, String r3, List<IotPlateObjectId> r4, List<Long> r5, List<Long> r6, String r7, boolean r8) {
            r4.getClass();
            r5.getClass();
            r6.getClass();
            this.plateIndex = r1;
            this.pickPictureUrl = r2;
            this.topPictureUrl = r3;
            this.objects = r4;
            this.disabledIds = r5;
            this.selectedIds = r6;
            this.deviceModelName = r7;
            this.useMemoryPick = r8;
        }

        public /* synthetic */ DesignSkipObjects(int r3, String r4, String r5, List r6, List r7, List r8, String r9, boolean r10, int r11, DefaultConstructorMarker r12) {
            if ((r11 & 2) == 0) goto L6;
            r4 = null;
        L6:
            if ((r11 & 4) == 0) goto L8;
            r5 = null;
        L8:
            int r122 = r11 & 8;
            egb r1 = egb.a;
            if (r122 == 0) goto L12;
            r6 = r1;
        L12:
            if ((r11 & 16) == 0) goto L15;
            r7 = r1;
        L15:
            if ((r11 & 32) == 0) goto L18;
            r8 = r1;
        L18:
            if ((r11 & 64) == 0) goto L21;
            r9 = null;
        L21:
            if ((r11 & 128) == 0) goto L23;
            r10 = false;
        L23:
            this(r3, r4, r5, r6, r7, r8, r9, r10);
        }

        private static final /* synthetic */ KSerializer _childSerializers$_anonymous_() {
            return new ArrayListSerializer(IotPlateObjectId$$serializer.INSTANCE);
        }

        private static final /* synthetic */ KSerializer _childSerializers$_anonymous_$0() {
            return new ArrayListSerializer(LongSerializer.INSTANCE);
        }

        private static final /* synthetic */ KSerializer _childSerializers$_anonymous_$1() {
            return new ArrayListSerializer(LongSerializer.INSTANCE);
        }

        public static /* synthetic */ KSerializer a() {
            return _childSerializers$_anonymous_$0();
        }

        public static final /* synthetic */ Lazy[] access$get$childSerializers$cp() {
            return $childSerializers;
        }

        public static /* synthetic */ KSerializer b() {
            return _childSerializers$_anonymous_$1();
        }

        public static /* synthetic */ KSerializer c() {
            return _childSerializers$_anonymous_();
        }

        public static /* synthetic */ DesignSkipObjects copy$default(DesignSkipObjects r0, int r1, String r2, String r3, List r4, List r5, List r6, String r7, boolean r8, int r9, Object r10) {
            if ((r9 & 1) == 0) goto L6;
            r1 = r0.plateIndex;
        L6:
            if ((r9 & 2) == 0) goto L9;
            r2 = r0.pickPictureUrl;
        L9:
            if ((r9 & 4) == 0) goto L12;
            r3 = r0.topPictureUrl;
        L12:
            if ((r9 & 8) == 0) goto L15;
            r4 = r0.objects;
        L15:
            if ((r9 & 16) == 0) goto L18;
            r5 = r0.disabledIds;
        L18:
            if ((r9 & 32) == 0) goto L21;
            r6 = r0.selectedIds;
        L21:
            if ((r9 & 64) == 0) goto L24;
            r7 = r0.deviceModelName;
        L24:
            if ((r9 & 128) == 0) goto L26;
            r8 = r0.useMemoryPick;
        L26:
            String r92 = r7;
            boolean r102 = r8;
            List r72 = r5;
            List r82 = r6;
            String r52 = r3;
            List r62 = r4;
            return r0.copy(r1, r2, r52, r62, r72, r82, r92, r102);
        }

        @o0g
        public static final /* synthetic */ void write$Self$navigation(DesignSkipObjects r5, CompositeEncoder r6, SerialDescriptor r7) {
            Lazy<KSerializer<Object>>[] r0 = $childSerializers;
            r6.encodeIntElement(r7, 0, r5.plateIndex);
            if (r6.shouldEncodeElementDefault(r7, 1) == false) goto L6;
        L7:
            r6.encodeNullableSerializableElement(r7, 1, StringSerializer.INSTANCE, r5.pickPictureUrl);
        L9:
            if (r6.shouldEncodeElementDefault(r7, 2) == false) goto L12;
        L13:
            r6.encodeNullableSerializableElement(r7, 2, StringSerializer.INSTANCE, r5.topPictureUrl);
        L14:
            boolean r2 = r6.shouldEncodeElementDefault(r7, 3);
            egb r3 = egb.a;
            if (r2 == false) goto L18;
        L19:
            r6.encodeSerializableElement(r7, 3, (SerializationStrategy) r0[3].getValue(), r5.objects);
        L21:
            if (r6.shouldEncodeElementDefault(r7, 4) == false) goto L24;
        L25:
            r6.encodeSerializableElement(r7, 4, (SerializationStrategy) r0[4].getValue(), r5.disabledIds);
        L27:
            if (r6.shouldEncodeElementDefault(r7, 5) == false) goto L30;
        L31:
            r6.encodeSerializableElement(r7, 5, (SerializationStrategy) r0[5].getValue(), r5.selectedIds);
        L33:
            if (r6.shouldEncodeElementDefault(r7, 6) == false) goto L36;
        L37:
            r6.encodeNullableSerializableElement(r7, 6, StringSerializer.INSTANCE, r5.deviceModelName);
        L39:
            if (r6.shouldEncodeElementDefault(r7, 7) == false) goto L42;
        L43:
            r6.encodeBooleanElement(r7, 7, r5.useMemoryPick);
            return;
        L42:
            if (r5.useMemoryPick == true) goto L43;
            return;
        L36:
            if (r5.deviceModelName == null) goto L39;
        L30:
            if (lsf.l(r5.selectedIds, r3) == true) goto L33;
        L24:
            if (lsf.l(r5.disabledIds, r3) == true) goto L27;
        L18:
            if (lsf.l(r5.objects, r3) == true) goto L21;
        L12:
            if (r5.topPictureUrl == null) goto L14;
        L6:
            if (r5.pickPictureUrl == null) goto L9;
            goto L7
        }

        public final int component1() {
            return this.plateIndex;
        }

        public final String component2() {
            return this.pickPictureUrl;
        }

        public final String component3() {
            return this.topPictureUrl;
        }

        public final List<IotPlateObjectId> component4() {
            return this.objects;
        }

        public final List<Long> component5() {
            return this.disabledIds;
        }

        public final List<Long> component6() {
            return this.selectedIds;
        }

        public final String component7() {
            return this.deviceModelName;
        }

        public final boolean component8() {
            return this.useMemoryPick;
        }

        public final DesignSkipObjects copy(int r1, String r2, String r3, List<IotPlateObjectId> r4, List<Long> r5, List<Long> r6, String r7, boolean r8) {
            r4.getClass();
            r5.getClass();
            r6.getClass();
            return new DesignSkipObjects(r1, r2, r3, r4, r5, r6, r7, r8);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof DesignSkipObjects) == true) goto L8;
            return false;
        L8:
            DesignSkipObjects r52 = (DesignSkipObjects) r5;
            if (this.plateIndex == r52.plateIndex) goto L12;
            return false;
        L12:
            if (lsf.l(this.pickPictureUrl, r52.pickPictureUrl) == true) goto L15;
            return false;
        L15:
            if (lsf.l(this.topPictureUrl, r52.topPictureUrl) == true) goto L18;
            return false;
        L18:
            if (lsf.l(this.objects, r52.objects) == true) goto L21;
            return false;
        L21:
            if (lsf.l(this.disabledIds, r52.disabledIds) == true) goto L24;
            return false;
        L24:
            if (lsf.l(this.selectedIds, r52.selectedIds) == true) goto L27;
            return false;
        L27:
            if (lsf.l(this.deviceModelName, r52.deviceModelName) == true) goto L30;
            return false;
        L30:
            if (this.useMemoryPick == r52.useMemoryPick) goto L32;
            return false;
        L32:
            return true;
        }

        public final String getDeviceModelName() {
            return this.deviceModelName;
        }

        public final List<Long> getDisabledIds() {
            return this.disabledIds;
        }

        public final List<IotPlateObjectId> getObjects() {
            return this.objects;
        }

        public final String getPickPictureUrl() {
            return this.pickPictureUrl;
        }

        public final int getPlateIndex() {
            return this.plateIndex;
        }

        public final List<Long> getSelectedIds() {
            return this.selectedIds;
        }

        public final String getTopPictureUrl() {
            return this.topPictureUrl;
        }

        public final boolean getUseMemoryPick() {
            return this.useMemoryPick;
        }

        public int hashCode() {
            int r0 = Integer.hashCode(this.plateIndex) * 31;
            String r2 = this.pickPictureUrl;
            int r3 = 0;
            if (r2 != null) goto L5;
            int r22 = 0;
        L6:
            int r02 = (r0 + r22) * 31;
            String r23 = this.topPictureUrl;
            if (r23 != null) goto L9;
            int r24 = 0;
        L10:
            int r03 = kn2.b(kn2.b(kn2.b((r02 + r24) * 31, 31, this.objects), 31, this.disabledIds), 31, this.selectedIds);
            String r25 = this.deviceModelName;
            if (r25 == null) goto L15;
            r3 = r25.hashCode();
        L15:
            return Boolean.hashCode(this.useMemoryPick) + ((r03 + r3) * 31);
        L9:
            r24 = r23.hashCode();
            goto L10
        L5:
            r22 = r2.hashCode();
            goto L6
        }

        public String toString() {
            int r0 = this.plateIndex;
            String r1 = this.pickPictureUrl;
            String r2 = this.topPictureUrl;
            List<IotPlateObjectId> r3 = this.objects;
            List<Long> r4 = this.disabledIds;
            List<Long> r5 = this.selectedIds;
            String r6 = this.deviceModelName;
            boolean r10 = this.useMemoryPick;
            StringBuilder r02 = r77.u(r0, "DesignSkipObjects(plateIndex=", ", pickPictureUrl=", r1, ", topPictureUrl=");
            defpackage.c2.y(r2, ", objects=", ", disabledIds=", r02, r3);
            bsa.q(r02, r4, ", selectedIds=", r5, ", deviceModelName=");
            return defpackage.c2.n(r02, r6, ", useMemoryPick=", r10, ")");
        }
    }

    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\b\u0087\b\u0018\u0000 \"2\u00020\u0001:\u0002#$B\u0011\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005B%\b\u0010\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u0004\u0010\nJ'\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u000b\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000eH\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0014\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0014\u0010\u0015J\u001a\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0018\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0018\u0010\u0015J\u0010\u0010\u0019\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0019\u0010\u001aJ\u001a\u0010\u001e\u001a\u00020\u001d2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bHÖ\u0003¢\u0006\u0004\b\u001e\u0010\u001fR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010 \u001a\u0004\b!\u0010\u0015¨\u0006%"}, d2 = {"Lcom/bambulab/bambulab/navigation/route/HomeAppRoute$HowPrintDesign;", "Lcom/bambulab/bambulab/navigation/route/HomeAppRoute;", "", "makerworldDomain", "<init>", "(Ljava/lang/String;)V", "", "seen0", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "serializationConstructorMarker", "(ILjava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "self", "Lkotlinx/serialization/encoding/CompositeEncoder;", "output", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "serialDesc", "Ltrs;", "write$Self$navigation", "(Lcom/bambulab/bambulab/navigation/route/HomeAppRoute$HowPrintDesign;Lkotlinx/serialization/encoding/CompositeEncoder;Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "write$Self", "component1", "()Ljava/lang/String;", "copy", "(Ljava/lang/String;)Lcom/bambulab/bambulab/navigation/route/HomeAppRoute$HowPrintDesign;", "toString", "hashCode", "()I", "", Request.JsonKeys.OTHER, "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getMakerworldDomain", "Companion", "com/bambulab/bambulab/navigation/route/w6", "com/bambulab/bambulab/navigation/route/x6", "navigation"}, k = 1, mv = {2, 4, 0}, xi = 48)
    @Serializable
    public static final class HowPrintDesign implements HomeAppRoute {
        public static final int $stable = 0;
        public static final x6 Companion = null;
        private final String makerworldDomain;

        static {
            Companion = new x6();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public HowPrintDesign() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        public /* synthetic */ HowPrintDesign(int r1, String r2, SerializationConstructorMarker r3) {
            if ((r1 & 1) != 0) goto L6;
            this.makerworldDomain = "makerworld.com";
            return;
        L6:
            this.makerworldDomain = r2;
        }

        public HowPrintDesign(String r1) {
            r1.getClass();
            this.makerworldDomain = r1;
        }

        public /* synthetic */ HowPrintDesign(String r1, int r2, DefaultConstructorMarker r3) {
            if ((r2 & 1) == 0) goto L5;
            r1 = "makerworld.com";
        L5:
            this(r1);
        }

        public static /* synthetic */ HowPrintDesign copy$default(HowPrintDesign r0, String r1, int r2, Object r3) {
            if ((r2 & 1) == 0) goto L6;
            r1 = r0.makerworldDomain;
        L6:
            return r0.copy(r1);
        }

        @o0g
        public static final /* synthetic */ void write$Self$navigation(HowPrintDesign r3, CompositeEncoder r4, SerialDescriptor r5) {
            if (r4.shouldEncodeElementDefault(r5, 0) == false) goto L6;
        L7:
            r4.encodeStringElement(r5, 0, r3.makerworldDomain);
            return;
        L6:
            if (lsf.l(r3.makerworldDomain, "makerworld.com") == false) goto L7;
        }

        public final String component1() {
            return this.makerworldDomain;
        }

        public final HowPrintDesign copy(String r1) {
            r1.getClass();
            return new HowPrintDesign(r1);
        }

        public boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof HowPrintDesign) == true) goto L9;
            return false;
        L9:
            if (lsf.l(this.makerworldDomain, ((HowPrintDesign) r4).makerworldDomain) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final String getMakerworldDomain() {
            return this.makerworldDomain;
        }

        public int hashCode() {
            return this.makerworldDomain.hashCode();
        }

        public String toString() {
            return dgh.n("HowPrintDesign(makerworldDomain=", this.makerworldDomain, ")");
        }
    }

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0083\u0004J\n\u0010\b\u001a\u00020\tHÖ\u0081\u0004J\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00000\u000bJ\n\u0010\f\u001a\u00020\rHÖ\u0081\u0004Ê\u0001\u0002\b\u000fÊ\u0001\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\u0003\u0010\u0002¨\u0006\u000e"}, d2 = {"Lcom/bambulab/bambulab/navigation/route/HomeAppRoute$HowUsePreset;", "Lcom/bambulab/bambulab/navigation/route/HomeAppRoute;", "<init>", "()V", "equals", "", Request.JsonKeys.OTHER, "", "hashCode", "", "serializer", "Lkotlinx/serialization/KSerializer;", "toString", "", "navigation", "Lkotlinx/serialization/Serializable;", "Landroidx/compose/runtime/internal/StabilityInferred;", PushConstants.PARAMS}, k = 1, mv = {2, 4, 0}, xi = 48)
    @Serializable
    public static final class HowUsePreset implements HomeAppRoute {
        private static final /* synthetic */ Lazy<KSerializer<Object>> $cachedSerializer$delegate = null;
        public static final int $stable = 0;
        public static final HowUsePreset INSTANCE = null;

        static {
            INSTANCE = new HowUsePreset();
            rie r0 = new rie(5);
            $cachedSerializer$delegate = z86.y(lkg.b, r0);
        }

        private HowUsePreset() {
        }

        private static final /* synthetic */ KSerializer _init_$_anonymous_() {
            return new ObjectSerializer("com.bambulab.bambulab.navigation.route.HomeAppRoute.HowUsePreset", INSTANCE, new Annotation[0]);
        }

        public static /* synthetic */ KSerializer a() {
            return _init_$_anonymous_();
        }

        private final /* synthetic */ KSerializer get$cachedSerializer() {
            return (KSerializer) $cachedSerializer$delegate.getValue();
        }

        public boolean equals(Object r2) {
            if (this != r2) goto L6;
            return true;
        L6:
            if ((r2 instanceof HowUsePreset) == true) goto L9;
            return false;
        L9:
            return true;
        }

        public int hashCode() {
            return 272349451;
        }

        public final KSerializer<HowUsePreset> serializer() {
            return get$cachedSerializer();
        }

        public String toString() {
            return "HowUsePreset";
        }
    }

    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\b\u0087\b\u0018\u0000 \"2\u00020\u0001:\u0002#$B\u0011\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005B#\b\u0010\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\tJ'\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\n\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rH\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0013\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0013\u0010\u0014J\u001a\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0018\u001a\u00020\u0017HÖ\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u001a\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u001a\u0010\u0014J\u001a\u0010\u001e\u001a\u00020\u001d2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bHÖ\u0003¢\u0006\u0004\b\u001e\u0010\u001fR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010 \u001a\u0004\b!\u0010\u0014¨\u0006%"}, d2 = {"Lcom/bambulab/bambulab/navigation/route/HomeAppRoute$ModelCollection;", "Lcom/bambulab/bambulab/navigation/route/HomeAppRoute;", "", "pinnedCollectionId", "<init>", "(I)V", "seen0", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "serializationConstructorMarker", "(IILkotlinx/serialization/internal/SerializationConstructorMarker;)V", "self", "Lkotlinx/serialization/encoding/CompositeEncoder;", "output", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "serialDesc", "Ltrs;", "write$Self$navigation", "(Lcom/bambulab/bambulab/navigation/route/HomeAppRoute$ModelCollection;Lkotlinx/serialization/encoding/CompositeEncoder;Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "write$Self", "component1", "()I", "copy", "(I)Lcom/bambulab/bambulab/navigation/route/HomeAppRoute$ModelCollection;", "", "toString", "()Ljava/lang/String;", "hashCode", "", Request.JsonKeys.OTHER, "", "equals", "(Ljava/lang/Object;)Z", "I", "getPinnedCollectionId", "Companion", "com/bambulab/bambulab/navigation/route/y6", "com/bambulab/bambulab/navigation/route/z6", "navigation"}, k = 1, mv = {2, 4, 0}, xi = 48)
    @Serializable
    public static final class ModelCollection implements HomeAppRoute {
        public static final int $stable = 0;
        public static final z6 Companion = null;
        private final int pinnedCollectionId;

        static {
            Companion = new z6();
        }

        public ModelCollection() {
            int r2 = 0;
            this(r2, 1, null);
        }

        public ModelCollection(int r1) {
            this.pinnedCollectionId = r1;
        }

        public /* synthetic */ ModelCollection(int r1, int r2, DefaultConstructorMarker r3) {
            if ((r2 & 1) == 0) goto L5;
            r1 = -1;
        L5:
            this(r1);
        }

        public /* synthetic */ ModelCollection(int r1, int r2, SerializationConstructorMarker r3) {
            if ((r1 & 1) != 0) goto L6;
            this.pinnedCollectionId = -1;
            return;
        L6:
            this.pinnedCollectionId = r2;
        }

        public static /* synthetic */ ModelCollection copy$default(ModelCollection r0, int r1, int r2, Object r3) {
            if ((r2 & 1) == 0) goto L6;
            r1 = r0.pinnedCollectionId;
        L6:
            return r0.copy(r1);
        }

        @o0g
        public static final /* synthetic */ void write$Self$navigation(ModelCollection r3, CompositeEncoder r4, SerialDescriptor r5) {
            if (r4.shouldEncodeElementDefault(r5, 0) == false) goto L6;
        L7:
            r4.encodeIntElement(r5, 0, r3.pinnedCollectionId);
            return;
        L6:
            if (r3.pinnedCollectionId != (-1)) goto L7;
        }

        public final int component1() {
            return this.pinnedCollectionId;
        }

        public final ModelCollection copy(int r1) {
            return new ModelCollection(r1);
        }

        public boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof ModelCollection) == true) goto L9;
            return false;
        L9:
            if (this.pinnedCollectionId == ((ModelCollection) r4).pinnedCollectionId) goto L11;
            return false;
        L11:
            return true;
        }

        public final int getPinnedCollectionId() {
            return this.pinnedCollectionId;
        }

        public int hashCode() {
            return Integer.hashCode(this.pinnedCollectionId);
        }

        public String toString() {
            return dgh.g(this.pinnedCollectionId, "ModelCollection(pinnedCollectionId=", ")");
        }
    }

    @Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\f\b\u0087\b\u0018\u0000 02\u00020\u0001:\u000212B5\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0005¢\u0006\u0004\b\t\u0010\nBC\b\u0010\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\t\u0010\u000fJ'\u0010\u0018\u001a\u00020\u00152\u0006\u0010\u0010\u001a\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0013H\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0019\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u001b\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u001b\u0010\u001aJ\u0010\u0010\u001c\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u001e\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u001e\u0010\u001dJ\u0010\u0010\u001f\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u001f\u0010\u001dJB\u0010 \u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b \u0010!J\u0010\u0010#\u001a\u00020\"HÖ\u0001¢\u0006\u0004\b#\u0010$J\u0010\u0010%\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b%\u0010&J\u001a\u0010)\u001a\u00020\u00052\b\u0010(\u001a\u0004\u0018\u00010'HÖ\u0003¢\u0006\u0004\b)\u0010*R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010+\u001a\u0004\b,\u0010\u001aR\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010+\u001a\u0004\b-\u0010\u001aR\u0017\u0010\u0006\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010.\u001a\u0004\b\u0006\u0010\u001dR\u0017\u0010\u0007\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0007\u0010.\u001a\u0004\b\u0007\u0010\u001dR\u0017\u0010\b\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\b\u0010.\u001a\u0004\b/\u0010\u001d¨\u00063"}, d2 = {"Lcom/bambulab/bambulab/navigation/route/HomeAppRoute$PostCommentDetail;", "Lcom/bambulab/bambulab/navigation/route/HomeAppRoute;", "", "rootCommentId", "postId", "", "isShowPostDetail", "isShowDelete", "seedLocalIsPinned", "<init>", "(JJZZZ)V", "", "seen0", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "serializationConstructorMarker", "(IJJZZZLkotlinx/serialization/internal/SerializationConstructorMarker;)V", "self", "Lkotlinx/serialization/encoding/CompositeEncoder;", "output", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "serialDesc", "Ltrs;", "write$Self$navigation", "(Lcom/bambulab/bambulab/navigation/route/HomeAppRoute$PostCommentDetail;Lkotlinx/serialization/encoding/CompositeEncoder;Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "write$Self", "component1", "()J", "component2", "component3", "()Z", "component4", "component5", "copy", "(JJZZZ)Lcom/bambulab/bambulab/navigation/route/HomeAppRoute$PostCommentDetail;", "", "toString", "()Ljava/lang/String;", "hashCode", "()I", "", Request.JsonKeys.OTHER, "equals", "(Ljava/lang/Object;)Z", "J", "getRootCommentId", "getPostId", "Z", "getSeedLocalIsPinned", "Companion", "com/bambulab/bambulab/navigation/route/a7", "com/bambulab/bambulab/navigation/route/b7", "navigation"}, k = 1, mv = {2, 4, 0}, xi = 48)
    @Serializable
    public static final class PostCommentDetail implements HomeAppRoute {
        public static final int $stable = 0;
        public static final b7 Companion = null;
        private final boolean isShowDelete;
        private final boolean isShowPostDetail;
        private final long postId;
        private final long rootCommentId;
        private final boolean seedLocalIsPinned;

        static {
            Companion = new b7();
        }

        public /* synthetic */ PostCommentDetail(int r2, long r3, long r5, boolean r7, boolean r8, boolean r9, SerializationConstructorMarker r10) {
            if (3 == (r2 & 3)) goto L5;
            PluginExceptionsKt.throwMissingFieldException(r2, 3, a7.a.getDescriptor());
        L5:
            this.rootCommentId = r3;
            this.postId = r5;
            if ((r2 & 4) != 0) goto L8;
            this.isShowPostDetail = false;
        L10:
            if ((r2 & 8) != 0) goto L12;
            this.isShowDelete = false;
        L14:
            if ((r2 & 16) != 0) goto L17;
            this.seedLocalIsPinned = false;
            return;
        L17:
            this.seedLocalIsPinned = r9;
            return;
        L12:
            this.isShowDelete = r8;
            goto L14
        L8:
            this.isShowPostDetail = r7;
            goto L10
        }

        public PostCommentDetail(long r1, long r3, boolean r5, boolean r6, boolean r7) {
            this.rootCommentId = r1;
            this.postId = r3;
            this.isShowPostDetail = r5;
            this.isShowDelete = r6;
            this.seedLocalIsPinned = r7;
        }

        public /* synthetic */ PostCommentDetail(long r2, long r4, boolean r6, boolean r7, boolean r8, int r9, DefaultConstructorMarker r10) {
            if ((r9 & 4) == 0) goto L6;
            r6 = false;
        L6:
            if ((r9 & 8) == 0) goto L9;
            r7 = false;
        L9:
            if ((r9 & 16) == 0) goto L11;
            r8 = false;
        L11:
            this(r2, r4, r6, r7, r8);
        }

        public static /* synthetic */ PostCommentDetail copy$default(PostCommentDetail r8, long r9, long r11, boolean r13, boolean r14, boolean r15, int r16, Object r17) {
            if ((r16 & 1) == 0) goto L5;
            r9 = r8.rootCommentId;
        L5:
            long r1 = r9;
            if ((r16 & 2) == 0) goto L8;
            r11 = r8.postId;
        L8:
            long r3 = r11;
            if ((r16 & 4) == 0) goto L11;
            r13 = r8.isShowPostDetail;
        L11:
            boolean r5 = r13;
            if ((r16 & 8) == 0) goto L14;
            r14 = r8.isShowDelete;
        L14:
            boolean r6 = r14;
            if ((r16 & 16) == 0) goto L18;
            r15 = r8.seedLocalIsPinned;
        L18:
            return r8.copy(r1, r3, r5, r6, r15);
        }

        @o0g
        public static final /* synthetic */ void write$Self$navigation(PostCommentDetail r3, CompositeEncoder r4, SerialDescriptor r5) {
            r4.encodeLongElement(r5, 0, r3.rootCommentId);
            r4.encodeLongElement(r5, 1, r3.postId);
            if (r4.shouldEncodeElementDefault(r5, 2) == false) goto L6;
        L7:
            r4.encodeBooleanElement(r5, 2, r3.isShowPostDetail);
        L9:
            if (r4.shouldEncodeElementDefault(r5, 3) == false) goto L12;
        L13:
            r4.encodeBooleanElement(r5, 3, r3.isShowDelete);
        L15:
            if (r4.shouldEncodeElementDefault(r5, 4) == false) goto L18;
        L19:
            r4.encodeBooleanElement(r5, 4, r3.seedLocalIsPinned);
            return;
        L18:
            if (r3.seedLocalIsPinned == true) goto L19;
            return;
        L12:
            if (r3.isShowDelete == false) goto L15;
        L6:
            if (r3.isShowPostDetail == false) goto L9;
            goto L7
        }

        public final long component1() {
            return this.rootCommentId;
        }

        public final long component2() {
            return this.postId;
        }

        public final boolean component3() {
            return this.isShowPostDetail;
        }

        public final boolean component4() {
            return this.isShowDelete;
        }

        public final boolean component5() {
            return this.seedLocalIsPinned;
        }

        public final PostCommentDetail copy(long r1, long r3, boolean r5, boolean r6, boolean r7) {
            return new PostCommentDetail(r1, r3, r5, r6, r7);
        }

        public boolean equals(Object r8) {
            if (this != r8) goto L6;
            return true;
        L6:
            if ((r8 instanceof PostCommentDetail) == true) goto L8;
            return false;
        L8:
            PostCommentDetail r82 = (PostCommentDetail) r8;
            if (this.rootCommentId == r82.rootCommentId) goto L12;
            return false;
        L12:
            if (this.postId == r82.postId) goto L15;
            return false;
        L15:
            if (this.isShowPostDetail == r82.isShowPostDetail) goto L18;
            return false;
        L18:
            if (this.isShowDelete == r82.isShowDelete) goto L21;
            return false;
        L21:
            if (this.seedLocalIsPinned == r82.seedLocalIsPinned) goto L23;
            return false;
        L23:
            return true;
        }

        public final long getPostId() {
            return this.postId;
        }

        public final long getRootCommentId() {
            return this.rootCommentId;
        }

        public final boolean getSeedLocalIsPinned() {
            return this.seedLocalIsPinned;
        }

        public int hashCode() {
            int r0 = b0r.c(b0r.c(ul7.c(Long.hashCode(this.rootCommentId) * 31, 31, this.postId), 31, this.isShowPostDetail), 31, this.isShowDelete);
            return Boolean.hashCode(this.seedLocalIsPinned) + r0;
        }

        public final boolean isShowDelete() {
            return this.isShowDelete;
        }

        public final boolean isShowPostDetail() {
            return this.isShowPostDetail;
        }

        public String toString() {
            long r0 = this.rootCommentId;
            long r2 = this.postId;
            boolean r4 = this.isShowPostDetail;
            boolean r5 = this.isShowDelete;
            boolean r8 = this.seedLocalIsPinned;
            StringBuilder r02 = dgh.o(r0, "PostCommentDetail(rootCommentId=", ", postId=");
            r02.append(r2);
            r02.append(", isShowPostDetail=");
            r02.append(r4);
            i3e.r(", isShowDelete=", ", seedLocalIsPinned=", r02, r5, r8);
            r02.append(")");
            return r02.toString();
        }
    }

    @Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\b\u0087\b\u0018\u0000 42\u00020\u0001:\u000256BO\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\n\u0010\u000bBW\b\u0010\u0012\u0006\u0010\r\u001a\u00020\f\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\n\u0010\u0010J'\u0010\u0019\u001a\u00020\u00162\u0006\u0010\u0011\u001a\u00020\u00002\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0014H\u0001¢\u0006\u0004\b\u0017\u0010\u0018J\u0012\u0010\u001a\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u001a\u0010\u001bJ\u0012\u0010\u001c\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u001c\u0010\u001bJ\u0012\u0010\u001d\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u001d\u0010\u001bJ\u0012\u0010\u001e\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\b\u001e\u0010\u001fJ\u0012\u0010 \u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\b \u0010\u001fJ\u0012\u0010!\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\b!\u0010\u001fJX\u0010\"\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0004\b\"\u0010#J\u0010\u0010$\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b$\u0010\u001fJ\u0010\u0010%\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b%\u0010&J\u001a\u0010*\u001a\u00020)2\b\u0010(\u001a\u0004\u0018\u00010'HÖ\u0003¢\u0006\u0004\b*\u0010+R\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010,\u001a\u0004\b-\u0010\u001bR\u0019\u0010\u0004\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010,\u001a\u0004\b.\u0010\u001bR\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0005\u0010,\u001a\u0004\b/\u0010\u001bR\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u00100\u001a\u0004\b1\u0010\u001fR\u0019\u0010\b\u001a\u0004\u0018\u00010\u00068\u0006¢\u0006\f\n\u0004\b\b\u00100\u001a\u0004\b2\u0010\u001fR\u0019\u0010\t\u001a\u0004\u0018\u00010\u00068\u0006¢\u0006\f\n\u0004\b\t\u00100\u001a\u0004\b3\u0010\u001f¨\u00067"}, d2 = {"Lcom/bambulab/bambulab/navigation/route/HomeAppRoute$PostCommunity;", "Lcom/bambulab/bambulab/navigation/route/HomeAppRoute;", "", "postId", "forwardPostId", "relatedDesignId", "", "topicTagStr", "fromPageName", "fromEnterName", "<init>", "(Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "", "seen0", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "serializationConstructorMarker", "(ILjava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "self", "Lkotlinx/serialization/encoding/CompositeEncoder;", "output", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "serialDesc", "Ltrs;", "write$Self$navigation", "(Lcom/bambulab/bambulab/navigation/route/HomeAppRoute$PostCommunity;Lkotlinx/serialization/encoding/CompositeEncoder;Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "write$Self", "component1", "()Ljava/lang/Long;", "component2", "component3", "component4", "()Ljava/lang/String;", "component5", "component6", "copy", "(Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/bambulab/bambulab/navigation/route/HomeAppRoute$PostCommunity;", "toString", "hashCode", "()I", "", Request.JsonKeys.OTHER, "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/Long;", "getPostId", "getForwardPostId", "getRelatedDesignId", "Ljava/lang/String;", "getTopicTagStr", "getFromPageName", "getFromEnterName", "Companion", "com/bambulab/bambulab/navigation/route/c7", "com/bambulab/bambulab/navigation/route/d7", "navigation"}, k = 1, mv = {2, 4, 0}, xi = 48)
    @Serializable
    public static final class PostCommunity implements HomeAppRoute {
        public static final int $stable = 0;
        public static final d7 Companion = null;
        private final Long forwardPostId;
        private final String fromEnterName;
        private final String fromPageName;
        private final Long postId;
        private final Long relatedDesignId;
        private final String topicTagStr;

        static {
            Companion = new d7();
        }

        public PostCommunity() {
            Long r1 = null;
            Long r2 = null;
            Long r3 = null;
            String r4 = null;
            String r5 = null;
            String r6 = null;
            this(r1, r2, r3, r4, r5, r6, 63, null);
        }

        public /* synthetic */ PostCommunity(int r2, Long r3, Long r4, Long r5, String r6, String r7, String r8, SerializationConstructorMarker r9) {
            if ((r2 & 1) != 0) goto L5;
            this.postId = null;
        L7:
            if ((r2 & 2) != 0) goto L9;
            this.forwardPostId = null;
        L11:
            if ((r2 & 4) != 0) goto L13;
            this.relatedDesignId = null;
        L15:
            if ((r2 & 8) != 0) goto L17;
            this.topicTagStr = null;
        L19:
            if ((r2 & 16) != 0) goto L21;
            this.fromPageName = null;
        L23:
            if ((r2 & 32) != 0) goto L26;
            this.fromEnterName = null;
            return;
        L26:
            this.fromEnterName = r8;
            return;
        L21:
            this.fromPageName = r7;
            goto L23
        L17:
            this.topicTagStr = r6;
            goto L19
        L13:
            this.relatedDesignId = r5;
            goto L15
        L9:
            this.forwardPostId = r4;
            goto L11
        L5:
            this.postId = r3;
            goto L7
        }

        public PostCommunity(Long r1, Long r2, Long r3, String r4, String r5, String r6) {
            this.postId = r1;
            this.forwardPostId = r2;
            this.relatedDesignId = r3;
            this.topicTagStr = r4;
            this.fromPageName = r5;
            this.fromEnterName = r6;
        }

        public /* synthetic */ PostCommunity(Long r2, Long r3, Long r4, String r5, String r6, String r7, int r8, DefaultConstructorMarker r9) {
            if ((r8 & 1) == 0) goto L6;
            r2 = null;
        L6:
            if ((r8 & 2) == 0) goto L9;
            r3 = null;
        L9:
            if ((r8 & 4) == 0) goto L12;
            r4 = null;
        L12:
            if ((r8 & 8) == 0) goto L15;
            r5 = null;
        L15:
            if ((r8 & 16) == 0) goto L18;
            r6 = null;
        L18:
            if ((r8 & 32) == 0) goto L20;
            r7 = null;
        L20:
            this(r2, r3, r4, r5, r6, r7);
        }

        public static /* synthetic */ PostCommunity copy$default(PostCommunity r0, Long r1, Long r2, Long r3, String r4, String r5, String r6, int r7, Object r8) {
            if ((r7 & 1) == 0) goto L6;
            r1 = r0.postId;
        L6:
            if ((r7 & 2) == 0) goto L9;
            r2 = r0.forwardPostId;
        L9:
            if ((r7 & 4) == 0) goto L12;
            r3 = r0.relatedDesignId;
        L12:
            if ((r7 & 8) == 0) goto L15;
            r4 = r0.topicTagStr;
        L15:
            if ((r7 & 16) == 0) goto L18;
            r5 = r0.fromPageName;
        L18:
            if ((r7 & 32) == 0) goto L20;
            r6 = r0.fromEnterName;
        L20:
            String r72 = r5;
            String r82 = r6;
            Long r52 = r3;
            String r62 = r4;
            return r0.copy(r1, r2, r52, r62, r72, r82);
        }

        @o0g
        public static final /* synthetic */ void write$Self$navigation(PostCommunity r3, CompositeEncoder r4, SerialDescriptor r5) {
            if (r4.shouldEncodeElementDefault(r5, 0) == false) goto L6;
        L7:
            r4.encodeNullableSerializableElement(r5, 0, LongSerializer.INSTANCE, r3.postId);
        L9:
            if (r4.shouldEncodeElementDefault(r5, 1) == false) goto L12;
        L13:
            r4.encodeNullableSerializableElement(r5, 1, LongSerializer.INSTANCE, r3.forwardPostId);
        L15:
            if (r4.shouldEncodeElementDefault(r5, 2) == false) goto L18;
        L19:
            r4.encodeNullableSerializableElement(r5, 2, LongSerializer.INSTANCE, r3.relatedDesignId);
        L21:
            if (r4.shouldEncodeElementDefault(r5, 3) == false) goto L24;
        L25:
            r4.encodeNullableSerializableElement(r5, 3, StringSerializer.INSTANCE, r3.topicTagStr);
        L27:
            if (r4.shouldEncodeElementDefault(r5, 4) == false) goto L30;
        L31:
            r4.encodeNullableSerializableElement(r5, 4, StringSerializer.INSTANCE, r3.fromPageName);
        L33:
            if (r4.shouldEncodeElementDefault(r5, 5) == false) goto L36;
        L37:
            r4.encodeNullableSerializableElement(r5, 5, StringSerializer.INSTANCE, r3.fromEnterName);
            return;
        L36:
            if (r3.fromEnterName != null) goto L37;
            return;
        L30:
            if (r3.fromPageName == null) goto L33;
        L24:
            if (r3.topicTagStr == null) goto L27;
        L18:
            if (r3.relatedDesignId == null) goto L21;
        L12:
            if (r3.forwardPostId == null) goto L15;
        L6:
            if (r3.postId == null) goto L9;
            goto L7
        }

        public final Long component1() {
            return this.postId;
        }

        public final Long component2() {
            return this.forwardPostId;
        }

        public final Long component3() {
            return this.relatedDesignId;
        }

        public final String component4() {
            return this.topicTagStr;
        }

        public final String component5() {
            return this.fromPageName;
        }

        public final String component6() {
            return this.fromEnterName;
        }

        public final PostCommunity copy(Long r1, Long r2, Long r3, String r4, String r5, String r6) {
            return new PostCommunity(r1, r2, r3, r4, r5, r6);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof PostCommunity) == true) goto L8;
            return false;
        L8:
            PostCommunity r52 = (PostCommunity) r5;
            if (lsf.l(this.postId, r52.postId) == true) goto L12;
            return false;
        L12:
            if (lsf.l(this.forwardPostId, r52.forwardPostId) == true) goto L15;
            return false;
        L15:
            if (lsf.l(this.relatedDesignId, r52.relatedDesignId) == true) goto L18;
            return false;
        L18:
            if (lsf.l(this.topicTagStr, r52.topicTagStr) == true) goto L21;
            return false;
        L21:
            if (lsf.l(this.fromPageName, r52.fromPageName) == true) goto L24;
            return false;
        L24:
            if (lsf.l(this.fromEnterName, r52.fromEnterName) == true) goto L26;
            return false;
        L26:
            return true;
        }

        public final Long getForwardPostId() {
            return this.forwardPostId;
        }

        public final String getFromEnterName() {
            return this.fromEnterName;
        }

        public final String getFromPageName() {
            return this.fromPageName;
        }

        public final Long getPostId() {
            return this.postId;
        }

        public final Long getRelatedDesignId() {
            return this.relatedDesignId;
        }

        public final String getTopicTagStr() {
            return this.topicTagStr;
        }

        public int hashCode() {
            Long r0 = this.postId;
            int r1 = 0;
            if (r0 != null) goto L5;
            int r02 = 0;
        L6:
            int r03 = r02 * 31;
            Long r2 = this.forwardPostId;
            if (r2 != null) goto L9;
            int r22 = 0;
        L10:
            int r04 = (r03 + r22) * 31;
            Long r23 = this.relatedDesignId;
            if (r23 != null) goto L13;
            int r24 = 0;
        L14:
            int r05 = (r04 + r24) * 31;
            String r25 = this.topicTagStr;
            if (r25 != null) goto L17;
            int r26 = 0;
        L18:
            int r06 = (r05 + r26) * 31;
            String r27 = this.fromPageName;
            if (r27 != null) goto L21;
            int r28 = 0;
        L22:
            int r07 = (r06 + r28) * 31;
            String r3 = this.fromEnterName;
            if (r3 == null) goto L27;
            r1 = r3.hashCode();
        L27:
            return r07 + r1;
        L21:
            r28 = r27.hashCode();
            goto L22
        L17:
            r26 = r25.hashCode();
            goto L18
        L13:
            r24 = r23.hashCode();
            goto L14
        L9:
            r22 = r2.hashCode();
            goto L10
        L5:
            r02 = r0.hashCode();
            goto L6
        }

        public String toString() {
            Long r0 = this.postId;
            Long r1 = this.forwardPostId;
            Long r2 = this.relatedDesignId;
            String r3 = this.topicTagStr;
            String r4 = this.fromPageName;
            String r7 = this.fromEnterName;
            StringBuilder r5 = new StringBuilder("PostCommunity(postId=");
            r5.append(r0);
            r5.append(", forwardPostId=");
            r5.append(r1);
            r5.append(", relatedDesignId=");
            bb6.w(r5, r2, ", topicTagStr=", r3, ", fromPageName=");
            return r77.s(r5, r4, ", fromEnterName=", r7, ")");
        }
    }

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0083\u0004J\n\u0010\b\u001a\u00020\tHÖ\u0081\u0004J\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00000\u000bJ\n\u0010\f\u001a\u00020\rHÖ\u0081\u0004Ê\u0001\u0002\b\u000fÊ\u0001\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\u0003\u0010\u0002¨\u0006\u000e"}, d2 = {"Lcom/bambulab/bambulab/navigation/route/HomeAppRoute$PostCommunityGraph;", "Lcom/bambulab/bambulab/navigation/route/HomeAppRoute;", "<init>", "()V", "equals", "", Request.JsonKeys.OTHER, "", "hashCode", "", "serializer", "Lkotlinx/serialization/KSerializer;", "toString", "", "navigation", "Lkotlinx/serialization/Serializable;", "Landroidx/compose/runtime/internal/StabilityInferred;", PushConstants.PARAMS}, k = 1, mv = {2, 4, 0}, xi = 48)
    @Serializable
    /* loaded from: classes3.dex */
    public static final class PostCommunityGraph implements HomeAppRoute {
        private static final /* synthetic */ Lazy<KSerializer<Object>> $cachedSerializer$delegate = null;
        public static final int $stable = 0;
        public static final PostCommunityGraph INSTANCE = null;

        static {
            INSTANCE = new PostCommunityGraph();
            rie r0 = new rie(6);
            $cachedSerializer$delegate = z86.y(lkg.b, r0);
        }

        private PostCommunityGraph() {
        }

        private static final /* synthetic */ KSerializer _init_$_anonymous_() {
            return new ObjectSerializer("com.bambulab.bambulab.navigation.route.HomeAppRoute.PostCommunityGraph", INSTANCE, new Annotation[0]);
        }

        public static /* synthetic */ KSerializer a() {
            return _init_$_anonymous_();
        }

        private final /* synthetic */ KSerializer get$cachedSerializer() {
            return (KSerializer) $cachedSerializer$delegate.getValue();
        }

        public boolean equals(Object r2) {
            if (this != r2) goto L6;
            return true;
        L6:
            if ((r2 instanceof PostCommunityGraph) == true) goto L9;
            return false;
        L9:
            return true;
        }

        public int hashCode() {
            return -1642496998;
        }

        public final KSerializer<PostCommunityGraph> serializer() {
            return get$cachedSerializer();
        }

        public String toString() {
            return "PostCommunityGraph";
        }
    }

    @Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\b\u0087\b\u0018\u0000 $2\u00020\u0001:\u0002%&B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005B#\b\u0010\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u0004\u0010\nJ'\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u000b\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000eH\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0014\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0014\u0010\u0015J\u001a\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0019\u001a\u00020\u0018HÖ\u0001¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u001b\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u001b\u0010\u001cJ\u001a\u0010 \u001a\u00020\u001f2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001dHÖ\u0003¢\u0006\u0004\b \u0010!R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\"\u001a\u0004\b#\u0010\u0015¨\u0006'"}, d2 = {"Lcom/bambulab/bambulab/navigation/route/HomeAppRoute$PostDetail;", "Lcom/bambulab/bambulab/navigation/route/HomeAppRoute;", "", "postId", "<init>", "(J)V", "", "seen0", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "serializationConstructorMarker", "(IJLkotlinx/serialization/internal/SerializationConstructorMarker;)V", "self", "Lkotlinx/serialization/encoding/CompositeEncoder;", "output", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "serialDesc", "Ltrs;", "write$Self$navigation", "(Lcom/bambulab/bambulab/navigation/route/HomeAppRoute$PostDetail;Lkotlinx/serialization/encoding/CompositeEncoder;Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "write$Self", "component1", "()J", "copy", "(J)Lcom/bambulab/bambulab/navigation/route/HomeAppRoute$PostDetail;", "", "toString", "()Ljava/lang/String;", "hashCode", "()I", "", Request.JsonKeys.OTHER, "", "equals", "(Ljava/lang/Object;)Z", "J", "getPostId", "Companion", "com/bambulab/bambulab/navigation/route/e7", "com/bambulab/bambulab/navigation/route/f7", "navigation"}, k = 1, mv = {2, 4, 0}, xi = 48)
    @Serializable
    public static final class PostDetail implements HomeAppRoute {
        public static final int $stable = 0;
        public static final f7 Companion = null;
        private final long postId;

        static {
            Companion = new f7();
        }

        public /* synthetic */ PostDetail(int r2, long r3, SerializationConstructorMarker r5) {
            if (1 == (r2 & 1)) goto L5;
            PluginExceptionsKt.throwMissingFieldException(r2, 1, e7.a.getDescriptor());
        L5:
            this.postId = r3;
        }

        public PostDetail(long r1) {
            this.postId = r1;
        }

        public static /* synthetic */ PostDetail copy$default(PostDetail r0, long r1, int r3, Object r4) {
            if ((r3 & 1) == 0) goto L6;
            r1 = r0.postId;
        L6:
            return r0.copy(r1);
        }

        @o0g
        public static final /* synthetic */ void write$Self$navigation(PostDetail r3, CompositeEncoder r4, SerialDescriptor r5) {
            r4.encodeLongElement(r5, 0, r3.postId);
        }

        public final long component1() {
            return this.postId;
        }

        public final PostDetail copy(long r1) {
            return new PostDetail(r1);
        }

        public boolean equals(Object r6) {
            if (this != r6) goto L6;
            return true;
        L6:
            if ((r6 instanceof PostDetail) == true) goto L9;
            return false;
        L9:
            if (this.postId == ((PostDetail) r6).postId) goto L11;
            return false;
        L11:
            return true;
        }

        public final long getPostId() {
            return this.postId;
        }

        public int hashCode() {
            return Long.hashCode(this.postId);
        }

        public String toString() {
            return r77.l(this.postId, "PostDetail(postId=", ")");
        }
    }

    @Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0012\b\u0087\b\u0018\u0000 Z2\u00020\u0001:\u0002[\\B_\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0014\b\u0002\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00020\n\u0012\b\b\u0002\u0010\r\u001a\u00020\f\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0010\u0010\u0011Bq\b\u0010\u0012\u0006\u0010\u0012\u001a\u00020\u0006\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b\u0012\u0014\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0002\u0018\u00010\n\u0012\b\u0010\r\u001a\u0004\u0018\u00010\f\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013¢\u0006\u0004\b\u0010\u0010\u0015J\u0010\u0010\u0016\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0018\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0018\u0010\u0017J\u0012\u0010\u0019\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u001b\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u001d\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\u001d\u0010\u001eJ\u001c\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00020\nHÆ\u0003¢\u0006\u0004\b\u001f\u0010 J\u0010\u0010!\u001a\u00020\fHÆ\u0003¢\u0006\u0004\b!\u0010\"J\u0010\u0010#\u001a\u00020\u000eHÆ\u0003¢\u0006\u0004\b#\u0010$Jn\u0010%\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\b2\u0014\b\u0002\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00020\n2\b\b\u0002\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000f\u001a\u00020\u000eHÆ\u0001¢\u0006\u0004\b%\u0010&J\u0010\u0010'\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b'\u0010\u001eJ\u0010\u0010(\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b(\u0010\u001cJ\u001a\u0010,\u001a\u00020+2\b\u0010*\u001a\u0004\u0018\u00010)HÖ\u0003¢\u0006\u0004\b,\u0010-J'\u00106\u001a\u0002032\u0006\u0010.\u001a\u00020\u00002\u0006\u00100\u001a\u00020/2\u0006\u00102\u001a\u000201H\u0001¢\u0006\u0004\b4\u00105R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u00107\u001a\u0004\b8\u0010\u0017R\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u00107\u001a\u0004\b9\u0010\u0017R\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0005\u0010:\u001a\u0004\b;\u0010\u001aR\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010<\u001a\u0004\b=\u0010\u001cR\u0017\u0010\t\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b\t\u0010>\u001a\u0004\b?\u0010\u001eR#\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00020\n8\u0006¢\u0006\f\n\u0004\b\u000b\u0010@\u001a\u0004\bA\u0010 R\u0017\u0010\r\u001a\u00020\f8\u0006¢\u0006\f\n\u0004\b\r\u0010B\u001a\u0004\bC\u0010\"R\u0017\u0010\u000f\u001a\u00020\u000e8\u0006¢\u0006\f\n\u0004\b\u000f\u0010D\u001a\u0004\bE\u0010$R\u0013\u0010G\u001a\u0004\u0018\u00010\b8F¢\u0006\u0006\u001a\u0004\bF\u0010\u001eR\u0013\u0010I\u001a\u0004\u0018\u00010\b8F¢\u0006\u0006\u001a\u0004\bH\u0010\u001eR\u0017\u0010N\u001a\b\u0012\u0004\u0012\u00020K0J8F¢\u0006\u0006\u001a\u0004\bL\u0010MR\u0011\u0010Q\u001a\u00020+8F¢\u0006\u0006\u001a\u0004\bO\u0010PR\u0011\u0010S\u001a\u00020+8F¢\u0006\u0006\u001a\u0004\bR\u0010PR\u0011\u0010U\u001a\u00020+8F¢\u0006\u0006\u001a\u0004\bT\u0010PR\u0011\u0010W\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\bV\u0010\u001cR\u0013\u0010Y\u001a\u0004\u0018\u00010\b8F¢\u0006\u0006\u001a\u0004\bX\u0010\u001e¨\u0006]"}, d2 = {"Lcom/bambulab/bambulab/navigation/route/HomeAppRoute$Preview3D;", "Lcom/bambulab/bambulab/navigation/route/HomeAppRoute;", "", "instanceId", "profileId", "designId", "", "plateIndex", "", "fileNameHint", "", "initialFilamentArgbById", "Lcom/bambulab/bambulab/navigation/route/Preview3DColorArgs;", "colorArgs", "Lcom/bambulab/bambulab/navigation/route/Preview3DLoadExtras;", "loadExtras", "<init>", "(JJLjava/lang/Long;ILjava/lang/String;Ljava/util/Map;Lcom/bambulab/bambulab/navigation/route/Preview3DColorArgs;Lcom/bambulab/bambulab/navigation/route/Preview3DLoadExtras;)V", "seen0", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "serializationConstructorMarker", "(IJJLjava/lang/Long;ILjava/lang/String;Ljava/util/Map;Lcom/bambulab/bambulab/navigation/route/Preview3DColorArgs;Lcom/bambulab/bambulab/navigation/route/Preview3DLoadExtras;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "component1", "()J", "component2", "component3", "()Ljava/lang/Long;", "component4", "()I", "component5", "()Ljava/lang/String;", "component6", "()Ljava/util/Map;", "component7", "()Lcom/bambulab/bambulab/navigation/route/Preview3DColorArgs;", "component8", "()Lcom/bambulab/bambulab/navigation/route/Preview3DLoadExtras;", "copy", "(JJLjava/lang/Long;ILjava/lang/String;Ljava/util/Map;Lcom/bambulab/bambulab/navigation/route/Preview3DColorArgs;Lcom/bambulab/bambulab/navigation/route/Preview3DLoadExtras;)Lcom/bambulab/bambulab/navigation/route/HomeAppRoute$Preview3D;", "toString", "hashCode", "", Request.JsonKeys.OTHER, "", "equals", "(Ljava/lang/Object;)Z", "self", "Lkotlinx/serialization/encoding/CompositeEncoder;", "output", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "serialDesc", "Ltrs;", "write$Self$navigation", "(Lcom/bambulab/bambulab/navigation/route/HomeAppRoute$Preview3D;Lkotlinx/serialization/encoding/CompositeEncoder;Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "write$Self", "J", "getInstanceId", "getProfileId", "Ljava/lang/Long;", "getDesignId", "I", "getPlateIndex", "Ljava/lang/String;", "getFileNameHint", "Ljava/util/Map;", "getInitialFilamentArgbById", "Lcom/bambulab/bambulab/navigation/route/Preview3DColorArgs;", "getColorArgs", "Lcom/bambulab/bambulab/navigation/route/Preview3DLoadExtras;", "getLoadExtras", "getPreviewFileUrl", "previewFileUrl", "getMeshoptUrl", "meshoptUrl", "", "Lcom/bambulab/bambulab/navigation/route/Preview3DProfileItem;", "getProfiles", "()Ljava/util/List;", "profiles", "getShowPrintCta", "()Z", "showPrintCta", "getUseEditorChrome", "useEditorChrome", "getHasAssemblyPic", "hasAssemblyPic", "getPlateCount", "plateCount", "getPlateGlbCacheKey", "plateGlbCacheKey", "Companion", "com/bambulab/bambulab/navigation/route/g7", "com/bambulab/bambulab/navigation/route/h7", "navigation"}, k = 1, mv = {2, 4, 0}, xi = 48)
    @Serializable
    public static final class Preview3D implements HomeAppRoute {
        private static final Lazy<KSerializer<Object>>[] $childSerializers = null;
        public static final int $stable = 0;
        public static final h7 Companion = null;
        private final Preview3DColorArgs colorArgs;
        private final Long designId;
        private final String fileNameHint;
        private final Map<Integer, Long> initialFilamentArgbById;
        private final long instanceId;
        private final Preview3DLoadExtras loadExtras;
        private final int plateIndex;
        private final long profileId;

        static {
            Companion = new h7();
            $stable = Preview3DLoadExtras.$stable | Preview3DColorArgs.$stable;
            $childSerializers = new Lazy[]{null, null, null, null, null, z86.y(lkg.b, new rie(7)), null, null};
        }

        public /* synthetic */ Preview3D(int r2, long r3, long r5, Long r7, int r8, String r9, Map r10, Preview3DColorArgs r11, Preview3DLoadExtras r12, SerializationConstructorMarker r13) {
            if (19 == (r2 & 19)) goto L5;
            PluginExceptionsKt.throwMissingFieldException(r2, 19, g7.a.getDescriptor());
        L5:
            this.instanceId = r3;
            this.profileId = r5;
            if ((r2 & 4) != 0) goto L8;
            this.designId = null;
        L10:
            if ((r2 & 8) != 0) goto L12;
            this.plateIndex = 0;
        L13:
            this.fileNameHint = r9;
            if ((r2 & 32) != 0) goto L16;
            this.initialFilamentArgbById = fgb.a;
        L18:
            if ((r2 & 64) != 0) goto L20;
            boolean r52 = false;
            Map r6 = null;
            List r72 = null;
            List r82 = null;
            Map r92 = null;
            this.colorArgs = new Preview3DColorArgs(r52, r6, r72, r82, r92, 31, null);
        L22:
            if ((r2 & 128) != 0) goto L25;
            String r4 = null;
            String r53 = null;
            List r62 = null;
            boolean r73 = false;
            boolean r83 = false;
            boolean r93 = false;
            int r102 = 0;
            Preview3DContentExtras r112 = null;
            this.loadExtras = new Preview3DLoadExtras(r4, r53, r62, r73, r83, r93, r102, r112, 255, null);
            return;
        L25:
            this.loadExtras = r12;
            return;
        L20:
            this.colorArgs = r11;
            goto L22
        L16:
            this.initialFilamentArgbById = r10;
            goto L18
        L12:
            this.plateIndex = r8;
            goto L13
        L8:
            this.designId = r7;
            goto L10
        }

        public Preview3D(long r1, long r3, Long r5, int r6, String r7, Map<Integer, Long> r8, Preview3DColorArgs r9, Preview3DLoadExtras r10) {
            r7.getClass();
            r8.getClass();
            r9.getClass();
            r10.getClass();
            this.instanceId = r1;
            this.profileId = r3;
            this.designId = r5;
            this.plateIndex = r6;
            this.fileNameHint = r7;
            this.initialFilamentArgbById = r8;
            this.colorArgs = r9;
            this.loadExtras = r10;
        }

        public /* synthetic */ Preview3D(long r24, long r26, Long r28, int r29, String r30, Map r31, Preview3DColorArgs r32, Preview3DLoadExtras r33, int r34, DefaultConstructorMarker r35) {
            if ((r34 & 4) == 0) goto L5;
            Long r7 = null;
        L7:
            if ((r34 & 8) == 0) goto L9;
            int r8 = 0;
        L11:
            if ((r34 & 32) == 0) goto L13;
            Map r10 = fgb.a;
        L15:
            if ((r34 & 64) == 0) goto L17;
            Preview3DColorArgs r11 = new Preview3DColorArgs(false, null, null, null, null, 31, null);
        L19:
            if ((r34 & 128) == 0) goto L22;
            Preview3DLoadExtras r12 = new Preview3DLoadExtras(null, null, null, false, false, false, 0, null, 255, null);
        L23:
            this(r24, r26, r7, r8, r30, r10, r11, r12);
            return;
        L22:
            r12 = r33;
            goto L23
        L17:
            r11 = r32;
            goto L19
        L13:
            r10 = r31;
            goto L15
        L9:
            r8 = r29;
            goto L11
        L5:
            r7 = r28;
            goto L7
        }

        private static final /* synthetic */ KSerializer _childSerializers$_anonymous_() {
            return new LinkedHashMapSerializer(IntSerializer.INSTANCE, LongSerializer.INSTANCE);
        }

        public static /* synthetic */ KSerializer a() {
            return _childSerializers$_anonymous_();
        }

        public static final /* synthetic */ Lazy[] access$get$childSerializers$cp() {
            return $childSerializers;
        }

        public static /* synthetic */ Preview3D copy$default(Preview3D r11, long r12, long r14, Long r16, int r17, String r18, Map r19, Preview3DColorArgs r20, Preview3DLoadExtras r21, int r22, Object r23) {
            if ((r22 & 1) == 0) goto L5;
            r12 = r11.instanceId;
        L5:
            long r1 = r12;
            if ((r22 & 2) == 0) goto L8;
            r14 = r11.profileId;
        L8:
            long r3 = r14;
            if ((r22 & 4) == 0) goto L11;
            Long r5 = r11.designId;
        L13:
            if ((r22 & 8) == 0) goto L15;
            int r6 = r11.plateIndex;
        L17:
            if ((r22 & 16) == 0) goto L19;
            String r7 = r11.fileNameHint;
        L21:
            if ((r22 & 32) == 0) goto L23;
            Map r8 = r11.initialFilamentArgbById;
        L25:
            if ((r22 & 64) == 0) goto L27;
            Preview3DColorArgs r9 = r11.colorArgs;
        L29:
            if ((r22 & 128) == 0) goto L32;
            Preview3DLoadExtras r10 = r11.loadExtras;
        L34:
            return r11.copy(r1, r3, r5, r6, r7, r8, r9, r10);
        L32:
            r10 = r21;
            goto L34
        L27:
            r9 = r20;
            goto L29
        L23:
            r8 = r19;
            goto L25
        L19:
            r7 = r18;
            goto L21
        L15:
            r6 = r17;
            goto L17
        L11:
            r5 = r16;
            goto L13
        }

        @o0g
        public static final /* synthetic */ void write$Self$navigation(Preview3D r13, CompositeEncoder r14, SerialDescriptor r15) {
            Lazy<KSerializer<Object>>[] r0 = $childSerializers;
            r14.encodeLongElement(r15, 0, r13.instanceId);
            r14.encodeLongElement(r15, 1, r13.profileId);
            if (r14.shouldEncodeElementDefault(r15, 2) == false) goto L6;
        L7:
            r14.encodeNullableSerializableElement(r15, 2, LongSerializer.INSTANCE, r13.designId);
        L9:
            if (r14.shouldEncodeElementDefault(r15, 3) == false) goto L12;
        L13:
            r14.encodeIntElement(r15, 3, r13.plateIndex);
        L14:
            r14.encodeStringElement(r15, 4, r13.fileNameHint);
            if (r14.shouldEncodeElementDefault(r15, 5) == false) goto L18;
        L19:
            r14.encodeSerializableElement(r15, 5, (SerializationStrategy) r0[5].getValue(), r13.initialFilamentArgbById);
        L21:
            if (r14.shouldEncodeElementDefault(r15, 6) == true) goto L25;
            boolean r3 = false;
            Map r4 = null;
            List r5 = null;
            List r6 = null;
            Map r7 = null;
            if (lsf.l(r13.colorArgs, new Preview3DColorArgs(r3, r4, r5, r6, r7, 31, null)) == false) goto L25;
        L27:
            if (r14.shouldEncodeElementDefault(r15, 7) == true) goto L31;
            String r32 = null;
            String r42 = null;
            List r52 = null;
            boolean r62 = false;
            boolean r72 = false;
            boolean r8 = false;
            int r9 = 0;
            Preview3DContentExtras r10 = null;
            if (lsf.l(r13.loadExtras, new Preview3DLoadExtras(r32, r42, r52, r62, r72, r8, r9, r10, 255, null)) == false) goto L31;
            return;
        L31:
            r14.encodeSerializableElement(r15, 7, a7m.a, r13.loadExtras);
            return;
        L25:
            r14.encodeSerializableElement(r15, 6, x5m.a, r13.colorArgs);
            goto L27
        L18:
            if (lsf.l(r13.initialFilamentArgbById, fgb.a) == true) goto L21;
        L12:
            if (r13.plateIndex == 0) goto L14;
        L6:
            if (r13.designId == null) goto L9;
            goto L7
        }

        public final long component1() {
            return this.instanceId;
        }

        public final long component2() {
            return this.profileId;
        }

        public final Long component3() {
            return this.designId;
        }

        public final int component4() {
            return this.plateIndex;
        }

        public final String component5() {
            return this.fileNameHint;
        }

        public final Map<Integer, Long> component6() {
            return this.initialFilamentArgbById;
        }

        public final Preview3DColorArgs component7() {
            return this.colorArgs;
        }

        public final Preview3DLoadExtras component8() {
            return this.loadExtras;
        }

        public final Preview3D copy(long r1, long r3, Long r5, int r6, String r7, Map<Integer, Long> r8, Preview3DColorArgs r9, Preview3DLoadExtras r10) {
            r7.getClass();
            r8.getClass();
            r9.getClass();
            r10.getClass();
            return new Preview3D(r1, r3, r5, r6, r7, r8, r9, r10);
        }

        public boolean equals(Object r8) {
            if (this != r8) goto L6;
            return true;
        L6:
            if ((r8 instanceof Preview3D) == true) goto L8;
            return false;
        L8:
            Preview3D r82 = (Preview3D) r8;
            if (this.instanceId == r82.instanceId) goto L12;
            return false;
        L12:
            if (this.profileId == r82.profileId) goto L15;
            return false;
        L15:
            if (lsf.l(this.designId, r82.designId) == true) goto L18;
            return false;
        L18:
            if (this.plateIndex == r82.plateIndex) goto L21;
            return false;
        L21:
            if (lsf.l(this.fileNameHint, r82.fileNameHint) == true) goto L24;
            return false;
        L24:
            if (lsf.l(this.initialFilamentArgbById, r82.initialFilamentArgbById) == true) goto L27;
            return false;
        L27:
            if (lsf.l(this.colorArgs, r82.colorArgs) == true) goto L30;
            return false;
        L30:
            if (lsf.l(this.loadExtras, r82.loadExtras) == true) goto L32;
            return false;
        L32:
            return true;
        }

        public final Preview3DColorArgs getColorArgs() {
            return this.colorArgs;
        }

        public final Long getDesignId() {
            return this.designId;
        }

        public final String getFileNameHint() {
            return this.fileNameHint;
        }

        public final boolean getHasAssemblyPic() {
            return this.loadExtras.getHasAssemblyPic();
        }

        public final Map<Integer, Long> getInitialFilamentArgbById() {
            return this.initialFilamentArgbById;
        }

        public final long getInstanceId() {
            return this.instanceId;
        }

        public final Preview3DLoadExtras getLoadExtras() {
            return this.loadExtras;
        }

        public final String getMeshoptUrl() {
            return this.loadExtras.getMeshoptUrl();
        }

        public final int getPlateCount() {
            return this.loadExtras.getPlateCount();
        }

        public final String getPlateGlbCacheKey() {
            return this.loadExtras.getPlateGlbCacheKey();
        }

        public final int getPlateIndex() {
            return this.plateIndex;
        }

        public final String getPreviewFileUrl() {
            return this.loadExtras.getPreviewFileUrl();
        }

        public final long getProfileId() {
            return this.profileId;
        }

        public final List<Preview3DProfileItem> getProfiles() {
            return this.loadExtras.getProfiles();
        }

        public final boolean getShowPrintCta() {
            return this.loadExtras.getShowPrintCta();
        }

        public final boolean getUseEditorChrome() {
            return this.loadExtras.getUseEditorChrome();
        }

        public int hashCode() {
            int r0 = ul7.c(Long.hashCode(this.instanceId) * 31, 31, this.profileId);
            Long r2 = this.designId;
            if (r2 != null) goto L5;
            int r22 = 0;
        L6:
            int r02 = (r0 + r22) * 31;
            int r03 = por.h(b0r.b(r77.a(this.plateIndex, r02, 31), 31, this.fileNameHint), 31, this.initialFilamentArgbById);
            int r23 = (this.colorArgs.hashCode() + r03) * 31;
            return this.loadExtras.hashCode() + r23;
        L5:
            r22 = r2.hashCode();
            goto L6
        }

        public String toString() {
            long r0 = this.instanceId;
            long r2 = this.profileId;
            Long r4 = this.designId;
            int r5 = this.plateIndex;
            String r6 = this.fileNameHint;
            Map<Integer, Long> r7 = this.initialFilamentArgbById;
            Preview3DColorArgs r8 = this.colorArgs;
            Preview3DLoadExtras r11 = this.loadExtras;
            StringBuilder r02 = dgh.o(r0, "Preview3D(instanceId=", ", profileId=");
            r02.append(r2);
            r02.append(", designId=");
            r02.append(r4);
            r02.append(", plateIndex=");
            r02.append(r5);
            r02.append(", fileNameHint=");
            r02.append(r6);
            r02.append(", initialFilamentArgbById=");
            r02.append(r7);
            r02.append(", colorArgs=");
            r02.append(r8);
            r02.append(", loadExtras=");
            r02.append(r11);
            r02.append(")");
            return r02.toString();
        }
    }

    @Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\b\u0087\b\u0018\u0000 '2\u00020\u0001:\u0002()B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006B+\b\u0010\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\b\u0010\n\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u0005\u0010\u000bJ'\u0010\u0014\u001a\u00020\u00112\u0006\u0010\f\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000fH\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0015\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0017\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0017\u0010\u0016J$\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u001b\u001a\u00020\u001aHÖ\u0001¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u001d\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b\u001d\u0010\u001eJ\u001a\u0010\"\u001a\u00020!2\b\u0010 \u001a\u0004\u0018\u00010\u001fHÖ\u0003¢\u0006\u0004\b\"\u0010#R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010$\u001a\u0004\b%\u0010\u0016R\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010$\u001a\u0004\b&\u0010\u0016¨\u0006*"}, d2 = {"Lcom/bambulab/bambulab/navigation/route/HomeAppRoute$ProfileRatingList;", "Lcom/bambulab/bambulab/navigation/route/HomeAppRoute;", "", "designId", "instanceId", "<init>", "(JJ)V", "", "seen0", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "serializationConstructorMarker", "(IJJLkotlinx/serialization/internal/SerializationConstructorMarker;)V", "self", "Lkotlinx/serialization/encoding/CompositeEncoder;", "output", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "serialDesc", "Ltrs;", "write$Self$navigation", "(Lcom/bambulab/bambulab/navigation/route/HomeAppRoute$ProfileRatingList;Lkotlinx/serialization/encoding/CompositeEncoder;Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "write$Self", "component1", "()J", "component2", "copy", "(JJ)Lcom/bambulab/bambulab/navigation/route/HomeAppRoute$ProfileRatingList;", "", "toString", "()Ljava/lang/String;", "hashCode", "()I", "", Request.JsonKeys.OTHER, "", "equals", "(Ljava/lang/Object;)Z", "J", "getDesignId", "getInstanceId", "Companion", "com/bambulab/bambulab/navigation/route/i7", "com/bambulab/bambulab/navigation/route/j7", "navigation"}, k = 1, mv = {2, 4, 0}, xi = 48)
    @Serializable
    public static final class ProfileRatingList implements HomeAppRoute {
        public static final int $stable = 0;
        public static final j7 Companion = null;
        private final long designId;
        private final long instanceId;

        static {
            Companion = new j7();
        }

        public /* synthetic */ ProfileRatingList(int r2, long r3, long r5, SerializationConstructorMarker r7) {
            if (3 == (r2 & 3)) goto L5;
            PluginExceptionsKt.throwMissingFieldException(r2, 3, i7.a.getDescriptor());
        L5:
            this.designId = r3;
            this.instanceId = r5;
        }

        public ProfileRatingList(long r1, long r3) {
            this.designId = r1;
            this.instanceId = r3;
        }

        public static /* synthetic */ ProfileRatingList copy$default(ProfileRatingList r0, long r1, long r3, int r5, Object r6) {
            if ((r5 & 1) == 0) goto L6;
            r1 = r0.designId;
        L6:
            if ((r5 & 2) == 0) goto L9;
            r3 = r0.instanceId;
        L9:
            return r0.copy(r1, r3);
        }

        @o0g
        public static final /* synthetic */ void write$Self$navigation(ProfileRatingList r3, CompositeEncoder r4, SerialDescriptor r5) {
            r4.encodeLongElement(r5, 0, r3.designId);
            r4.encodeLongElement(r5, 1, r3.instanceId);
        }

        public final long component1() {
            return this.designId;
        }

        public final long component2() {
            return this.instanceId;
        }

        public final ProfileRatingList copy(long r1, long r3) {
            return new ProfileRatingList(r1, r3);
        }

        public boolean equals(Object r8) {
            if (this != r8) goto L6;
            return true;
        L6:
            if ((r8 instanceof ProfileRatingList) == true) goto L8;
            return false;
        L8:
            ProfileRatingList r82 = (ProfileRatingList) r8;
            if (this.designId == r82.designId) goto L12;
            return false;
        L12:
            if (this.instanceId == r82.instanceId) goto L14;
            return false;
        L14:
            return true;
        }

        public final long getDesignId() {
            return this.designId;
        }

        public final long getInstanceId() {
            return this.instanceId;
        }

        public int hashCode() {
            int r0 = Long.hashCode(this.designId) * 31;
            return Long.hashCode(this.instanceId) + r0;
        }

        public String toString() {
            long r0 = this.designId;
            return dgh.h(this.instanceId, ")", dgh.o(r0, "ProfileRatingList(designId=", ", instanceId="));
        }
    }

    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\b\u0087\b\u0018\u0000 %2\u00020\u0001:\u0002&'B\u0019\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006B/\b\u0010\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\n\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u0005\u0010\u000bJ'\u0010\u0014\u001a\u00020\u00112\u0006\u0010\f\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000fH\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0015\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0017\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0017\u0010\u0016J$\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u001a\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u001a\u0010\u0016J\u0010\u0010\u001b\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b\u001b\u0010\u001cJ\u001a\u0010 \u001a\u00020\u001f2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001dHÖ\u0003¢\u0006\u0004\b \u0010!R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\"\u001a\u0004\b#\u0010\u0016R\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\"\u001a\u0004\b$\u0010\u0016¨\u0006("}, d2 = {"Lcom/bambulab/bambulab/navigation/route/HomeAppRoute$VideoPlayer;", "Lcom/bambulab/bambulab/navigation/route/HomeAppRoute;", "", "dataSource", "type", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "", "seen0", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "serializationConstructorMarker", "(ILjava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "self", "Lkotlinx/serialization/encoding/CompositeEncoder;", "output", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "serialDesc", "Ltrs;", "write$Self$navigation", "(Lcom/bambulab/bambulab/navigation/route/HomeAppRoute$VideoPlayer;Lkotlinx/serialization/encoding/CompositeEncoder;Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "write$Self", "component1", "()Ljava/lang/String;", "component2", "copy", "(Ljava/lang/String;Ljava/lang/String;)Lcom/bambulab/bambulab/navigation/route/HomeAppRoute$VideoPlayer;", "toString", "hashCode", "()I", "", Request.JsonKeys.OTHER, "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getDataSource", "getType", "Companion", "com/bambulab/bambulab/navigation/route/k7", "com/bambulab/bambulab/navigation/route/l7", "navigation"}, k = 1, mv = {2, 4, 0}, xi = 48)
    @Serializable
    public static final class VideoPlayer implements HomeAppRoute {
        public static final int $stable = 0;
        public static final l7 Companion = null;
        private final String dataSource;
        private final String type;

        static {
            Companion = new l7();
        }

        public /* synthetic */ VideoPlayer(int r2, String r3, String r4, SerializationConstructorMarker r5) {
            if (1 == (r2 & 1)) goto L5;
            PluginExceptionsKt.throwMissingFieldException(r2, 1, k7.a.getDescriptor());
        L5:
            this.dataSource = r3;
            if ((r2 & 2) != 0) goto L9;
            this.type = "network";
            return;
        L9:
            this.type = r4;
        }

        public VideoPlayer(String r1, String r2) {
            r1.getClass();
            r2.getClass();
            this.dataSource = r1;
            this.type = r2;
        }

        public /* synthetic */ VideoPlayer(String r1, String r2, int r3, DefaultConstructorMarker r4) {
            if ((r3 & 2) == 0) goto L5;
            r2 = "network";
        L5:
            this(r1, r2);
        }

        public static /* synthetic */ VideoPlayer copy$default(VideoPlayer r0, String r1, String r2, int r3, Object r4) {
            if ((r3 & 1) == 0) goto L6;
            r1 = r0.dataSource;
        L6:
            if ((r3 & 2) == 0) goto L9;
            r2 = r0.type;
        L9:
            return r0.copy(r1, r2);
        }

        @o0g
        public static final /* synthetic */ void write$Self$navigation(VideoPlayer r3, CompositeEncoder r4, SerialDescriptor r5) {
            r4.encodeStringElement(r5, 0, r3.dataSource);
            if (r4.shouldEncodeElementDefault(r5, 1) == false) goto L6;
        L7:
            r4.encodeStringElement(r5, 1, r3.type);
            return;
        L6:
            if (lsf.l(r3.type, "network") == false) goto L7;
        }

        public final String component1() {
            return this.dataSource;
        }

        public final String component2() {
            return this.type;
        }

        public final VideoPlayer copy(String r1, String r2) {
            r1.getClass();
            r2.getClass();
            return new VideoPlayer(r1, r2);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof VideoPlayer) == true) goto L8;
            return false;
        L8:
            VideoPlayer r52 = (VideoPlayer) r5;
            if (lsf.l(this.dataSource, r52.dataSource) == true) goto L12;
            return false;
        L12:
            if (lsf.l(this.type, r52.type) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final String getDataSource() {
            return this.dataSource;
        }

        public final String getType() {
            return this.type;
        }

        public int hashCode() {
            int r0 = this.dataSource.hashCode() * 31;
            return this.type.hashCode() + r0;
        }

        public String toString() {
            return b0r.p("VideoPlayer(dataSource=", this.dataSource, ", type=", this.type, ")");
        }
    }

    static {
        Companion = x5.a;
    }
}
