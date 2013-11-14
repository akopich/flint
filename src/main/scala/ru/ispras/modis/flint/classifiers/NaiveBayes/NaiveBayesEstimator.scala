
/**
 * Created with IntelliJ IDEA.
 * User: lena
 * Date: 10.11.13
 * Time: 21:01
 * To change this template use File | Settings | File Templates.
 */
package ru.ispras.modis.flint.classifiers.Na

import ru.ispras.modis.flint.classifiers
import ru.ispras.modis.flint.classifiers.{DensityEstimation, Classifier, ClassifierTrainer, DensityEstimator}
import ru.ispras.modis.flint.instances.LabelledInstance
import ru.ispras.modis.flint.instances.LabelledInstance
import ru.ispras.modis.flint.instances.LabelledInstance
import ru.ispras.modis.flint.instances.LabelledInstance
import ru.ispras.modis.flint.instances.LabelledInstance
import ru.ispras.modis.flint.instances.LabelledInstance
import ru.ispras.modis.flint.instances.LabelledInstance,ru.ispras.modis.flint.instances.Feature,ru.ispras.modis.flint.instances.Instance,ru.ispras.modis.flint.instances.Feature;
import org.apache.spark.rdd.RDD
import scala.math.log

class NaiveBayesEstimator[LabelType](data: RDD[LabelledInstance[LabelType]]) extends DensityEstimation[LabelType] with ClassifierTrainer[LabelType] with Classifier[LabelType] {


 def apply(data: RDD[LabelledInstance[LabelType]]): DensityEstimation[LabelType] = {

    val dataSize = data.count(); //quantatity of objects in training set

    val (label: LabelType, labelSum: Long) = data.map(_.label).countByValue().maxBy(_._2);

    val (id:Int,value: Long) = data.map(_.map(_.featureId)).countByValue().maxBy(_._2); // count the number of feature x=1

    val Featuresize:Long = data.map(_.label).count();

    val FeatProb  = log(value.toDouble/Featuresize.toDouble);

    new NaiveBayesDensityEstimation[LabelType](label, log(labelSum.toDouble/dataSize.toDouble), FeatProb)

  }
}

class NaiveBayesDensityEstimation[LabelType](val label: LabelType, val labelProb: Double,val  featProb: Double){


  //def apply(label: LabelType, featureProb: Double, labelProb: Double): DensityEstimation[LabelType]

}