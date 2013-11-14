import org.apache.spark.rdd.RDD
import ru.ispras.modis.flint.classifiers.Na.NaiveBayesEstimator
import ru.ispras.modis.flint.classifiers.{DensityEstimation, ClassifierTrainer, DensityEstimator, NaiveBayesEstimator}
import ru.ispras.modis.flint.instances.LabelledInstance;
import scala.concurrent.duration.DurationConversions.Classifier

/**
 * Created with IntelliJ IDEA.
 * User: lena
 * Date: 13.11.13
 * Time: 0:55
 * To change this template use File | Settings | File Templates.
 */
class NaiveBayesClassifierTrainer[LabelType: Manifest] extends ClassifierTrainer[LabelType] {

  def apply(data: RDD[LabelledInstance[LabelType]]): Classifier[LabelType] = {

    val trainData: DensityEstimation[LabelType] = new NaiveBayesEstimator[LabelType](data);

    new NaiveBayesClassifier[LabelType](trainData);
  }

}
