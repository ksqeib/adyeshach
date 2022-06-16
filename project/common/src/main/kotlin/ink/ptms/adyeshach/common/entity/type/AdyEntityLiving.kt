package ink.ptms.adyeshach.common.entity.type

import ink.ptms.adyeshach.common.entity.EntityEquipable
import org.bukkit.Color
import org.bukkit.entity.Player

/**
 * @author sky
 * @since 2020-08-04 18:28
 */
abstract class AdyEntityLiving : AdyEntity(), EntityEquipable {

    open var isHandActive: Boolean
        get() = getMetadata("isHandActive")
        set(value) {
            setMetadata("isHandActive", value)
        }

    open var activeHand: Boolean
        get() = getMetadata("activeHand")
        set(value) {
            setMetadata("activeHand", value)
        }

    /**
     * 实体是否处于激流
     */
    open var isInRiptideSpinAttack: Boolean
        get() = getMetadata("isInRiptideSpinAttack")
        set(value) {
            setMetadata("isInRiptideSpinAttack", value)
        }

    /**
     * 实体身上存在的箭矢，经过测试这个属性只对玩家类型有效
     */
    open var arrowsInEntity: Int
        get() = getMetadata("arrowsInEntity")
        set(value) {
            setMetadata("arrowsInEntity", value)
        }

    /**
     * 实体身上存在的蜂刺，经过测试这个属性只对玩家类型有效
     */
    open var beeStingersInEntity: Int
        get() = getMetadata("beeStingersInEntity")
        set(value) {
            setMetadata("beeStingersInEntity", value)
        }

    /**
     * 切换数据包实体的死亡状态，该功能是通过利用客户端渲染漏洞实现，无法保证稳定性
     */
    abstract fun die(die: Boolean = true)

    /**
     * 对给定玩家切换数据包实体的死亡状态
     */
    abstract fun die(viewer: Player, die: Boolean = true)

    /**
     * 设置实体生命
     */
    open fun setHealth(value: Float) {
        setMetadata("health", value)
    }

    /**
     * 获取实体生命
     */
    open fun getHealth(): Float {
        return getMetadata("health")
    }

    /**
     * 设置实体药水颜色
     */
    open fun setPotionEffectColor(value: Color) {
        setMetadata("potionEffectColor", value.asRGB())
    }

    /**
     * 获取实体药水颜色
     */
    open fun getPotionEffectColor(): Color {
        return Color.fromRGB(getMetadata<Int>("potionEffectColor").coerceAtLeast(0))
    }
}