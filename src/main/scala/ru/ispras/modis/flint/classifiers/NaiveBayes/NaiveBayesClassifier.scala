import ru.ispras.modis.flint.classifiers.{ClassifierTrainer, ClassificationResult, DensityEstimation, Classifier}
import ru.ispras.modis.flint.instances.{Feature, Instance}

/**
 * Created with IntelliJ IDEA.
 * User: lena
 * Date: 13.11.13
 * Time: 1:06
 * To change this template use File | Settings | File Templates.
 */
class NaiveBayesClassifier[LabelType](Data:DensityEstimation[LabelType]) extends Classifier[LabelType] with ClassifierTrainer[LabelType] {

  def apply(instance: Instance): ClassificationResult[LabelType] = new ClassificationResult[LabelType](label, Option[Feature]);

}
