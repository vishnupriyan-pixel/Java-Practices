
import cypressTest from "./cypressTest";

describe('AutoComplete',function(){

  it('Visits jQuery Autocomplete', function(){
    const auto1 = new cypressTest()
   auto1.visit1()
   cy.url().then(url => {
    cy.url().should('be.eq', url);
  })
  })

  it('Visits SpecialCharacters_Autocomplete', ()=> {
    cy.get('iframe').then(($iframe)=>{
      const $input = $iframe.contents().find('body').find('div').find('input');
      let auto2 = cy.wrap($input)
      auto2.type('!@@$%');
      auto2.type('{enter}');
      auto2.wait(1000)
      auto2.should('be.enabled')
      auto2.should($inputfield => expect($inputfield).to.be.visible)
    })
})

it('Visits Numbers_AutoComplete', ()=> {
  cy.get('iframe').then(($iframe)=>{
    const $input = $iframe.contents().find('body').find('div').find('input');
    let auto2 = cy.wrap($input)
    auto2.clear();
    auto2.type('5468790');
    auto2.type('{enter}');
    auto2.wait(1000)
    auto2.should('be.enabled')
    auto2.should($inputfield => expect($inputfield).to.be.visible)
  })
})

  it('Visits AutoComplete', ()=> {
    cy.get('iframe').then(($iframe)=>{
      const $input = $iframe.contents().find('body').find('div').find('input');
      let auto2 = cy.wrap($input)
      auto2.clear()
      .type('tywiuhivxouywop')
      .clear()
      auto2.type('JavaS')
      auto2.type('{downarrow}')
      auto2.type('{downarrow}')
      // .wait(800)
      .click()
      auto2.wait(1000)
      auto2.should('be.enabled')
      auto2.should($inputfield => expect($inputfield).to.be.visible)
      expect({ name: 'JavaScript' }).to.deep.equal({ name: 'JavaScript' })
    })
})

})

describe('Buttons', function(){
    it('Visits jQuery', function(){
      const rd = new cypressTest()
   rd.visit2()
   cy.url().then(url => {
    cy.url().should('be.eq', url);
    })
  })

  it('Visits_Widget_Button', function(){
    const rd = new cypressTest()
   rd.chck_iframe()
   cy.get('.demo-frame')
     .then(($iframe) => {
       const $button = $iframe.contents().find('body').find('div')

       let btn1 = cy.wrap($button)
      btn1.xpath('//div[@class="widget"]//button').click({force: true})
      btn1.wait(700)
      btn1.should('be.visible')
      btn1.xpath('//div[@class="widget"]//button').should('have.css', 'background-color', 'rgb(237, 237, 237)')

    })

  })

  it('Visits_Widget_Submit_Button', function(){
    const rd = new cypressTest()
   rd.chck_iframe()
   cy.get('.demo-frame')
     .then(($iframe) => {
       const $button = $iframe.contents().find('body').find('div')

       let btn1 = cy.wrap($button)
      btn1.xpath('//div[@class="widget"]//input').click({force: true})
      btn1.wait(700)
      btn1.should('be.visible')
      btn1.xpath('//div[@class="widget"]//input').should('have.css', 'background-color', 'rgb(237, 237, 237)')

    })

  })

  it('Visits_Widget_Anchor', function(){
    const rd = new cypressTest()
   rd.chck_iframe()
   cy.get('.demo-frame')
     .then(($iframe) => {
       const $button = $iframe.contents().find('body').find('div')

       let btn1 = cy.wrap($button)
      btn1.xpath('//div[@class="widget"]//a').click({force: true})
      btn1.wait(700)
      btn1.should('be.visible')
      btn1.xpath('//div[@class="widget"]//a').should('have.css', 'background-color', 'rgb(237, 237, 237)')

    })

  })

  it('Visits_CSS_Button', function(){
    const rd = new cypressTest()
   rd.chck_iframe()
   cy.get('.demo-frame')
     .then(($iframe) => {
       const $button = $iframe.contents().find('body>button')

       let btn1 = cy.wrap($button)
      btn1.contains('button', 'A button element').click({force: true})
      btn1.wait(900)
      btn1.should('be.visible')
      btn1.contains('button', 'A button element').should('have.css', 'background-color', 'rgb(237, 237, 237)')

    })

  })

  it('Visits_CSS_SubmitButton', function(){
    const rd = new cypressTest()
   rd.chck_iframe()
   cy.get('.demo-frame')
     .then(($iframe) => {
       const $button = $iframe.contents().find('body>input')

       let btn1 = cy.wrap($button)
      btn1.click({force: true})
      btn1.wait(900)
      btn1.should('be.visible')
      expect({ type: 'submit' }).to.deep.equal({ type: 'submit' })

    })

  })

  it('Visits_CSS_Anchor', function(){
    const rd = new cypressTest()
   rd.chck_iframe()
   cy.get('.demo-frame')
     .then(($iframe) => {
       const $button = $iframe.contents().find('body>a')

       let btn1 = cy.wrap($button)
      btn1.contains('a', 'An anchor').click({force: true})
      btn1.wait(900)
      btn1.should('be.visible')
      btn1.contains('a', 'An anchor').should('have.css', 'background-color', 'rgb(237, 237, 237)')

    })

  })
})

describe('Radio_button & CheckBox', function(){

  it('Visits jQuery Checkboxradio', function(){
   const rd = new cypressTest()
   rd.visit3()
   cy.url().then(url => {
    // cy.get('.editor-toolbar-actions-save').click();
    cy.url().should('be.eq', url);
  })
})

it('Visits radio_button1', function(){
  const rd = new cypressTest()
   rd.chck_iframe()
   cy.get('.demo-frame')
     .then(($iframe) => {
       const $body = $iframe.contents().find('body')

      cy.wrap($body)
        .find('#radio-1')
        .click({force: true})
        .should('be.checked')

    let rd1 = cy.wrap($body)
    rd1.find('.ui-checkboxradio-label').should('contain.text', 'New York')
    })
  })

  it('Visits radio_button2', function(){
     cy.get('.demo-frame')
     .then(($iframe) => {
       const $body = $iframe.contents().find('body')

      cy.wrap($body)
        .find('#radio-2')
        .click({force: true})
        .should('be.checked')

    let rd2 = cy.wrap($body)
    rd2.find('.ui-checkboxradio-label').should('contain.text', 'Paris')
    })
  })

  it('Visits radio_button3', function(){
    cy.get('.demo-frame')
    .then(($iframe) => {
      const $body = $iframe.contents().find('body')

      cy.wrap($body)
        .find('#radio-3')
        .click({force: true})
        .should('be.checked')
    let rd3 = cy.wrap($body)
    rd3.find('.ui-checkboxradio-label').should('contain.text', 'London')
    })
  })

  it('Visits checkbox1', function(){
     cy.get('.demo-frame')
    .then(($iframe) => {
      const $body = $iframe.contents().find('body')

      cy.wrap($body)
        .find('#checkbox-1').scrollIntoView()
        .uncheck({force: true})
        .not('be.checked')
        .check({force: true})
        .should('be.checked')
        let chk1 = cy.wrap($body)
        chk1.find('.ui-checkboxradio-label').should('contain.text', '2 Star')

    })
  })

  it('Visits checkbox2', function(){
    cy.get('.demo-frame')
    .then(($iframe) => {
      const $body = $iframe.contents().find('body')

      cy.wrap($body)
        .find('#checkbox-2').scrollIntoView()
        .uncheck({force: true})
        .not('be.checked')
        .check({force: true})
        .should('be.checked')
        let chk2 = cy.wrap($body)
        chk2.find('.ui-checkboxradio-label').should('contain.text', '3 Star')
    })

  })

  it('Visits checkbox3', function(){
    cy.get('.demo-frame')
    .then(($iframe) => {
      const $body = $iframe.contents().find('body')

      cy.wrap($body)
        .find('#checkbox-3').scrollIntoView()
        .uncheck({force: true})
        .not('be.checked')
        .check({force: true})
        .should('be.checked')
        let chk3 = cy.wrap($body)
        chk3.find('.ui-checkboxradio-label').should('contain.text', '4 Star')
    })
  })

  it('Visits checkbox4', function(){
    cy.get('.demo-frame')
    .then(($iframe) => {
      const $body = $iframe.contents().find('body')

      cy.wrap($body)
        .find('#checkbox-4').scrollIntoView()
        .uncheck({force: true})
        .not('be.checked')
        .check({force: true})
        .should('be.checked')
        let chk4 = cy.wrap($body)
        chk4.find('.ui-checkboxradio-label').should('contain.text', '5 Star')
    })
  })

  it('Visits checkbox_nested1', function(){
    cy.get('.demo-frame')
    .then(($iframe) => {
      const $body = $iframe.contents().find('body')

      cy.wrap($body)
        .find('#checkbox-nested-1').scrollIntoView()
        .uncheck({force: true})
        .not('be.checked')
        .check({force: true})
        .should('be.checked')
        let chkn1 = cy.wrap($body)
        chkn1.find('.ui-checkboxradio-label').should('contain.text', '2 Double')
    })
  })

  it('Visits checkbox_nested2', function(){
    cy.get('.demo-frame')
    .then(($iframe) => {
      const $body = $iframe.contents().find('body')

      cy.wrap($body)
        .find('#checkbox-nested-2').scrollIntoView()
        .uncheck({force: true})
        .not('be.checked')
        .check({force: true})
        .should('be.checked')
        let chkn2 = cy.wrap($body)
        chkn2.find('.ui-checkboxradio-label').should('contain.text', '2 Queen')
      })
    })

    it('Visits checkbox_nested3', function(){
      cy.get('.demo-frame')
      .then(($iframe) => {
        const $body = $iframe.contents().find('body')

        cy.wrap($body)
          .find('#checkbox-nested-3').scrollIntoView()
          .uncheck({force: true})
          .not('be.checked')
          .check({force: true})
          .should('be.checked')
          let chkn3 = cy.wrap($body)
          chkn3.find('.ui-checkboxradio-label').should('contain.text', '1 Queen')
        })

      })

      it('Visits checkbox_nested4', function(){
        cy.get('.demo-frame')
        .then(($iframe) => {
          const $body = $iframe.contents().find('body')

          cy.wrap($body)
            .find('#checkbox-nested-4').scrollIntoView()
            .uncheck({force: true})
            .not('be.checked')
            .check({force: true})
            .should('be.checked')
            let chkn4 = cy.wrap($body)
            chkn4.find('.ui-checkboxradio-label').should('contain.text', '1 King')
          })

        })

})


describe('Controlgroup', function(){
  it('Visits jQuery Controlgroup', function(){
    const rd = new cypressTest()
    rd.visit4()
    cy.url().then(url => {
     cy.url().should('be.eq', url);
   })
 })
  it('Visits Rental_car_dropdown1(Fieldset1)', function(){
    cy.get('.demo-frame')
    .then(($iframe) => {
    const $body = $iframe.contents().find('body')

    cy.wrap($body)
    .find('#car-type').scrollIntoView()
    .select('Compact car', {force: true})
    expect({ name: 'Compact car' }).to.deep.equal({ name: 'Compact car' })
    })
  })

  it('Visits Rental_car_dropdown2(Fieldset1)', function(){
    cy.get('.demo-frame')
    .then(($iframe) => {
      const $body = $iframe.contents().find('body')

      cy.wrap($body)
      .find('#car-type-button').click({force: true})
      .type('{downarrow}')
      .wait(800)
      .type('{enter}')
       expect({ name: 'Midsize car' }).to.deep.equal({ name: 'Midsize car' })
      })
  })

  it('Visits Rental_car_dropdown3(Fieldset1)', function(){
      cy.get('.demo-frame')
      .then(($iframe) => {
      const $body = $iframe.contents().find('body')

      cy.wrap($body)
      .find('#car-type-button').click({force: true})
      .type('{downarrow}')
      .wait(800)
      .type('{enter}')
      expect({ name: 'Full size car' }).to.deep.equal({ name: 'Full size car' })
        })
      })

  it('Visits Rental_car_dropdown4(Fieldset1)', function(){
      cy.get('.demo-frame')
      .then(($iframe) => {
      const $body = $iframe.contents().find('body')

      cy.wrap($body)
      .find('#car-type-button').click({force: true})
      .type('{downarrow}')
      .wait(800)
      .type('{enter}')
      expect({ name: 'SUV' }).to.deep.equal({ name: 'SUV' })
        })
      })

  it('Visits Rental_car_dropdown5(Fieldset1)', function(){
      cy.get('.demo-frame')
      .then(($iframe) => {
      const $body = $iframe.contents().find('body')

      cy.wrap($body)
      .find('#car-type-button').click({force: true})
      .type('{downarrow}')
      .wait(800)
      .type('{enter}')
      expect({ name: 'Luxury' }).to.deep.equal({ name: 'Luxury' })
        })
      })

  it('Visits Rental_car_dropdown6(Fieldset1)', function(){
      cy.get('.demo-frame')
      .then(($iframe) => {
      const $body = $iframe.contents().find('body')

      cy.wrap($body)
      .find('#car-type-button').click({force: true})
      .type('{downarrow}')
      .wait(800)
      .type('{enter}')
      expect({ name: 'Truck' }).to.deep.equal({ name: 'Truck' })
        })
      })

  it('Visits Rental_car_dropdown7(Fieldset1)', function(){
      cy.get('.demo-frame')
      .then(($iframe) => {
      const $body = $iframe.contents().find('body')

      cy.wrap($body)
      .find('#car-type-button').click({force: true})
      .type('{downarrow}')
      .wait(800)
      .type('{enter}')
      expect({ name: 'Van' }).to.deep.equal({ name: 'Van' })
        })
      })

  it('Visits Standard_radio_button(Fieldset1)', function(){
      const rd = new cypressTest()
      rd.chck_iframe()
      cy.get('.demo-frame')
      .then(($iframe) => {
      const $body = $iframe.contents().find('body')

      cy.wrap($body)
      .find('#transmission-standard')
      .click({force: true})
      .should('be.checked')
      expect({ name: 'Standard' }).to.deep.equal({ name: 'Standard' })
        })
      })

  it('Visits Automatic_radio_button(Fieldset1)', function(){
      const rd = new cypressTest()
      rd.chck_iframe()
      cy.get('.demo-frame')
        .then(($iframe) => {
        const $body = $iframe.contents().find('body')

        cy.wrap($body)
        .find('#transmission-automatic')
        .click({force: true})
        .should('be.checked')
        expect({ name: 'Automatic' }).to.deep.equal({ name: 'Automatic' })
        })
    })

  it('Visits Insurance_checkbox(Fieldset1)', function(){
      cy.get('.demo-frame')
      .then(($iframe) => {
      const $body = $iframe.contents().find('body')

      cy.wrap($body)
      .find('#insurance').scrollIntoView()
      .uncheck({force: true})
      .not('be.checked')
      .check({force: true})
      .should('be.checked')
      })
    })

  it('Visits # of cars(Fieldset1)', function(){
      cy.get('.demo-frame')
      .then(($iframe) => {
      const $body = $iframe.contents().find('body')

      cy.wrap($body)
      .find('#horizontal-spinner').click({force: true})
      .type('{downarrow}')
      .type('{downarrow}')
      .wait(800)
      .type('{uparrow}')
      .type('{uparrow}')
      .type('{uparrow}')
      .type('{uparrow}')
      .should($inputfield => expect($inputfield).to.be.visible)
      })
    })

  it('Visits_Booknow_button(Fieldset1)', function(){
    const rd = new cypressTest()
    rd.chck_iframe()
    cy.get('.demo-frame')
    .then(($iframe) => {
    const $button = $iframe.contents().find('body')

    let btn1 = cy.wrap($button)
    .find('.ui-controlgroup-item')
    btn1.contains('button', 'Book Now!').click({force: true})
    btn1.wait(900)
    btn1.should('be.visible')
    btn1.contains('button', 'Book Now!').should('have.css', 'background-color', 'rgb(237, 237, 237)')

    })

  })



    it('Visits Rental_car_dropdown1(Fieldset2)', function(){
      cy.get('.demo-frame')
      .then(($iframe) => {
      const $body = $iframe.contents().find('body')

      cy.wrap($body)
      .find('#ui-id-8').scrollIntoView()
      .select('Compact car', {force: true})
      expect({ name: 'Compact car' }).to.deep.equal({ name: 'Compact car' })
      })
    })

    it('Visits Rental_car_dropdown2(Fieldset2)', function(){
      cy.get('.demo-frame')
      .then(($iframe) => {
        const $body = $iframe.contents().find('body')

        cy.wrap($body)
        .find('#ui-id-8-button').click({force: true})
        .type('{downarrow}')
        .wait(800)
        .type('{enter}')
         expect({ name: 'Midsize car' }).to.deep.equal({ name: 'Midsize car' })
        })
    })

    it('Visits Rental_car_dropdown3(Fieldset2)', function(){
        cy.get('.demo-frame')
        .then(($iframe) => {
        const $body = $iframe.contents().find('body')

        cy.wrap($body)
        .find('#ui-id-8-button').click({force: true})
        .type('{downarrow}')
        .wait(800)
        .type('{enter}')
        expect({ name: 'Full size car' }).to.deep.equal({ name: 'Full size car' })
          })
        })

    it('Visits Rental_car_dropdown4(Fieldset2)', function(){
        cy.get('.demo-frame')
        .then(($iframe) => {
        const $body = $iframe.contents().find('body')

        cy.wrap($body)
        .find('#ui-id-8-button').click({force: true})
        .type('{downarrow}')
        .wait(800)
        .type('{enter}')
        expect({ name: 'SUV' }).to.deep.equal({ name: 'SUV' })
          })
        })

    it('Visits Rental_car_dropdown5(Fieldset2)', function(){
        cy.get('.demo-frame')
        .then(($iframe) => {
        const $body = $iframe.contents().find('body')

        cy.wrap($body)
        .find('#ui-id-8-button').click({force: true})
        .type('{downarrow}')
        .wait(800)
        .type('{enter}')
        expect({ name: 'Luxury' }).to.deep.equal({ name: 'Luxury' })
          })
        })

    it('Visits Rental_car_dropdown6(Fieldset2)', function(){
        cy.get('.demo-frame')
        .then(($iframe) => {
        const $body = $iframe.contents().find('body')

        cy.wrap($body)
        .find('#ui-id-8-button').click({force: true})
        .type('{downarrow}')
        .wait(800)
        .type('{enter}')
        expect({ name: 'Truck' }).to.deep.equal({ name: 'Truck' })
          })
        })

    it('Visits Rental_car_dropdown7(Fieldset2)', function(){
        cy.get('.demo-frame')
        .then(($iframe) => {
        const $body = $iframe.contents().find('body')

        cy.wrap($body)
        .find('#ui-id-8-button').click({force: true})
        .type('{downarrow}')
        .wait(800)
        .type('{enter}')
        expect({ name: 'Van' }).to.deep.equal({ name: 'Van' })
          })
        })

    it('Visits Standard_radio_button-v(Fieldset2)', function(){
        const rd = new cypressTest()
        rd.chck_iframe()
        cy.get('.demo-frame')
        .then(($iframe) => {
        const $body = $iframe.contents().find('body')

        cy.wrap($body)
        .find('#transmission-standard-v')
        .click({force: true})
        .should('be.checked')
        expect({ name: 'Standard' }).to.deep.equal({ name: 'Standard' })
          })
        })

    it('Visits Automatic_radio_button-v(Fieldset2)', function(){
        const rd = new cypressTest()
        rd.chck_iframe()
        cy.get('.demo-frame')
          .then(($iframe) => {
          const $body = $iframe.contents().find('body')

          cy.wrap($body)
          .find('#transmission-automatic-v')
          .click({force: true})
          .should('be.checked')
          expect({ name: 'Automatic' }).to.deep.equal({ name: 'Automatic' })
          })
      })

    it('Visits Insurance_checkbox(Fieldset2)', function(){
        cy.get('.demo-frame')
        .then(($iframe) => {
        const $body = $iframe.contents().find('body')

        cy.wrap($body)
        .find('#insurance-v').scrollIntoView()
        .uncheck({force: true})
        .not('be.checked')
        .check({force: true})
        .should('be.checked')
        })
      })

      it('Visits # of cars(Fieldset2)', function(){
        cy.get('.demo-frame')
        .then(($iframe) => {
        const $body = $iframe.contents().find('body')

        cy.wrap($body)
        .find('#vertical-spinner').click({force: true})
        .type('{downarrow}')
        .type('{downarrow}')
        .wait(800)
        .type('{uparrow}')
        .type('{uparrow}')
        .type('{uparrow}')
        .should($inputfield => expect($inputfield).to.be.visible)
        })
      })

    it('Visits_Booknow_button(Fieldset2)', function(){
      const rd = new cypressTest()
      rd.chck_iframe()
      cy.get('.demo-frame')
      .then(($iframe) => {
      const $button = $iframe.contents().find('body')

      let btn1 = cy.wrap($button)
      .find('#book')
      btn1.contains('button', 'Book Now!').click({force: true})
      btn1.wait(900)
      btn1.should('be.visible')
      btn1.contains('button', 'Book Now!').should('have.css', 'background-color', 'rgb(237, 237, 237)')

      })

    })

})

describe('Datepicker', function(){
  it('Visits jQuery Datepicker', function(){
    const rd = new cypressTest()
    rd.visit5()
    cy.url().then(url => {
     cy.url().should('be.eq', url);
   })
 })

  it('Incorrect data in Datefield', function(){
    const rd = new cypressTest()
    rd.chck_iframe()
    cy.get('.demo-frame')
    .then(($iframe) => {
      const $button = $iframe.contents().find('body')

      let btn1 = cy.wrap($button)
      .find('#datepicker')
      .click({force: true})
      btn1.wait(900)
      .type('1312456076769909')
      .type('{enter}')
      btn1.should('be.visible')
      .should('be.enabled')
    })
  })

  it('valid date in textbox', function(){
    const rd = new cypressTest()
    rd.chck_iframe()
    cy.get('.demo-frame')
    .then(($iframe) => {
      const $button = $iframe.contents().find('body')

      let btn1 = cy.wrap($button)
      .find('#datepicker')
      .click({force: true})
      btn1.wait(900)
      .clear()
      .type('07/22/1990')
      .type('{enter}')
      .click({force: true})
      btn1.should('be.visible')
      .should('be.enabled')
    })
  })

  it('chossing date using next & previous_button', function(){
    const rd = new cypressTest()
    rd.chck_iframe()
    cy.get('.demo-frame')
    .then(($iframe) => {
    const $button = $iframe.contents().find('body')
    let btn1 = cy.wrap($button)
    btn1.contains('Next').should('have.attr', 'data-event', 'click').click()


        const rd = new cypressTest()
        rd.chck_iframe()
        cy.get('.demo-frame')
        .then(($iframe) => {
        const $button = $iframe.contents().find('body').find('table').find('td')
        let btn1 = cy.wrap($button)
        .find('.ui-state-default')
        .contains('a', '22').click()
        .wait(600)
        .should('have.text', '22')

        const rd = new cypressTest()
        rd.chck_iframe()
        cy.get('.demo-frame')
        .then(($iframe) => {
        const $button = $iframe.contents().find('body')
        let btn1 = cy.wrap($button)
        btn1.contains('Prev').should('have.attr', 'data-event', 'click').click({force:true})


        const rd = new cypressTest()
        rd.chck_iframe()
        cy.get('.demo-frame')
        .then(($iframe) => {
        const $button = $iframe.contents().find('body').find('table').find('td')
        let btn1 = cy.wrap($button)
        .find('.ui-state-default')
        .contains('a', '7').click({force:true})
        .wait(600)
        .should('have.text', '7')
        })
      })
    })
    })
  })

  it('Incorrect_date_month_year', function(){
    const rd = new cypressTest()
    rd.chck_iframe()
    cy.get('.demo-frame')
    .then(($iframe) => {
      const $button = $iframe.contents().find('body')

      let btn1 = cy.wrap($button)
      .find('#datepicker')
      .click({force: true})
      btn1.wait(900)
      .clear()
      .type('64/80/16590')
      .type('{enter}')
      .click({force: true})
      btn1.should('be.visible')
      .should('be.enabled')
    })
  })
})

describe('Dialog', function(){
  it('Visits jQuery Dialog', function(){
    const rd = new cypressTest()
    rd.visit6()
    cy.url().then(url => {
    cy.url().should('be.eq', url);
    })
  })

  it('Visits Dialog_box Presence', function(){
    const rd = new cypressTest()
    rd.chck_iframe()
    cy.get('.demo-frame')
    .then(($iframe) => {
    const $dialog = $iframe.contents().find('body')

    let box1 = cy.wrap($dialog)
    .find('.ui-draggable-handle')
    .trigger('mousedown', { which: 1, pageX: 0, pageY: 100 })
    .wait(800)
    .trigger('mousemove', { which: 1, pageX: 100, pageY: 0 })
    .wait(800)
    .trigger('mousemove', { which: 1, pageX: 0, pageY: -200 })
    .wait(800)
    .trigger('mousemove', { which: 1, pageX: -400, pageY: -1000 })
    .wait(800)
    .trigger('mousemove', { which: 1, pageX: 100, pageY: 200 })
    //  .trigger('mouseup')
    .contains('span' ,'Basic dialog').should('be.visible')
    .wait(1000)
    let cancel = cy.wrap($dialog)
    .find('.ui-dialog-titlebar-close').click({force: true})

    let cont1 = cy.wrap($dialog)
    .find('.ui-draggable').should('have.css', 'display', 'none')


    })
  })

})

describe('Visits Menu', function(){
  it('Visits jQuery_Menu', function(){
    const rd = new cypressTest()
    rd.visit7()
    cy.url().then(url => {
    cy.url().should('be.eq', url);
    })
  })

  it('Visits Menu_Lists1', function(){
    const rd = new cypressTest()
    rd.chck_iframe()
    cy.get('.demo-frame')
    .then(($iframe) => {
    const $menu = $iframe.contents().find('body')
    let list1 = cy.wrap($menu)
    list1.find('#menu>li:nth-child(1)')
    .contains('li' , 'Toys (n/a)').should('have.css', 'opacity', '0.35')
    })
  })

  it('Visits Menu_Lists2', function(){
    const rd = new cypressTest()
    rd.chck_iframe()
    cy.get('.demo-frame')
    .then(($iframe) => {
    const $menu = $iframe.contents().find('body')
    let list2 = cy.wrap($menu)
    list2.find('#menu>li:nth-child(2)',{timeout:1200}).trigger('mouseover')
    .find('div' , 'books').should('have.css', 'color', 'rgb(255, 255, 255)')
    })
  })

  it('Visits Menu_Lists3', function(){
    const rd = new cypressTest()
    rd.chck_iframe()
    cy.get('.demo-frame')
    .then(($iframe) => {
    const $menu = $iframe.contents().find('body')
    let list3 = cy.wrap($menu)
    list3.find('#menu>li:nth-child(3)',{timeout:1200}).trigger('mouseover')
    .find('div' , 'Clothing').should('have.css', 'color', 'rgb(255, 255, 255)')
    })
  })

  it('Visits Menu_Lists4', function(){
    const rd = new cypressTest()
    rd.chck_iframe()
    cy.get('.demo-frame')
    .then(($iframe) => {
    const $menu = $iframe.contents().find('body')
    let list4 = cy.wrap($menu)
    list4.find('#menu>li:nth-child(4)',{timeout:1200}).trigger('mouseover')
    .find('div' , 'Electronics').should('have.css', 'color', 'rgb(255, 255, 255)')

    let list41 = cy.wrap($menu)
    list41.find('#menu>li:nth-child(4)>ul',{timeout:1200}).trigger('mouseover')
    .find('li', 'Home Entertainment').should('have.css' , 'opacity', '0.35')
    let list42 = cy.wrap($menu)
    list42.find('#ui-id-6',{timeout:1200}).trigger('mouseover')
    .contains('div' , 'Car Hifi').should('have.css', 'color', 'rgb(255, 255, 255)')
    .click({force : true})
    let list43 = cy.wrap($menu)
    list43.find('#ui-id-7',{timeout:1200}).trigger('mouseover')
    .contains('div' , 'Utilities').should('have.css', 'color', 'rgb(255, 255, 255)')
    .click({force : true})
    })
  })

  it('Visits Menu_Lists5', function(){
    const rd = new cypressTest()
    rd.chck_iframe()
    cy.get('.demo-frame')
    .then(($iframe) => {
    const $menu = $iframe.contents().find('body')
    let list5 = cy.wrap($menu)
    .find('#ui-id-8',{timeout:1200}).trigger('mouseover')
    .contains('div', 'Movies').should('have.css', 'color', 'rgb(255, 255, 255)')
    .click({force : true})
    })
  })

  it('Visits Menu_Lists6', function(){
    const rd = new cypressTest()
    rd.chck_iframe()
    cy.get('.demo-frame')
    .then(($iframe) => {
    const $menu = $iframe.contents().find('body')
    let list6 = cy.wrap($menu)
    list6.find('#menu>li:nth-child(6)',{timeout:800}).trigger('mouseover')
    .find('div' , 'Music').should('have.css', 'color', 'rgb(255, 255, 255)')

    let list61 = cy.wrap($menu)
    list61.find('#ui-id-10',{timeout:1200}).trigger('mouseover')
    .contains('div', 'Rock').should('have.css' , 'color', 'rgb(255, 255, 255)')
    .click({force: true})

    let list62 = cy.wrap($menu)
    list62.find('#ui-id-11',{timeout:1200}).trigger('mouseover')
    .contains('div' , 'Alternative').should('have.css', 'color', 'rgb(255, 255, 255)')
    .click({force : true})

     let list63 = cy.wrap($menu)
    list63.find('#ui-id-12',{timeout:1200}).trigger('mouseover')
    .contains('div' , 'Classic').should('have.css', 'color', 'rgb(255, 255, 255)')
    .click({force : true})

    let list64 = cy.wrap($menu)
    list64.find('#ui-id-13',{timeout:1200}).trigger('mouseover')
    .contains('div' , 'Jazz').should('have.css', 'color', 'rgb(255, 255, 255)')
    .click({force : true})

    let list65 = cy.wrap($menu)
    list65.find('#ui-id-14',{timeout:1200}).trigger('mouseover')
    .contains('div' , 'Freejazz').should('have.css', 'color', 'rgb(255, 255, 255)')
    .click({force : true})

    let list66 = cy.wrap($menu)
    list66.find('#ui-id-15',{timeout:1200}).trigger('mouseover')
    .contains('div' , 'Big Band').should('have.css', 'color', 'rgb(255, 255, 255)')
    .click({force : true})

    let list67 = cy.wrap($menu)
    list67.find('#ui-id-16',{timeout:1200}).trigger('mouseover')
    .contains('div' , 'Modern').should('have.css', 'color', 'rgb(255, 255, 255)')
    .click({force : true})

    let list68 = cy.wrap($menu)
    list68.find('#ui-id-17',{timeout:1200}).trigger('mouseover')
    .contains('div' , 'Pop').should('have.css', 'color', 'rgb(255, 255, 255)')
    .click({force : true})
    })
  })

  it('Visits Menu_Lists7', function(){
    const rd = new cypressTest()
    rd.chck_iframe()
    cy.get('.demo-frame')
    .then(($iframe) => {
    const $menu = $iframe.contents().find('body')
    let list7 = cy.wrap($menu)
    list7.find('#menu>li:nth-child(7)')
    .contains('li' , 'Specials (n/a)').should('have.css', 'opacity', '0.35')
    })
  })

})

describe('Visits Progressbar', function(){
  it('Visits jQuery_Progressbar', function(){
    const rd = new cypressTest()
    rd.visit8()
    cy.url().then(url => {
    cy.url().should('be.eq', url);
    })
  })

  it('Visits Presence_of_Progressbar', function(){
    const rd = new cypressTest()
    rd.chck_iframe()
    cy.get('.demo-frame')
    .then(($iframe) => {
    const $progress = $iframe.contents().find('body')
    let prg = cy.wrap($progress)
    .find('#progressbar').should('have.css', 'border', '1px solid rgb(197, 197, 197)')
    .should('be.visible')

    let prg1 = cy.wrap($progress)
    .find('.ui-progressbar-value',{timeout:1200}).invoke('attr', 'style', 'width:90%')
    .should('have.css', 'width', '380.6875px')
    })
  })
})

describe('Visits Selectmenu', function(){
  it('Visits jQuery_Selectmenu', function(){
    const rd = new cypressTest()
    rd.visit9()
    cy.url().then(url => {
    cy.url().should('be.eq', url);
    })
  })

  it('Selects a speed', function(){
    cy.get('.demo-frame')
    .then(($iframe) => {
    const $body = $iframe.contents().find('body')

    cy.wrap($body)
    .find('#speed').scrollIntoView()
    .select('Medium', {force: true})
    .should('contain.value', 'Medium')
    })
  })

  it('Selects Slower_option', function(){
    cy.get('.demo-frame')
    .then(($iframe) => {
    const $body = $iframe.contents().find('body')

    cy.wrap($body)
    .find('#speed-button').click({force: true})
    .type('{uparrow}')
    .type('{uparrow}')
    .wait(800)
    .type('{enter}')
    expect({ name: 'Slower' }).to.deep.equal({ name: 'Slower' })
      })
    })

  it('Selects Slow_option', function(){
    cy.get('.demo-frame')
    .then(($iframe) => {
    const $body = $iframe.contents().find('body')

    cy.wrap($body)
    .find('#speed-button').click({force: true})
    .type('{downarrow}')
    .wait(800)
    .type('{enter}')
    expect({ name: 'Slow' }).to.deep.equal({ name: 'Slow' })
      })
    })

  it('Selects Medium_option', function(){
    cy.get('.demo-frame')
    .then(($iframe) => {
    const $body = $iframe.contents().find('body')

    cy.wrap($body)
    .find('#speed-button').click({force: true})
    .type('{downarrow}')
    .wait(800)
    .type('{enter}')
    expect({ name: 'Medium' }).to.deep.equal({ name: 'Medium' })
      })
    })

  it('Selects Fast_option', function(){
    cy.get('.demo-frame')
    .then(($iframe) => {
    const $body = $iframe.contents().find('body')

    cy.wrap($body)
    .find('#speed-button').click({force: true})
    .type('{downarrow}')
    .wait(800)
    .type('{enter}')
    expect({ name: 'Fast' }).to.deep.equal({ name: 'Fast' })
    })
  })

  it('Selects Faster_option', function(){
    cy.get('.demo-frame')
    .then(($iframe) => {
    const $body = $iframe.contents().find('body')

    cy.wrap($body)
    .find('#speed-button').click({force: true})
    .type('{downarrow}')
    .wait(800)
    .type('{enter}')
    expect({ name: 'Faster' }).to.deep.equal({ name: 'Faster' })

    })
  })

  it('Select a file', function(){
    cy.get('.demo-frame')
    .then(($iframe) => {
    const $body = $iframe.contents().find('body')

    cy.wrap($body)
    .find('#files-button').scrollIntoView()
    .click({force:true})
    .wait(800)
    .type('{enter}')
    .should('have.attr', 'aria-activedescendant', 'ui-id-6')
    .should('contain.text', 'jQuery.js')
    })
  })

  it('Selects uiQuery_option', function(){
    cy.get('.demo-frame')
    .then(($iframe) => {
    const $body = $iframe.contents().find('body')
    cy.wrap($body)
    .find('#files-button').click({force: true})
    .type('{downarrow}')
    .wait(800)
    .type('{enter}')

    .should('have.attr', 'aria-activedescendant', 'ui-id-7')
    })
  })

  it('Selects Some_unknown_file_option', function(){
    cy.get('.demo-frame')
    .then(($iframe) => {
    const $body = $iframe.contents().find('body')
    cy.wrap($body)
    .find('#files-button').click({force: true})
    .type('{downarrow}')
    .wait(800)
    .type('{enter}')

    .should('have.attr', 'aria-activedescendant', 'ui-id-8')
    })
  })

  it('Selects Some_other_file_option', function(){
    cy.get('.demo-frame')
    .then(($iframe) => {
    const $body = $iframe.contents().find('body')
    cy.wrap($body)
    .find('#files-button').click({force: true})
    .type('{downarrow}')
    .wait(800)
    .type('{enter}')

    .should('have.attr', 'aria-activedescendant', 'ui-id-9')
    })
  })

  it('Select a number', function(){
    cy.get('.demo-frame')
    .then(($iframe) => {
    const $body = $iframe.contents().find('body')

    cy.wrap($body)
    .find('#number-button').scrollIntoView()
    .click({force:true})
    .wait(800)
    .type('{enter}')
    .should('have.attr', 'aria-activedescendant', 'ui-id-11')
    .should('contain.text', '2')

    })
  })

  it('Selects num1_option', function(){
    cy.get('.demo-frame')
    .then(($iframe) => {
    const $body = $iframe.contents().find('body')

    cy.wrap($body)
    .find('#number-button').click({force: true})
    .type('{uparrow}')
    .type('{enter}')
    .should('have.attr', 'aria-activedescendant', 'ui-id-10')
    })
  })

  it('Selects num3_option', function(){
    cy.get('.demo-frame')
    .then(($iframe) => {
    const $body = $iframe.contents().find('body')

    cy.wrap($body)
    .find('#number-button').click({force: true})
    .type('{downarrow}')
    .type('{downarrow}')
    .type('{enter}')
    .should('have.attr', 'aria-activedescendant', 'ui-id-12')
    })
  })

  it('Selects num4_option', function(){
    cy.get('.demo-frame')
    .then(($iframe) => {
    const $body = $iframe.contents().find('body')

    cy.wrap($body)
    .find('#number-button').click({force: true})
    .type('{downarrow}')
    .type('{enter}')
    .should('have.attr', 'aria-activedescendant', 'ui-id-13')
    })
  })

  it('Selects num5_option', function(){
    cy.get('.demo-frame')
    .then(($iframe) => {
    const $body = $iframe.contents().find('body')

    cy.wrap($body)
    .find('#number-button').click({force: true})
    .type('{downarrow}')
    .type('{enter}')
    .should('have.attr', 'aria-activedescendant', 'ui-id-14')
    })
  })

  it('Selects num6_option', function(){
    cy.get('.demo-frame')
    .then(($iframe) => {
    const $body = $iframe.contents().find('body')

    cy.wrap($body)
    .find('#number-button').click({force: true})
    .type('{downarrow}')
    .type('{enter}')
    .should('have.attr', 'aria-activedescendant', 'ui-id-15')
    })
  })

  it('Selects num7_option', function(){
    cy.get('.demo-frame')
    .then(($iframe) => {
    const $body = $iframe.contents().find('body')

    cy.wrap($body)
    .find('#number-button').click({force: true})
    .type('{downarrow}')
    .type('{enter}')
    .should('have.attr', 'aria-activedescendant', 'ui-id-16')
    })
  })

  it('Selects num8_option', function(){
    cy.get('.demo-frame')
    .then(($iframe) => {
    const $body = $iframe.contents().find('body')

    cy.wrap($body)
    .find('#number-button').click({force: true})
    .type('{downarrow}')
    .type('{enter}')
    .should('have.attr', 'aria-activedescendant', 'ui-id-17')
    })
  })

  it('Selects num9_option', function(){
    cy.get('.demo-frame')
    .then(($iframe) => {
    const $body = $iframe.contents().find('body')

    cy.wrap($body)
    .find('#number-button').click({force: true})
    .type('{downarrow}')
    .type('{enter}')
    .should('have.attr', 'aria-activedescendant', 'ui-id-18')
    })
  })

  it('Selects num10_option', function(){
    cy.get('.demo-frame')
    .then(($iframe) => {
    const $body = $iframe.contents().find('body')

    cy.wrap($body)
    .find('#number-button').click({force: true})
    .type('{downarrow}')
    .type('{enter}')
    .should('have.attr', 'aria-activedescendant', 'ui-id-19')
    })
  })

  it('Selects num11_option', function(){
    cy.get('.demo-frame')
    .then(($iframe) => {
    const $body = $iframe.contents().find('body')

    cy.wrap($body)
    .find('#number-button').click({force: true})
    .type('{downarrow}')
    .type('{enter}')
    .should('have.attr', 'aria-activedescendant', 'ui-id-20')
    })
  })

  it('Selects num12_option', function(){
    cy.get('.demo-frame')
    .then(($iframe) => {
    const $body = $iframe.contents().find('body')

    cy.wrap($body)
    .find('#number-button').click({force: true})
    .type('{downarrow}')
    .type('{enter}')
    .should('have.attr', 'aria-activedescendant', 'ui-id-21')
    })
  })

  it('Selects num13_option', function(){
    cy.get('.demo-frame')
    .then(($iframe) => {
    const $body = $iframe.contents().find('body')

    cy.wrap($body)
    .find('#number-button').click({force: true})
    .type('{downarrow}')
    .type('{enter}')
    .should('have.attr', 'aria-activedescendant', 'ui-id-22')
    })
  })

  it('Selects num14_option', function(){
    cy.get('.demo-frame')
    .then(($iframe) => {
    const $body = $iframe.contents().find('body')

    cy.wrap($body)
    .find('#number-button').click({force: true})
    .type('{downarrow}')
    .type('{enter}')
    .should('have.attr', 'aria-activedescendant', 'ui-id-23')
    })
  })

  it('Selects num15_option', function(){
    cy.get('.demo-frame')
    .then(($iframe) => {
    const $body = $iframe.contents().find('body')

    cy.wrap($body)
    .find('#number-button').click({force: true})
    .type('{downarrow}')
    .type('{enter}')
    .should('have.attr', 'aria-activedescendant', 'ui-id-24')
    })
  })

  it('Selects num16_option', function(){
    cy.get('.demo-frame')
    .then(($iframe) => {
    const $body = $iframe.contents().find('body')

    cy.wrap($body)
    .find('#number-button').click({force: true})
    .type('{downarrow}')
    .type('{enter}')
    .should('have.attr', 'aria-activedescendant', 'ui-id-25')
    })
  })

  it('Selects num17_option', function(){
    cy.get('.demo-frame')
    .then(($iframe) => {
    const $body = $iframe.contents().find('body')

    cy.wrap($body)
    .find('#number-button').click({force: true})
    .type('{downarrow}')
    .type('{enter}')
    .should('have.attr', 'aria-activedescendant', 'ui-id-26')
    })
  })

  it('Selects num18_option', function(){
    cy.get('.demo-frame')
    .then(($iframe) => {
    const $body = $iframe.contents().find('body')

    cy.wrap($body)
    .find('#number-button').click({force: true})
    .type('{downarrow}')
    .type('{enter}')
    .should('have.attr', 'aria-activedescendant', 'ui-id-27')
    })
  })

  it('Selects num19_option', function(){
    cy.get('.demo-frame')
    .then(($iframe) => {
    const $body = $iframe.contents().find('body')

    cy.wrap($body)
    .find('#number-button').click({force: true})
    .type('{downarrow}')
    .type('{enter}')
    .should('have.attr', 'aria-activedescendant', 'ui-id-28')
    })
  })

  it('Selects a title', function(){
    cy.get('.demo-frame')
    .then(($iframe) => {
    const $body = $iframe.contents().find('body')

    cy.wrap($body)
    .find('#salutation').scrollIntoView().should('have.css', 'display', 'none')
    .contains('Please pick one')
    .should('contain.value', 'Please pick one')
    })
  })

  it('Selects Mr._option', function(){
    cy.get('.demo-frame')
    .then(($iframe) => {
    const $body = $iframe.contents().find('body')

    cy.wrap($body)
    .find('#salutation-button').click({force: true})
    .type('{downarrow}')
    .type('{enter}')
    .should('have.attr', 'aria-activedescendant', 'ui-id-30')

    let title = cy.wrap($body)
    title.find('.ui-selectmenu-text').should('contain.text','Mr.')
    })
  })

  it('Selects Mrs._option', function(){
    cy.get('.demo-frame')
    .then(($iframe) => {
    const $body = $iframe.contents().find('body')

    cy.wrap($body)
    .find('#salutation-button').click({force: true})
    .type('{downarrow}')
    .type('{enter}')
    .should('have.attr', 'aria-activedescendant', 'ui-id-31')

    let title = cy.wrap($body)
    title.find('.ui-selectmenu-text').should('contain.text','Mrs.')
    })
  })

  it('Selects Dr._option', function(){
    cy.get('.demo-frame')
    .then(($iframe) => {
    const $body = $iframe.contents().find('body')

    cy.wrap($body)
    .find('#salutation-button').click({force: true})
    .type('{downarrow}')
    .type('{enter}')
    .should('have.attr', 'aria-activedescendant', 'ui-id-32')

    let title = cy.wrap($body)
    title.find('.ui-selectmenu-text').should('contain.text','Dr.')
    })
  })

  it('Selects Prof._option', function(){
    cy.get('.demo-frame')
    .then(($iframe) => {
    const $body = $iframe.contents().find('body')

    cy.wrap($body)
    .find('#salutation-button').click({force: true})
    .type('{downarrow}')
    .type('{enter}')
    .should('have.attr', 'aria-activedescendant', 'ui-id-33')

    let title = cy.wrap($body)
    title.find('.ui-selectmenu-text').should('contain.text','Prof.')
    })
  })

  it('Selects Other_option', function(){
    cy.get('.demo-frame')
    .then(($iframe) => {
    const $body = $iframe.contents().find('body')

    cy.wrap($body)
    .find('#salutation-button').click({force: true})
    .type('{downarrow}')
    .type('{enter}')
    .should('have.attr', 'aria-activedescendant', 'ui-id-34')

    let title = cy.wrap($body)
    title.find('.ui-selectmenu-text').should('contain.text','Other')
    })
  })
})

describe('Visits Slider', function(){
  it('Visits jQuery_Slider', function(){
    const rd = new cypressTest()
    rd.visit10()
    cy.url().then(url => {
    cy.url().should('be.eq', url);
    })
  })

  it('Moves_the_slider_using_click', function(){
    cy.get('.demo-frame')
    .then(($iframe) => {
    const $body = $iframe.contents().find('body')

    cy.wrap($body)
    .find('#slider').click(200,0,{force:true}).should('have.css', 'border', '1px solid rgb(197, 197, 197)')
    .should('be.visible')
    })
  })

  it('Moves the slider using handler', function(){
    cy.get('.demo-frame')
    .then(($iframe) => {
    const $body = $iframe.contents().find('body')

    cy.wrap($body)
      .find('.ui-slider-handle').invoke('attr', 'style', 'left : 90%')
      .should('have.css', 'left', '380.688px')
      .should('have.css', 'color', 'rgb(43, 43, 43)')
    })
  })
})

describe('Visits Spinner', function(){
  it('Visits jQuery_Spinner', function(){
    const rd = new cypressTest()
    rd.visit11()
    cy.url().then(url => {
    cy.url().should('be.eq', url);
    })
  })

  it('Empty_value check', function(){
    cy.get('.demo-frame')
    .then(($iframe) => {
    const $body = $iframe.contents().find('body')

    cy.wrap($body)
    // .find('#getvalue').click()
    // cy.on('window:alert',(text)=>{
    //   console.log(text);
    //   cy.expect(text).to.contains('null')
      Cypress.on("uncaught:exception", (err, runnable) => {

        return false;
      });

      cy.on("window:alert", (str) => {

        expect(str).to.equal("null");
      cy.get('[id="getvalue"]').click();
      });
    });


  })

  it('Disable/Enable button', function(){
    cy.get('.demo-frame')
    .then(($iframe) => {
    const $body = $iframe.contents().find('body')

    cy.wrap($body)
    .find('#disable').click()

    let dis1  = cy.wrap($body)
    dis1.find('#spinner').should('have.attr','disabled')
    .wait(1000)

    let enb = cy.wrap($body)
    enb.find('#disable').click()

    let tw = cy.wrap($body)
    tw.find('#destroy').click({force:true})

    let dis2 = cy.wrap($body)
    dis2.find('#spinner').should('not.have.attr', 'autocomplete', 'off')

    let enb1 = cy.wrap($body)
    enb1.find('#destroy').click({force:true})

    let enb2 = cy.wrap($body)
    enb2.find('#spinner').should('have.attr', 'role', 'spinbutton')
    })
  })

  it('All_Checks_', function(){
    cy.get('.demo-frame')
    .then(($iframe) => {
    const $body = $iframe.contents().find('body')

    let spl = cy.wrap($body)
      spl.find('#spinner').click()
      .type('@##$!%^&*!()_+')
      .should('be.enabled')

      let spl1 = cy.wrap($body)
      Cypress.on("uncaught:exception", (err, runnable) => {

        return false;
      });

      cy.on("window:alert", (str) => {

        expect(str).to.equal("null");
      cy.get('[id="getvalue"]').click();
      });

      let ltr = cy.wrap($body)
      ltr.find('#spinner').click()
      .clear()
      .type('rdtfhAtfuieop')

      let spl2 = cy.wrap($body)
      Cypress.on("uncaught:exception", (err, runnable) => {

        return false;
      });

      cy.on("window:alert", (str) => {

        expect(str).to.equal("null");

      cy.get('[id="getvalue"]').click();
      });

      let nums = cy.wrap($body)
      nums.find('#spinner').click()
      .clear()
      .type('32')

      let spl3 = cy.wrap($body)
      Cypress.on("uncaught:exception", (err, runnable) => {

        return false;
      });

      cy.on("window:alert", (str) => {

        expect(str).to.equal("32");

      cy.get('[id="getvalue"]').click();
      expect({ name: '32' }).to.deep.equal({ name: '32' })
      });


      let nums1 = cy.wrap($body)
      nums1.find('#spinner').click()
      .type('{uparrow}')
      .type('{uparrow}')
      .type('{uparrow}')
      .type('{uparrow}')

      let spl4 = cy.wrap($body)
      Cypress.on("uncaught:exception", (err, runnable) => {

        return false;
      });

      cy.on("window:alert", (str) => {

        expect(str).to.equal("36");

      cy.get('[id="getvalue"]').click();
      expect({ name: '36' }).to.deep.equal({ name: '36' })
      });
      let val2 = cy.wrap($body)
      val2.find('#spinner').should('have.attr', 'aria-valuenow', '36')

    })
  })

  it('Set Value to 5', function(){
    cy.get('.demo-frame')
    .then(($iframe) => {
    const $body = $iframe.contents().find('body')

    let set_val = cy.wrap($body)
    .find('#setvalue').click()

    let val3 = cy.wrap($body)
    .find('#spinner').should('have.attr', 'aria-valuenow', '5')

    let set_val1 = cy.wrap($body)
    .find('#spinner').click({force:true})
    .type('{uparrow}')
    .type('{uparrow}')
    .type('{uparrow}')
    .type('{uparrow}')
    .type('{uparrow}')
      .should('have.attr', 'aria-valuenow', '10')
    })
  })


})

describe('Visits Tabs', function(){
  it('Visits jQuery_Tabs', function(){
    const rd = new cypressTest()
    rd.visit12()
    cy.url().then(url => {
    cy.url().should('be.eq', url);
    })
  })

  it('Visits Tab1', function(){
    cy.get('.demo-frame')
    .then(($iframe) => {
    const $body = $iframe.contents().find('body')

     let tab1 = cy.wrap($body)
     tab1.find('#ui-id-1').should('contain.text','Nunc tincidunt')
     let tab11 = cy.wrap($body)
     tab11.find('.ui-tabs-active').should('have.css', 'background', 'rgb(0, 127, 255) none repeat scroll 0% 0% / auto padding-box border-box')

     let tab1_p = cy.wrap($body)
     tab1_p.find('#tabs-1 > p').should('contain.text', 'Proin elit arcu')
    })
  })

  it('Visits Tab2', function(){
    cy.get('.demo-frame')
    .then(($iframe) => {
    const $body = $iframe.contents().find('body')

     let tab2 = cy.wrap($body)
     tab2.find('#ui-id-2').click({force:true})
     .wait(300)
     .should('contain.text','Proin dolor')
     let tab21 = cy.wrap($body)
     tab21.find('.ui-tabs-active').should('have.css', 'background', 'rgb(0, 127, 255) none repeat scroll 0% 0% / auto padding-box border-box')

     let tab2_p = cy.wrap($body)
     tab2_p.find('#tabs-2 > p').should('contain.text', 'Morbi tincidunt')
    })
  })

  it('Visits Tab3', function(){
    cy.get('.demo-frame')
    .then(($iframe) => {
    const $body = $iframe.contents().find('body')

     let tab3 = cy.wrap($body)
     tab3.find('#ui-id-3').click({force:true})
     .wait(300)
     .should('contain.text','Aenean lacinia')
     let tab31 = cy.wrap($body)
     tab31.find('.ui-tabs-active').should('have.css', 'background', 'rgb(0, 127, 255) none repeat scroll 0% 0% / auto padding-box border-box')

     let tab3_p = cy.wrap($body)
     tab3_p.find('#tabs-3 > p').should('contain.text', 'Mauris eleifend est et turpis')
    })
  })


})

describe('Visits Tooltip', function(){
  it('Visits jQuery_Tooltip', function(){
    const rd = new cypressTest()
    rd.visit13()
    cy.url().then(url => {
    cy.url().should('be.eq', url);
    })
  })

  it('Visits links_Tooltip', function(){
    cy.get('.demo-frame')
    .then(($iframe) => {
    const $body = $iframe.contents().find('body')

    let link1 = cy.wrap($body)
    link1.find('p:nth-child(1) > a').should('have.attr', 'title', "That's what this widget is")
    .trigger('mouseover').should('have.attr', 'aria-describedby' , 'ui-id-1')
    .wait(800)
    .click()

    let link2 = cy.wrap($body)
    link2.find('p:nth-child(2) > a').should('have.attr', 'title', "ThemeRoller: jQuery UI's theme builder application")
    .trigger('mouseover').should('have.attr', 'aria-describedby' , 'ui-id-2')
    .wait(800)
    .click()
    })
  })

  it('Visits inputbox_Tooltip', function(){
    cy.get('.demo-frame')
    .then(($iframe) => {
    const $body = $iframe.contents().find('body')

    let inp = cy.wrap($body)
    inp.find('#age').should('have.attr', 'title', "We ask for your age only for statistical purposes.")
    .trigger('mouseover').should('have.attr', 'aria-describedby' , 'ui-id-3')
    .wait(800)
    })
  })
})


