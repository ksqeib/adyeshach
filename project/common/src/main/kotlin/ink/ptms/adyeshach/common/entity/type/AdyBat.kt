package ink.ptms.adyeshach.common.entity.type

/**
 * @author sky
 * @since 2020-08-04 19:30
 */
abstract class AdyBat : AdyMob() {

    open fun setHanging(value: Boolean) {
        setMetadata("isHanging", value)
    }

    open fun isHanging(): Boolean {
        return getMetadata("isHanging")
    }
}