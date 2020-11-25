# True OOP
Alan Key's Oop on Java. For fun only :joy:

In the *ru.mrkefir.true_oop.sample* package you can find example of using this "lib".  
To run this sample go to bin/sample. Here you can find executable trueOop-sample.jar.  
Just use:
```java -jar trueOop-sample.jar ROBOT IVT SPPO RANDOM FULL_MOON```  
Replace capital words with true or false boolean command line parameters. This sample  
expulses three students. Each of them belongs to one of three departments: robot, ivt, sppo.  
If you use false, for example, instead of ```IVT```, when program will not try to expulse  
a student of this department.

Try to play with ```RANDOM``` and ```FULL_MOON``` to find out its meanings :)

Please, be sure that you pass exactly 5 boolean command line params.

## Like Alan Key belive:  
- **Message** - an unit of information that can be passed between objects.
- **Object** - an abstract class which defines an Object with one abstract method *accept*.  
This method is used to invoke object via Message mediator.
- **MessageMediator** - implements pattern Mediator and serves for object communication.

## Benefits:  
- :open_mouth: We don't need to think about object types. All that we need - create a subclass of Object,  
create it's instance (which will be automatically registered in Message mediator). After  
these steps we can send a message to object by it's name. Message will trigger some logic  
and deliver necessary information.  
- :scream: We have maximum of flexibility in out program! We can create necessary objects and delete  
unused in runtime. All our classes are low coupled.  

## Limitations:
- :cry: Still we need to explicitly cast all java.lang.Object-s which we are passing in a message.
- :sob: We need to be attentive with object names and message sending. Here is a huge field for  
mistakes.
- :weary: One object has only one accept method. It means that we can use only one *interface* mehod  
per object.

So, as I said above, this repo is for fun only. But you can try to create something big with that!

:pencil2: Contact me if you want to suggest ideas to improve this "lib" :)
