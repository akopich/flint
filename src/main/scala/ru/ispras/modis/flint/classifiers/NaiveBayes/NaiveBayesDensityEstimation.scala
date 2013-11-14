

import ru.ispras.modis.flint.classifiers.{DensityEstimator, DensityEstimation}

/**
 * Created with IntelliJ IDEA.
 * User: lena
 * Date: 13.11.13
 * Time: 1:11
 * To change this template use File | Settings | File Templates.
 */
class NaiveBayesDensityEstimation[LabelType](val label: LabelType, val labelProb: Double,val  featProb: Double){


  //def apply(label: LabelType, featureProb: Double, labelProb: Double): DensityEstimation[LabelType]

}
