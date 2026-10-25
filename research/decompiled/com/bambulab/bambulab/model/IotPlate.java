package com.bambulab.bambulab.model;

import com.bambulab.bambulab.model.serializer.FlutterBoolStringOrNullSerializer;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import defpackage.bsa;
import defpackage.cuf;
import defpackage.i3e;
import defpackage.kn2;
import defpackage.lkg;
import defpackage.lsf;
import defpackage.o0g;
import defpackage.r77;
import defpackage.rie;
import defpackage.t4m;
import defpackage.z86;
import io.agora.rtc2.Constants;
import io.sentry.protocol.Device;
import io.sentry.protocol.Request;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.BooleanSerializer;
import kotlinx.serialization.internal.DoubleSerializer;
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b/\b\u0087\b\u0018\u0000 \u0081\u00012\u00020\u0001:\u0004\u0082\u0001\u0081\u0001BË\u0002\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f\u0012\u0010\b\u0002\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e\u0012\u0010\b\u0002\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0012\u0012\u0010\b\u0002\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0012\u0012\u0010\b\u0002\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0004\u0012\u0010\b\u0002\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u000e\u0012\u0010\b\u0002\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u0012\u0012\u0010\b\u0002\u0010!\u001a\n\u0012\u0004\u0012\u00020 \u0018\u00010\u000e\u0012\u0010\b\u0002\u0010#\u001a\n\u0012\u0004\u0012\u00020\"\u0018\u00010\u000e¢\u0006\u0004\b$\u0010%B±\u0002\b\u0010\u0012\u0006\u0010&\u001a\u00020\u0002\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\r\u001a\u0004\u0018\u00010\f\u0012\u000e\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e\u0012\u000e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012\u0012\u000e\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u000e\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0012\u0012\u000e\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u000e\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u001b\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\u0004\u0012\u000e\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u000e\u0012\u000e\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000e\u0012\b\u0010\u001f\u001a\u0004\u0018\u00010\u0012\u0012\u000e\u0010!\u001a\n\u0012\u0004\u0012\u00020 \u0018\u00010\u000e\u0012\u000e\u0010#\u001a\n\u0012\u0004\u0012\u00020\"\u0018\u00010\u000e\u0012\b\u0010(\u001a\u0004\u0018\u00010'¢\u0006\u0004\b$\u0010)J\u0012\u0010*\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b*\u0010+J\u0012\u0010,\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0004\b,\u0010-J\u0012\u0010.\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\b.\u0010/J\u0012\u00100\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\b0\u0010/J\u0012\u00101\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\b1\u0010/J\u0012\u00102\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\b2\u0010/J\u0012\u00103\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b3\u0010+J\u0012\u00104\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0004\b4\u00105J\u0018\u00106\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000eHÆ\u0003¢\u0006\u0004\b6\u00107J\u0018\u00108\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000eHÆ\u0003¢\u0006\u0004\b8\u00107J\u0012\u00109\u001a\u0004\u0018\u00010\u0012HÆ\u0003¢\u0006\u0004\b9\u0010:J\u0018\u0010;\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u000eHÆ\u0003¢\u0006\u0004\b;\u00107J\u0012\u0010<\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b<\u0010+J\u0012\u0010=\u001a\u0004\u0018\u00010\u0012HÆ\u0003¢\u0006\u0004\b=\u0010:J\u0018\u0010>\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u000eHÆ\u0003¢\u0006\u0004\b>\u00107J\u0012\u0010?\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\b?\u0010/J\u0012\u0010@\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0004\b@\u0010-J\u0012\u0010A\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0004\bA\u0010-J\u0018\u0010B\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u000eHÆ\u0003¢\u0006\u0004\bB\u00107J\u0018\u0010C\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000eHÆ\u0003¢\u0006\u0004\bC\u00107J\u0012\u0010D\u001a\u0004\u0018\u00010\u0012HÆ\u0003¢\u0006\u0004\bD\u0010:J\u0018\u0010E\u001a\n\u0012\u0004\u0012\u00020 \u0018\u00010\u000eHÆ\u0003¢\u0006\u0004\bE\u00107J\u0018\u0010F\u001a\n\u0012\u0004\u0012\u00020\"\u0018\u00010\u000eHÆ\u0003¢\u0006\u0004\bF\u00107JÔ\u0002\u0010G\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f2\u0010\b\u0002\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e2\u0010\b\u0002\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00122\u0010\b\u0002\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u000e2\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00122\u0010\b\u0002\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u000e2\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u00042\u0010\b\u0002\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u000e2\u0010\b\u0002\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000e2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u00122\u0010\b\u0002\u0010!\u001a\n\u0012\u0004\u0012\u00020 \u0018\u00010\u000e2\u0010\b\u0002\u0010#\u001a\n\u0012\u0004\u0012\u00020\"\u0018\u00010\u000eHÆ\u0001¢\u0006\u0004\bG\u0010HJ\u0010\u0010I\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\bI\u0010-J\u0010\u0010J\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\bJ\u0010KJ\u001a\u0010M\u001a\u00020\u00122\b\u0010L\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\bM\u0010NJ'\u0010W\u001a\u00020T2\u0006\u0010O\u001a\u00020\u00002\u0006\u0010Q\u001a\u00020P2\u0006\u0010S\u001a\u00020RH\u0001¢\u0006\u0004\bU\u0010VR\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010X\u001a\u0004\bY\u0010+R\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010Z\u001a\u0004\b[\u0010-R\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010\\\u001a\u0004\b]\u0010/R\"\u0010\b\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b\b\u0010\\\u0012\u0004\b_\u0010`\u001a\u0004\b^\u0010/R\"\u0010\t\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b\t\u0010\\\u0012\u0004\bb\u0010`\u001a\u0004\ba\u0010/R\"\u0010\n\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b\n\u0010\\\u0012\u0004\bd\u0010`\u001a\u0004\bc\u0010/R\u0019\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u000b\u0010X\u001a\u0004\be\u0010+R\u0019\u0010\r\u001a\u0004\u0018\u00010\f8\u0006¢\u0006\f\n\u0004\b\r\u0010f\u001a\u0004\bg\u00105R\u001f\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e8\u0006¢\u0006\f\n\u0004\b\u0010\u0010h\u001a\u0004\bi\u00107R(\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b\u0011\u0010h\u0012\u0004\bk\u0010`\u001a\u0004\bj\u00107R\"\u0010\u0013\u001a\u0004\u0018\u00010\u00128\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b\u0013\u0010l\u0012\u0004\bn\u0010`\u001a\u0004\bm\u0010:R\u001f\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u000e8\u0006¢\u0006\f\n\u0004\b\u0015\u0010h\u001a\u0004\bo\u00107R\u0019\u0010\u0016\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0016\u0010X\u001a\u0004\bp\u0010+R\u0019\u0010\u0017\u001a\u0004\u0018\u00010\u00128\u0006¢\u0006\f\n\u0004\b\u0017\u0010l\u001a\u0004\bq\u0010:R\u001f\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u000e8\u0006¢\u0006\f\n\u0004\b\u0019\u0010h\u001a\u0004\br\u00107R\u0019\u0010\u001a\u001a\u0004\u0018\u00010\u00068\u0006¢\u0006\f\n\u0004\b\u001a\u0010\\\u001a\u0004\bs\u0010/R\"\u0010\u001b\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b\u001b\u0010Z\u0012\u0004\bu\u0010`\u001a\u0004\bt\u0010-R\"\u0010\u001c\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b\u001c\u0010Z\u0012\u0004\bw\u0010`\u001a\u0004\bv\u0010-R(\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b\u001d\u0010h\u0012\u0004\by\u0010`\u001a\u0004\bx\u00107R(\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b\u001e\u0010h\u0012\u0004\b{\u0010`\u001a\u0004\bz\u00107R\"\u0010\u001f\u001a\u0004\u0018\u00010\u00128\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b\u001f\u0010l\u0012\u0004\b}\u0010`\u001a\u0004\b|\u0010:R(\u0010!\u001a\n\u0012\u0004\u0012\u00020 \u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b!\u0010h\u0012\u0004\b\u007f\u0010`\u001a\u0004\b~\u00107R \u0010#\u001a\n\u0012\u0004\u0012\u00020\"\u0018\u00010\u000e8\u0006¢\u0006\r\n\u0004\b#\u0010h\u001a\u0005\b\u0080\u0001\u00107¨\u0006\u0083\u0001"}, d2 = {"Lcom/bambulab/bambulab/model/IotPlate;", "", "", "index", "", "name", "Lcom/bambulab/bambulab/model/PlateImage;", "thumbnail", "topPicture", "pickPicture", "noLightPicture", "prediction", "", "weight", "", "Lcom/bambulab/bambulab/model/IotPlateObjectId;", "objects", "skippedObjects", "", "supportObjectSkipped", "Lcom/bambulab/bambulab/model/IotFilament;", "filaments", "nozzleType", "printed", "Lcom/bambulab/bambulab/model/PlateWarning;", "warning", "gcode", "filamentMaps", "limitFilamentMaps", "nozzleVolumeType", "nozzleDiameters", "enableFilamentDynamicMapIn3Mf", "Lcom/bambulab/bambulab/model/IotLayerFilamentList;", "layerFilamentLists", "Lcom/bambulab/bambulab/model/IotNozzle;", "printNozzlesForMultiNozzleMachine", "<init>", "(Ljava/lang/Integer;Ljava/lang/String;Lcom/bambulab/bambulab/model/PlateImage;Lcom/bambulab/bambulab/model/PlateImage;Lcom/bambulab/bambulab/model/PlateImage;Lcom/bambulab/bambulab/model/PlateImage;Ljava/lang/Integer;Ljava/lang/Double;Ljava/util/List;Ljava/util/List;Ljava/lang/Boolean;Ljava/util/List;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/util/List;Lcom/bambulab/bambulab/model/PlateImage;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/lang/Boolean;Ljava/util/List;Ljava/util/List;)V", "seen0", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "serializationConstructorMarker", "(ILjava/lang/Integer;Ljava/lang/String;Lcom/bambulab/bambulab/model/PlateImage;Lcom/bambulab/bambulab/model/PlateImage;Lcom/bambulab/bambulab/model/PlateImage;Lcom/bambulab/bambulab/model/PlateImage;Ljava/lang/Integer;Ljava/lang/Double;Ljava/util/List;Ljava/util/List;Ljava/lang/Boolean;Ljava/util/List;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/util/List;Lcom/bambulab/bambulab/model/PlateImage;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/lang/Boolean;Ljava/util/List;Ljava/util/List;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "component1", "()Ljava/lang/Integer;", "component2", "()Ljava/lang/String;", "component3", "()Lcom/bambulab/bambulab/model/PlateImage;", "component4", "component5", "component6", "component7", "component8", "()Ljava/lang/Double;", "component9", "()Ljava/util/List;", "component10", "component11", "()Ljava/lang/Boolean;", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "component21", "component22", "component23", "copy", "(Ljava/lang/Integer;Ljava/lang/String;Lcom/bambulab/bambulab/model/PlateImage;Lcom/bambulab/bambulab/model/PlateImage;Lcom/bambulab/bambulab/model/PlateImage;Lcom/bambulab/bambulab/model/PlateImage;Ljava/lang/Integer;Ljava/lang/Double;Ljava/util/List;Ljava/util/List;Ljava/lang/Boolean;Ljava/util/List;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/util/List;Lcom/bambulab/bambulab/model/PlateImage;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/lang/Boolean;Ljava/util/List;Ljava/util/List;)Lcom/bambulab/bambulab/model/IotPlate;", "toString", "hashCode", "()I", Request.JsonKeys.OTHER, "equals", "(Ljava/lang/Object;)Z", "self", "Lkotlinx/serialization/encoding/CompositeEncoder;", "output", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "serialDesc", "Ltrs;", "write$Self$model", "(Lcom/bambulab/bambulab/model/IotPlate;Lkotlinx/serialization/encoding/CompositeEncoder;Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "write$Self", "Ljava/lang/Integer;", "getIndex", "Ljava/lang/String;", "getName", "Lcom/bambulab/bambulab/model/PlateImage;", "getThumbnail", "getTopPicture", "getTopPicture$annotations", "()V", "getPickPicture", "getPickPicture$annotations", "getNoLightPicture", "getNoLightPicture$annotations", "getPrediction", "Ljava/lang/Double;", "getWeight", "Ljava/util/List;", "getObjects", "getSkippedObjects", "getSkippedObjects$annotations", "Ljava/lang/Boolean;", "getSupportObjectSkipped", "getSupportObjectSkipped$annotations", "getFilaments", "getNozzleType", "getPrinted", "getWarning", "getGcode", "getFilamentMaps", "getFilamentMaps$annotations", "getLimitFilamentMaps", "getLimitFilamentMaps$annotations", "getNozzleVolumeType", "getNozzleVolumeType$annotations", "getNozzleDiameters", "getNozzleDiameters$annotations", "getEnableFilamentDynamicMapIn3Mf", "getEnableFilamentDynamicMapIn3Mf$annotations", "getLayerFilamentLists", "getLayerFilamentLists$annotations", "getPrintNozzlesForMultiNozzleMachine", "Companion", "$serializer", Device.JsonKeys.MODEL}, k = 1, mv = {2, 4, 0}, xi = 48)
@Serializable
/* loaded from: classes3.dex */
public final class IotPlate {
    private static final Lazy<KSerializer<Object>>[] $childSerializers = null;
    public static final Companion Companion = null;
    private final Boolean enableFilamentDynamicMapIn3Mf;
    private final String filamentMaps;
    private final List<IotFilament> filaments;
    private final PlateImage gcode;
    private final Integer index;
    private final List<IotLayerFilamentList> layerFilamentLists;
    private final String limitFilamentMaps;
    private final String name;
    private final PlateImage noLightPicture;
    private final List<Double> nozzleDiameters;
    private final Integer nozzleType;
    private final List<Integer> nozzleVolumeType;
    private final List<IotPlateObjectId> objects;
    private final PlateImage pickPicture;
    private final Integer prediction;
    private final List<IotNozzle> printNozzlesForMultiNozzleMachine;
    private final Boolean printed;
    private final List<IotPlateObjectId> skippedObjects;
    private final Boolean supportObjectSkipped;
    private final PlateImage thumbnail;
    private final PlateImage topPicture;
    private final List<PlateWarning> warning;
    private final Double weight;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lcom/bambulab/bambulab/model/IotPlate$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/bambulab/bambulab/model/IotPlate;", Device.JsonKeys.MODEL}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        public final KSerializer<IotPlate> serializer() {
            return IotPlate$$serializer.INSTANCE;
        }
    }

    static {
        Companion = new Companion(null);
        rie r0 = new rie(25);
        lkg r2 = lkg.b;
        $childSerializers = new Lazy[]{null, null, null, null, null, null, null, null, z86.y(r2, r0), z86.y(r2, new rie(26)), null, z86.y(r2, new rie(27)), null, null, z86.y(r2, new rie(28)), null, null, null, null, null, null, z86.y(r2, new rie(29)), z86.y(r2, new cuf(0))};
    }

    public IotPlate() {
        Integer r1 = null;
        String r2 = null;
        PlateImage r3 = null;
        PlateImage r4 = null;
        PlateImage r5 = null;
        PlateImage r6 = null;
        Integer r7 = null;
        Double r8 = null;
        List r9 = null;
        List r10 = null;
        Boolean r11 = null;
        List r12 = null;
        Integer r13 = null;
        Boolean r14 = null;
        List r15 = null;
        PlateImage r16 = null;
        String r17 = null;
        String r18 = null;
        List r19 = null;
        List r20 = null;
        Boolean r21 = null;
        List r22 = null;
        List r23 = null;
        this(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, 8388607, null);
    }

    public /* synthetic */ IotPlate(int r3, Integer r4, String r5, PlateImage r6, PlateImage r7, PlateImage r8, PlateImage r9, Integer r10, Double r11, List r12, List r13, Boolean r14, List r15, Integer r16, Boolean r17, List r18, PlateImage r19, String r20, String r21, List r22, List r23, Boolean r24, List r25, List r26, SerializationConstructorMarker r27) {
        if ((r3 & 1) != 0) goto L5;
        this.index = null;
    L7:
        if ((r3 & 2) != 0) goto L9;
        this.name = null;
    L11:
        if ((r3 & 4) != 0) goto L13;
        this.thumbnail = null;
    L15:
        if ((r3 & 8) != 0) goto L17;
        this.topPicture = null;
    L19:
        if ((r3 & 16) != 0) goto L21;
        this.pickPicture = null;
    L23:
        if ((r3 & 32) != 0) goto L25;
        this.noLightPicture = null;
    L27:
        if ((r3 & 64) != 0) goto L29;
        this.prediction = null;
    L31:
        if ((r3 & 128) != 0) goto L33;
        this.weight = null;
    L35:
        if ((r3 & 256) != 0) goto L37;
        this.objects = null;
    L39:
        if ((r3 & 512) != 0) goto L41;
        this.skippedObjects = null;
    L43:
        if ((r3 & 1024) != 0) goto L45;
        this.supportObjectSkipped = null;
    L47:
        if ((r3 & 2048) != 0) goto L49;
        this.filaments = null;
    L51:
        if ((r3 & 4096) != 0) goto L53;
        this.nozzleType = null;
    L55:
        if ((r3 & 8192) != 0) goto L57;
        this.printed = null;
    L59:
        if ((r3 & 16384) != 0) goto L61;
        this.warning = null;
    L63:
        if ((32768 & r3) != 0) goto L65;
        this.gcode = null;
    L67:
        if ((65536 & r3) != 0) goto L69;
        this.filamentMaps = null;
    L71:
        if ((131072 & r3) != 0) goto L73;
        this.limitFilamentMaps = null;
    L75:
        if ((262144 & r3) != 0) goto L77;
        this.nozzleVolumeType = null;
    L79:
        if ((524288 & r3) != 0) goto L81;
        this.nozzleDiameters = null;
    L83:
        if ((1048576 & r3) != 0) goto L85;
        this.enableFilamentDynamicMapIn3Mf = null;
    L87:
        if ((2097152 & r3) != 0) goto L89;
        this.layerFilamentLists = null;
    L91:
        if ((r3 & 4194304) != 0) goto L94;
        this.printNozzlesForMultiNozzleMachine = null;
        return;
    L94:
        this.printNozzlesForMultiNozzleMachine = r26;
        return;
    L89:
        this.layerFilamentLists = r25;
        goto L91
    L85:
        this.enableFilamentDynamicMapIn3Mf = r24;
        goto L87
    L81:
        this.nozzleDiameters = r23;
        goto L83
    L77:
        this.nozzleVolumeType = r22;
        goto L79
    L73:
        this.limitFilamentMaps = r21;
        goto L75
    L69:
        this.filamentMaps = r20;
        goto L71
    L65:
        this.gcode = r19;
        goto L67
    L61:
        this.warning = r18;
        goto L63
    L57:
        this.printed = r17;
        goto L59
    L53:
        this.nozzleType = r16;
        goto L55
    L49:
        this.filaments = r15;
        goto L51
    L45:
        this.supportObjectSkipped = r14;
        goto L47
    L41:
        this.skippedObjects = r13;
        goto L43
    L37:
        this.objects = r12;
        goto L39
    L33:
        this.weight = r11;
        goto L35
    L29:
        this.prediction = r10;
        goto L31
    L25:
        this.noLightPicture = r9;
        goto L27
    L21:
        this.pickPicture = r8;
        goto L23
    L17:
        this.topPicture = r7;
        goto L19
    L13:
        this.thumbnail = r6;
        goto L15
    L9:
        this.name = r5;
        goto L11
    L5:
        this.index = r4;
        goto L7
    }

    public IotPlate(Integer r1, String r2, PlateImage r3, PlateImage r4, PlateImage r5, PlateImage r6, Integer r7, Double r8, List<IotPlateObjectId> r9, List<IotPlateObjectId> r10, Boolean r11, List<IotFilament> r12, Integer r13, Boolean r14, List<PlateWarning> r15, PlateImage r16, String r17, String r18, List<Integer> r19, List<Double> r20, Boolean r21, List<IotLayerFilamentList> r22, List<IotNozzle> r23) {
        this.index = r1;
        this.name = r2;
        this.thumbnail = r3;
        this.topPicture = r4;
        this.pickPicture = r5;
        this.noLightPicture = r6;
        this.prediction = r7;
        this.weight = r8;
        this.objects = r9;
        this.skippedObjects = r10;
        this.supportObjectSkipped = r11;
        this.filaments = r12;
        this.nozzleType = r13;
        this.printed = r14;
        this.warning = r15;
        this.gcode = r16;
        this.filamentMaps = r17;
        this.limitFilamentMaps = r18;
        this.nozzleVolumeType = r19;
        this.nozzleDiameters = r20;
        this.enableFilamentDynamicMapIn3Mf = r21;
        this.layerFilamentLists = r22;
        this.printNozzlesForMultiNozzleMachine = r23;
    }

    public /* synthetic */ IotPlate(Integer r25, String r26, PlateImage r27, PlateImage r28, PlateImage r29, PlateImage r30, Integer r31, Double r32, List r33, List r34, Boolean r35, List r36, Integer r37, Boolean r38, List r39, PlateImage r40, String r41, String r42, List r43, List r44, Boolean r45, List r46, List r47, int r48, DefaultConstructorMarker r49) {
        if ((r48 & 1) == 0) goto L5;
        Integer r1 = null;
    L7:
        if ((r48 & 2) == 0) goto L9;
        String r3 = null;
    L11:
        if ((r48 & 4) == 0) goto L13;
        PlateImage r4 = null;
    L15:
        if ((r48 & 8) == 0) goto L17;
        PlateImage r5 = null;
    L19:
        if ((r48 & 16) == 0) goto L21;
        PlateImage r6 = null;
    L23:
        if ((r48 & 32) == 0) goto L25;
        PlateImage r7 = null;
    L27:
        if ((r48 & 64) == 0) goto L29;
        Integer r8 = null;
    L31:
        if ((r48 & 128) == 0) goto L33;
        Double r9 = null;
    L35:
        if ((r48 & 256) == 0) goto L37;
        List r10 = null;
    L39:
        if ((r48 & 512) == 0) goto L41;
        List r11 = null;
    L43:
        if ((r48 & 1024) == 0) goto L45;
        Boolean r12 = null;
    L47:
        if ((r48 & 2048) == 0) goto L49;
        List r13 = null;
    L51:
        if ((r48 & 4096) == 0) goto L53;
        Integer r14 = null;
    L55:
        if ((r48 & 8192) == 0) goto L57;
        Boolean r15 = null;
    L59:
        if ((r48 & 16384) == 0) goto L61;
        List r2 = null;
    L63:
        if ((r48 & Constants.EAR_MONITORING_FILTER_REUSE_POST_PROCESSING_FILTER) == 0) goto L65;
        PlateImage r16 = null;
    L67:
        if ((r48 & 65536) == 0) goto L69;
        String r17 = null;
    L71:
        if ((r48 & 131072) == 0) goto L73;
        String r18 = null;
    L75:
        if ((r48 & 262144) == 0) goto L77;
        List r19 = null;
    L79:
        if ((r48 & CommonNetImpl.MAX_SEND_SIZE_IN_KB) == 0) goto L81;
        List r20 = null;
    L83:
        if ((r48 & 1048576) == 0) goto L85;
        Boolean r21 = null;
    L87:
        if ((r48 & 2097152) == 0) goto L89;
        List r22 = null;
    L91:
        if ((r48 & 4194304) == 0) goto L94;
        List r482 = null;
    L95:
        this(r1, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r2, r16, r17, r18, r19, r20, r21, r22, r482);
        return;
    L94:
        r482 = r47;
        goto L95
    L89:
        r22 = r46;
        goto L91
    L85:
        r21 = r45;
        goto L87
    L81:
        r20 = r44;
        goto L83
    L77:
        r19 = r43;
        goto L79
    L73:
        r18 = r42;
        goto L75
    L69:
        r17 = r41;
        goto L71
    L65:
        r16 = r40;
        goto L67
    L61:
        r2 = r39;
        goto L63
    L57:
        r15 = r38;
        goto L59
    L53:
        r14 = r37;
        goto L55
    L49:
        r13 = r36;
        goto L51
    L45:
        r12 = r35;
        goto L47
    L41:
        r11 = r34;
        goto L43
    L37:
        r10 = r33;
        goto L39
    L33:
        r9 = r32;
        goto L35
    L29:
        r8 = r31;
        goto L31
    L25:
        r7 = r30;
        goto L27
    L21:
        r6 = r29;
        goto L23
    L17:
        r5 = r28;
        goto L19
    L13:
        r4 = r27;
        goto L15
    L9:
        r3 = r26;
        goto L11
    L5:
        r1 = r25;
        goto L7
    }

    private static final /* synthetic */ KSerializer _childSerializers$_anonymous_() {
        return new ArrayListSerializer(IotPlateObjectId$$serializer.INSTANCE);
    }

    private static final /* synthetic */ KSerializer _childSerializers$_anonymous_$0() {
        return new ArrayListSerializer(IotPlateObjectId$$serializer.INSTANCE);
    }

    private static final /* synthetic */ KSerializer _childSerializers$_anonymous_$1() {
        return new ArrayListSerializer(IotFilament$$serializer.INSTANCE);
    }

    private static final /* synthetic */ KSerializer _childSerializers$_anonymous_$2() {
        return new ArrayListSerializer(PlateWarning$$serializer.INSTANCE);
    }

    private static final /* synthetic */ KSerializer _childSerializers$_anonymous_$3() {
        return new ArrayListSerializer(IotLayerFilamentList$$serializer.INSTANCE);
    }

    private static final /* synthetic */ KSerializer _childSerializers$_anonymous_$4() {
        return new ArrayListSerializer(IotNozzle$$serializer.INSTANCE);
    }

    public static /* synthetic */ KSerializer a() {
        return _childSerializers$_anonymous_$1();
    }

    public static final /* synthetic */ Lazy[] access$get$childSerializers$cp() {
        return $childSerializers;
    }

    public static /* synthetic */ KSerializer b() {
        return _childSerializers$_anonymous_$4();
    }

    public static /* synthetic */ KSerializer c() {
        return _childSerializers$_anonymous_();
    }

    public static /* synthetic */ IotPlate copy$default(IotPlate r17, Integer r18, String r19, PlateImage r20, PlateImage r21, PlateImage r22, PlateImage r23, Integer r24, Double r25, List r26, List r27, Boolean r28, List r29, Integer r30, Boolean r31, List r32, PlateImage r33, String r34, String r35, List r36, List r37, Boolean r38, List r39, List r40, int r41, Object r42) {
        if ((r41 & 1) == 0) goto L5;
        Integer r2 = r17.index;
    L7:
        if ((r41 & 2) == 0) goto L9;
        String r3 = r17.name;
    L11:
        if ((r41 & 4) == 0) goto L13;
        PlateImage r4 = r17.thumbnail;
    L15:
        if ((r41 & 8) == 0) goto L17;
        PlateImage r5 = r17.topPicture;
    L19:
        if ((r41 & 16) == 0) goto L21;
        PlateImage r6 = r17.pickPicture;
    L23:
        if ((r41 & 32) == 0) goto L25;
        PlateImage r7 = r17.noLightPicture;
    L27:
        if ((r41 & 64) == 0) goto L29;
        Integer r8 = r17.prediction;
    L31:
        if ((r41 & 128) == 0) goto L33;
        Double r9 = r17.weight;
    L35:
        if ((r41 & 256) == 0) goto L37;
        List r10 = r17.objects;
    L39:
        if ((r41 & 512) == 0) goto L41;
        List r11 = r17.skippedObjects;
    L43:
        if ((r41 & 1024) == 0) goto L45;
        Boolean r12 = r17.supportObjectSkipped;
    L47:
        if ((r41 & 2048) == 0) goto L49;
        List r13 = r17.filaments;
    L51:
        if ((r41 & 4096) == 0) goto L53;
        Integer r14 = r17.nozzleType;
    L55:
        if ((r41 & 8192) == 0) goto L57;
        Boolean r15 = r17.printed;
    L58:
        Integer r182 = r2;
        if ((r41 & 16384) == 0) goto L61;
        List r210 = r17.warning;
    L63:
        if ((r41 & Constants.EAR_MONITORING_FILTER_REUSE_POST_PROCESSING_FILTER) == 0) goto L65;
        PlateImage r1 = r17.gcode;
    L66:
        PlateImage r192 = r1;
        if ((r41 & 65536) == 0) goto L69;
        String r16 = r17.filamentMaps;
    L70:
        String r202 = r16;
        if ((r41 & 131072) == 0) goto L73;
        String r110 = r17.limitFilamentMaps;
    L74:
        String r212 = r110;
        if ((r41 & 262144) == 0) goto L77;
        List r111 = r17.nozzleVolumeType;
    L78:
        List r222 = r111;
        if ((r41 & CommonNetImpl.MAX_SEND_SIZE_IN_KB) == 0) goto L81;
        List r112 = r17.nozzleDiameters;
    L82:
        List r232 = r112;
        if ((r41 & 1048576) == 0) goto L85;
        Boolean r113 = r17.enableFilamentDynamicMapIn3Mf;
    L86:
        Boolean r242 = r113;
        if ((r41 & 2097152) == 0) goto L89;
        List r114 = r17.layerFilamentLists;
    L91:
        if ((r41 & 4194304) == 0) goto L94;
        List r252 = r114;
        List r402 = r252;
        List r412 = r17.printNozzlesForMultiNozzleMachine;
    L96:
        return r17.copy(r182, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r210, r192, r202, r212, r222, r232, r242, r402, r412);
    L94:
        r412 = r40;
        r402 = r114;
        goto L96
    L89:
        r114 = r39;
        goto L91
    L85:
        r113 = r38;
        goto L86
    L81:
        r112 = r37;
        goto L82
    L77:
        r111 = r36;
        goto L78
    L73:
        r110 = r35;
        goto L74
    L69:
        r16 = r34;
        goto L70
    L65:
        r1 = r33;
        goto L66
    L61:
        r210 = r32;
        goto L63
    L57:
        r15 = r31;
        goto L58
    L53:
        r14 = r30;
        goto L55
    L49:
        r13 = r29;
        goto L51
    L45:
        r12 = r28;
        goto L47
    L41:
        r11 = r27;
        goto L43
    L37:
        r10 = r26;
        goto L39
    L33:
        r9 = r25;
        goto L35
    L29:
        r8 = r24;
        goto L31
    L25:
        r7 = r23;
        goto L27
    L21:
        r6 = r22;
        goto L23
    L17:
        r5 = r21;
        goto L19
    L13:
        r4 = r20;
        goto L15
    L9:
        r3 = r19;
        goto L11
    L5:
        r2 = r18;
        goto L7
    }

    public static /* synthetic */ KSerializer d() {
        return _childSerializers$_anonymous_$0();
    }

    public static /* synthetic */ KSerializer e() {
        return _childSerializers$_anonymous_$3();
    }

    public static /* synthetic */ KSerializer f() {
        return _childSerializers$_anonymous_$2();
    }

    @SerialName("enable_filament_dynamic_map")
    @Serializable(with = FlutterBoolStringOrNullSerializer.class)
    public static /* synthetic */ void getEnableFilamentDynamicMapIn3Mf$annotations() {
    }

    @SerialName("filament_maps")
    public static /* synthetic */ void getFilamentMaps$annotations() {
    }

    @SerialName("layer_filament_lists")
    public static /* synthetic */ void getLayerFilamentLists$annotations() {
    }

    @SerialName("limit_filament_maps")
    public static /* synthetic */ void getLimitFilamentMaps$annotations() {
    }

    @SerialName("no_light_picture")
    public static /* synthetic */ void getNoLightPicture$annotations() {
    }

    @SerialName("nozzle_diameters")
    @Serializable(with = SpaceSeparatedDoubleListSerializer.class)
    public static /* synthetic */ void getNozzleDiameters$annotations() {
    }

    @SerialName("nozzle_volume_type")
    @Serializable(with = SpaceSeparatedIntListSerializer.class)
    public static /* synthetic */ void getNozzleVolumeType$annotations() {
    }

    @SerialName("pick_picture")
    public static /* synthetic */ void getPickPicture$annotations() {
    }

    @SerialName("skipped_objects")
    public static /* synthetic */ void getSkippedObjects$annotations() {
    }

    @SerialName("label_object_enabled")
    public static /* synthetic */ void getSupportObjectSkipped$annotations() {
    }

    @SerialName("top_picture")
    public static /* synthetic */ void getTopPicture$annotations() {
    }

    @o0g
    public static final /* synthetic */ void write$Self$model(IotPlate r4, CompositeEncoder r5, SerialDescriptor r6) {
        Lazy<KSerializer<Object>>[] r0 = $childSerializers;
        if (r5.shouldEncodeElementDefault(r6, 0) == false) goto L6;
    L7:
        r5.encodeNullableSerializableElement(r6, 0, IntSerializer.INSTANCE, r4.index);
    L9:
        if (r5.shouldEncodeElementDefault(r6, 1) == false) goto L12;
    L13:
        r5.encodeNullableSerializableElement(r6, 1, StringSerializer.INSTANCE, r4.name);
    L15:
        if (r5.shouldEncodeElementDefault(r6, 2) == false) goto L18;
    L19:
        r5.encodeNullableSerializableElement(r6, 2, PlateImage$$serializer.INSTANCE, r4.thumbnail);
    L21:
        if (r5.shouldEncodeElementDefault(r6, 3) == false) goto L24;
    L25:
        r5.encodeNullableSerializableElement(r6, 3, PlateImage$$serializer.INSTANCE, r4.topPicture);
    L27:
        if (r5.shouldEncodeElementDefault(r6, 4) == false) goto L30;
    L31:
        r5.encodeNullableSerializableElement(r6, 4, PlateImage$$serializer.INSTANCE, r4.pickPicture);
    L33:
        if (r5.shouldEncodeElementDefault(r6, 5) == false) goto L36;
    L37:
        r5.encodeNullableSerializableElement(r6, 5, PlateImage$$serializer.INSTANCE, r4.noLightPicture);
    L39:
        if (r5.shouldEncodeElementDefault(r6, 6) == false) goto L42;
    L43:
        r5.encodeNullableSerializableElement(r6, 6, IntSerializer.INSTANCE, r4.prediction);
    L45:
        if (r5.shouldEncodeElementDefault(r6, 7) == false) goto L48;
    L49:
        r5.encodeNullableSerializableElement(r6, 7, DoubleSerializer.INSTANCE, r4.weight);
    L51:
        if (r5.shouldEncodeElementDefault(r6, 8) == false) goto L54;
    L55:
        r5.encodeNullableSerializableElement(r6, 8, (SerializationStrategy) r0[8].getValue(), r4.objects);
    L57:
        if (r5.shouldEncodeElementDefault(r6, 9) == false) goto L60;
    L61:
        r5.encodeNullableSerializableElement(r6, 9, (SerializationStrategy) r0[9].getValue(), r4.skippedObjects);
    L63:
        if (r5.shouldEncodeElementDefault(r6, 10) == false) goto L66;
    L67:
        r5.encodeNullableSerializableElement(r6, 10, BooleanSerializer.INSTANCE, r4.supportObjectSkipped);
    L69:
        if (r5.shouldEncodeElementDefault(r6, 11) == false) goto L72;
    L73:
        r5.encodeNullableSerializableElement(r6, 11, (SerializationStrategy) r0[11].getValue(), r4.filaments);
    L75:
        if (r5.shouldEncodeElementDefault(r6, 12) == false) goto L78;
    L79:
        r5.encodeNullableSerializableElement(r6, 12, IntSerializer.INSTANCE, r4.nozzleType);
    L81:
        if (r5.shouldEncodeElementDefault(r6, 13) == false) goto L84;
    L85:
        r5.encodeNullableSerializableElement(r6, 13, BooleanSerializer.INSTANCE, r4.printed);
    L87:
        if (r5.shouldEncodeElementDefault(r6, 14) == false) goto L90;
    L91:
        r5.encodeNullableSerializableElement(r6, 14, (SerializationStrategy) r0[14].getValue(), r4.warning);
    L93:
        if (r5.shouldEncodeElementDefault(r6, 15) == false) goto L96;
    L97:
        r5.encodeNullableSerializableElement(r6, 15, PlateImage$$serializer.INSTANCE, r4.gcode);
    L99:
        if (r5.shouldEncodeElementDefault(r6, 16) == false) goto L102;
    L103:
        r5.encodeNullableSerializableElement(r6, 16, StringSerializer.INSTANCE, r4.filamentMaps);
    L105:
        if (r5.shouldEncodeElementDefault(r6, 17) == false) goto L108;
    L109:
        r5.encodeNullableSerializableElement(r6, 17, StringSerializer.INSTANCE, r4.limitFilamentMaps);
    L111:
        if (r5.shouldEncodeElementDefault(r6, 18) == false) goto L114;
    L115:
        r5.encodeNullableSerializableElement(r6, 18, SpaceSeparatedIntListSerializer.INSTANCE, r4.nozzleVolumeType);
    L117:
        if (r5.shouldEncodeElementDefault(r6, 19) == false) goto L120;
    L121:
        r5.encodeNullableSerializableElement(r6, 19, SpaceSeparatedDoubleListSerializer.INSTANCE, r4.nozzleDiameters);
    L123:
        if (r5.shouldEncodeElementDefault(r6, 20) == false) goto L126;
    L127:
        r5.encodeNullableSerializableElement(r6, 20, FlutterBoolStringOrNullSerializer.INSTANCE, r4.enableFilamentDynamicMapIn3Mf);
    L129:
        if (r5.shouldEncodeElementDefault(r6, 21) == false) goto L132;
    L133:
        r5.encodeNullableSerializableElement(r6, 21, (SerializationStrategy) r0[21].getValue(), r4.layerFilamentLists);
    L135:
        if (r5.shouldEncodeElementDefault(r6, 22) == false) goto L138;
    L139:
        r5.encodeNullableSerializableElement(r6, 22, (SerializationStrategy) r0[22].getValue(), r4.printNozzlesForMultiNozzleMachine);
        return;
    L138:
        if (r4.printNozzlesForMultiNozzleMachine != null) goto L139;
        return;
    L132:
        if (r4.layerFilamentLists == null) goto L135;
    L126:
        if (r4.enableFilamentDynamicMapIn3Mf == null) goto L129;
    L120:
        if (r4.nozzleDiameters == null) goto L123;
    L114:
        if (r4.nozzleVolumeType == null) goto L117;
    L108:
        if (r4.limitFilamentMaps == null) goto L111;
    L102:
        if (r4.filamentMaps == null) goto L105;
    L96:
        if (r4.gcode == null) goto L99;
    L90:
        if (r4.warning == null) goto L93;
    L84:
        if (r4.printed == null) goto L87;
    L78:
        if (r4.nozzleType == null) goto L81;
    L72:
        if (r4.filaments == null) goto L75;
    L66:
        if (r4.supportObjectSkipped == null) goto L69;
    L60:
        if (r4.skippedObjects == null) goto L63;
    L54:
        if (r4.objects == null) goto L57;
    L48:
        if (r4.weight == null) goto L51;
    L42:
        if (r4.prediction == null) goto L45;
    L36:
        if (r4.noLightPicture == null) goto L39;
    L30:
        if (r4.pickPicture == null) goto L33;
    L24:
        if (r4.topPicture == null) goto L27;
    L18:
        if (r4.thumbnail == null) goto L21;
    L12:
        if (r4.name == null) goto L15;
    L6:
        if (r4.index == null) goto L9;
        goto L7
    }

    public final Integer component1() {
        return this.index;
    }

    public final List<IotPlateObjectId> component10() {
        return this.skippedObjects;
    }

    public final Boolean component11() {
        return this.supportObjectSkipped;
    }

    public final List<IotFilament> component12() {
        return this.filaments;
    }

    public final Integer component13() {
        return this.nozzleType;
    }

    public final Boolean component14() {
        return this.printed;
    }

    public final List<PlateWarning> component15() {
        return this.warning;
    }

    public final PlateImage component16() {
        return this.gcode;
    }

    public final String component17() {
        return this.filamentMaps;
    }

    public final String component18() {
        return this.limitFilamentMaps;
    }

    public final List<Integer> component19() {
        return this.nozzleVolumeType;
    }

    public final String component2() {
        return this.name;
    }

    public final List<Double> component20() {
        return this.nozzleDiameters;
    }

    public final Boolean component21() {
        return this.enableFilamentDynamicMapIn3Mf;
    }

    public final List<IotLayerFilamentList> component22() {
        return this.layerFilamentLists;
    }

    public final List<IotNozzle> component23() {
        return this.printNozzlesForMultiNozzleMachine;
    }

    public final PlateImage component3() {
        return this.thumbnail;
    }

    public final PlateImage component4() {
        return this.topPicture;
    }

    public final PlateImage component5() {
        return this.pickPicture;
    }

    public final PlateImage component6() {
        return this.noLightPicture;
    }

    public final Integer component7() {
        return this.prediction;
    }

    public final Double component8() {
        return this.weight;
    }

    public final List<IotPlateObjectId> component9() {
        return this.objects;
    }

    public final IotPlate copy(Integer r25, String r26, PlateImage r27, PlateImage r28, PlateImage r29, PlateImage r30, Integer r31, Double r32, List<IotPlateObjectId> r33, List<IotPlateObjectId> r34, Boolean r35, List<IotFilament> r36, Integer r37, Boolean r38, List<PlateWarning> r39, PlateImage r40, String r41, String r42, List<Integer> r43, List<Double> r44, Boolean r45, List<IotLayerFilamentList> r46, List<IotNozzle> r47) {
        return new IotPlate(r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36, r37, r38, r39, r40, r41, r42, r43, r44, r45, r46, r47);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof IotPlate) == true) goto L8;
        return false;
    L8:
        IotPlate r52 = (IotPlate) r5;
        if (lsf.l(this.index, r52.index) == true) goto L12;
        return false;
    L12:
        if (lsf.l(this.name, r52.name) == true) goto L15;
        return false;
    L15:
        if (lsf.l(this.thumbnail, r52.thumbnail) == true) goto L18;
        return false;
    L18:
        if (lsf.l(this.topPicture, r52.topPicture) == true) goto L21;
        return false;
    L21:
        if (lsf.l(this.pickPicture, r52.pickPicture) == true) goto L24;
        return false;
    L24:
        if (lsf.l(this.noLightPicture, r52.noLightPicture) == true) goto L27;
        return false;
    L27:
        if (lsf.l(this.prediction, r52.prediction) == true) goto L30;
        return false;
    L30:
        if (lsf.l(this.weight, r52.weight) == true) goto L33;
        return false;
    L33:
        if (lsf.l(this.objects, r52.objects) == true) goto L36;
        return false;
    L36:
        if (lsf.l(this.skippedObjects, r52.skippedObjects) == true) goto L39;
        return false;
    L39:
        if (lsf.l(this.supportObjectSkipped, r52.supportObjectSkipped) == true) goto L42;
        return false;
    L42:
        if (lsf.l(this.filaments, r52.filaments) == true) goto L45;
        return false;
    L45:
        if (lsf.l(this.nozzleType, r52.nozzleType) == true) goto L48;
        return false;
    L48:
        if (lsf.l(this.printed, r52.printed) == true) goto L51;
        return false;
    L51:
        if (lsf.l(this.warning, r52.warning) == true) goto L54;
        return false;
    L54:
        if (lsf.l(this.gcode, r52.gcode) == true) goto L57;
        return false;
    L57:
        if (lsf.l(this.filamentMaps, r52.filamentMaps) == true) goto L60;
        return false;
    L60:
        if (lsf.l(this.limitFilamentMaps, r52.limitFilamentMaps) == true) goto L63;
        return false;
    L63:
        if (lsf.l(this.nozzleVolumeType, r52.nozzleVolumeType) == true) goto L66;
        return false;
    L66:
        if (lsf.l(this.nozzleDiameters, r52.nozzleDiameters) == true) goto L69;
        return false;
    L69:
        if (lsf.l(this.enableFilamentDynamicMapIn3Mf, r52.enableFilamentDynamicMapIn3Mf) == true) goto L72;
        return false;
    L72:
        if (lsf.l(this.layerFilamentLists, r52.layerFilamentLists) == true) goto L75;
        return false;
    L75:
        if (lsf.l(this.printNozzlesForMultiNozzleMachine, r52.printNozzlesForMultiNozzleMachine) == true) goto L77;
        return false;
    L77:
        return true;
    }

    public final Boolean getEnableFilamentDynamicMapIn3Mf() {
        return this.enableFilamentDynamicMapIn3Mf;
    }

    public final String getFilamentMaps() {
        return this.filamentMaps;
    }

    public final List<IotFilament> getFilaments() {
        return this.filaments;
    }

    public final PlateImage getGcode() {
        return this.gcode;
    }

    public final Integer getIndex() {
        return this.index;
    }

    public final List<IotLayerFilamentList> getLayerFilamentLists() {
        return this.layerFilamentLists;
    }

    public final String getLimitFilamentMaps() {
        return this.limitFilamentMaps;
    }

    public final String getName() {
        return this.name;
    }

    public final PlateImage getNoLightPicture() {
        return this.noLightPicture;
    }

    public final List<Double> getNozzleDiameters() {
        return this.nozzleDiameters;
    }

    public final Integer getNozzleType() {
        return this.nozzleType;
    }

    public final List<Integer> getNozzleVolumeType() {
        return this.nozzleVolumeType;
    }

    public final List<IotPlateObjectId> getObjects() {
        return this.objects;
    }

    public final PlateImage getPickPicture() {
        return this.pickPicture;
    }

    public final Integer getPrediction() {
        return this.prediction;
    }

    public final List<IotNozzle> getPrintNozzlesForMultiNozzleMachine() {
        return this.printNozzlesForMultiNozzleMachine;
    }

    public final Boolean getPrinted() {
        return this.printed;
    }

    public final List<IotPlateObjectId> getSkippedObjects() {
        return this.skippedObjects;
    }

    public final Boolean getSupportObjectSkipped() {
        return this.supportObjectSkipped;
    }

    public final PlateImage getThumbnail() {
        return this.thumbnail;
    }

    public final PlateImage getTopPicture() {
        return this.topPicture;
    }

    public final List<PlateWarning> getWarning() {
        return this.warning;
    }

    public final Double getWeight() {
        return this.weight;
    }

    public int hashCode() {
        Integer r0 = this.index;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r02 = 0;
    L6:
        int r03 = r02 * 31;
        String r2 = this.name;
        if (r2 != null) goto L9;
        int r22 = 0;
    L10:
        int r04 = (r03 + r22) * 31;
        PlateImage r23 = this.thumbnail;
        if (r23 != null) goto L13;
        int r24 = 0;
    L14:
        int r05 = (r04 + r24) * 31;
        PlateImage r25 = this.topPicture;
        if (r25 != null) goto L17;
        int r26 = 0;
    L18:
        int r06 = (r05 + r26) * 31;
        PlateImage r27 = this.pickPicture;
        if (r27 != null) goto L21;
        int r28 = 0;
    L22:
        int r07 = (r06 + r28) * 31;
        PlateImage r29 = this.noLightPicture;
        if (r29 != null) goto L25;
        int r210 = 0;
    L26:
        int r08 = (r07 + r210) * 31;
        Integer r211 = this.prediction;
        if (r211 != null) goto L29;
        int r212 = 0;
    L30:
        int r09 = (r08 + r212) * 31;
        Double r213 = this.weight;
        if (r213 != null) goto L33;
        int r214 = 0;
    L34:
        int r010 = (r09 + r214) * 31;
        List<IotPlateObjectId> r215 = this.objects;
        if (r215 != null) goto L37;
        int r216 = 0;
    L38:
        int r011 = (r010 + r216) * 31;
        List<IotPlateObjectId> r217 = this.skippedObjects;
        if (r217 != null) goto L41;
        int r218 = 0;
    L42:
        int r012 = (r011 + r218) * 31;
        Boolean r219 = this.supportObjectSkipped;
        if (r219 != null) goto L45;
        int r220 = 0;
    L46:
        int r013 = (r012 + r220) * 31;
        List<IotFilament> r221 = this.filaments;
        if (r221 != null) goto L49;
        int r222 = 0;
    L50:
        int r014 = (r013 + r222) * 31;
        Integer r223 = this.nozzleType;
        if (r223 != null) goto L53;
        int r224 = 0;
    L54:
        int r015 = (r014 + r224) * 31;
        Boolean r225 = this.printed;
        if (r225 != null) goto L57;
        int r226 = 0;
    L58:
        int r016 = (r015 + r226) * 31;
        List<PlateWarning> r227 = this.warning;
        if (r227 != null) goto L61;
        int r228 = 0;
    L62:
        int r017 = (r016 + r228) * 31;
        PlateImage r229 = this.gcode;
        if (r229 != null) goto L65;
        int r230 = 0;
    L66:
        int r018 = (r017 + r230) * 31;
        String r231 = this.filamentMaps;
        if (r231 != null) goto L69;
        int r232 = 0;
    L70:
        int r019 = (r018 + r232) * 31;
        String r233 = this.limitFilamentMaps;
        if (r233 != null) goto L73;
        int r234 = 0;
    L74:
        int r020 = (r019 + r234) * 31;
        List<Integer> r235 = this.nozzleVolumeType;
        if (r235 != null) goto L77;
        int r236 = 0;
    L78:
        int r021 = (r020 + r236) * 31;
        List<Double> r237 = this.nozzleDiameters;
        if (r237 != null) goto L81;
        int r238 = 0;
    L82:
        int r022 = (r021 + r238) * 31;
        Boolean r239 = this.enableFilamentDynamicMapIn3Mf;
        if (r239 != null) goto L85;
        int r240 = 0;
    L86:
        int r023 = (r022 + r240) * 31;
        List<IotLayerFilamentList> r241 = this.layerFilamentLists;
        if (r241 != null) goto L89;
        int r242 = 0;
    L90:
        int r024 = (r023 + r242) * 31;
        List<IotNozzle> r3 = this.printNozzlesForMultiNozzleMachine;
        if (r3 == null) goto L95;
        r1 = r3.hashCode();
    L95:
        return r024 + r1;
    L89:
        r242 = r241.hashCode();
        goto L90
    L85:
        r240 = r239.hashCode();
        goto L86
    L81:
        r238 = r237.hashCode();
        goto L82
    L77:
        r236 = r235.hashCode();
        goto L78
    L73:
        r234 = r233.hashCode();
        goto L74
    L69:
        r232 = r231.hashCode();
        goto L70
    L65:
        r230 = r229.hashCode();
        goto L66
    L61:
        r228 = r227.hashCode();
        goto L62
    L57:
        r226 = r225.hashCode();
        goto L58
    L53:
        r224 = r223.hashCode();
        goto L54
    L49:
        r222 = r221.hashCode();
        goto L50
    L45:
        r220 = r219.hashCode();
        goto L46
    L41:
        r218 = r217.hashCode();
        goto L42
    L37:
        r216 = r215.hashCode();
        goto L38
    L33:
        r214 = r213.hashCode();
        goto L34
    L29:
        r212 = r211.hashCode();
        goto L30
    L25:
        r210 = r29.hashCode();
        goto L26
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
        Integer r1 = this.index;
        String r2 = this.name;
        PlateImage r3 = this.thumbnail;
        PlateImage r4 = this.topPicture;
        PlateImage r5 = this.pickPicture;
        PlateImage r6 = this.noLightPicture;
        Integer r7 = this.prediction;
        Double r8 = this.weight;
        List<IotPlateObjectId> r9 = this.objects;
        List<IotPlateObjectId> r10 = this.skippedObjects;
        Boolean r11 = this.supportObjectSkipped;
        List<IotFilament> r12 = this.filaments;
        Integer r13 = this.nozzleType;
        Boolean r14 = this.printed;
        List<PlateWarning> r15 = this.warning;
        PlateImage r152 = this.gcode;
        String r153 = this.filamentMaps;
        String r154 = this.limitFilamentMaps;
        List<Integer> r155 = this.nozzleVolumeType;
        List<Double> r156 = this.nozzleDiameters;
        Boolean r157 = this.enableFilamentDynamicMapIn3Mf;
        List<IotLayerFilamentList> r158 = this.layerFilamentLists;
        List<IotNozzle> r0 = this.printNozzlesForMultiNozzleMachine;
        StringBuilder r02 = i3e.k(r1, "IotPlate(index=", ", name=", r2, ", thumbnail=");
        r02.append(r3);
        r02.append(", topPicture=");
        r02.append(r4);
        r02.append(", pickPicture=");
        r02.append(r5);
        r02.append(", noLightPicture=");
        r02.append(r6);
        r02.append(", prediction=");
        r02.append(r7);
        r02.append(", weight=");
        r02.append(r8);
        r02.append(", objects=");
        bsa.q(r02, r9, ", skippedObjects=", r10, ", supportObjectSkipped=");
        r02.append(r11);
        r02.append(", filaments=");
        r02.append(r12);
        r02.append(", nozzleType=");
        t4m.v(r02, r13, ", printed=", r14, ", warning=");
        r02.append(r15);
        r02.append(", gcode=");
        r02.append(r152);
        r02.append(", filamentMaps=");
        r77.C(r02, r153, ", limitFilamentMaps=", r154, ", nozzleVolumeType=");
        bsa.q(r02, r155, ", nozzleDiameters=", r156, ", enableFilamentDynamicMapIn3Mf=");
        r02.append(r157);
        r02.append(", layerFilamentLists=");
        r02.append(r158);
        r02.append(", printNozzlesForMultiNozzleMachine=");
        return kn2.q(r02, r0, ")");
    }
}
